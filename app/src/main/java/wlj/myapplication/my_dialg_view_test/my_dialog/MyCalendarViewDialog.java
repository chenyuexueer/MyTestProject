package wlj.myapplication.my_dialg_view_test.my_dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import java.util.Calendar;

import wlj.myapplication.R;
import wlj.myapplication.my_dialg_view_test.view.MyCalendarView;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/29.
 * 说明：
 * ================================================
 */

public class MyCalendarViewDialog extends Dialog implements View.OnClickListener,
        MyCalendarView.CalendarViewListener {
    /**
     * 日历视图
     */
    private MyCalendarView calendarView;
    /**
     * 月份
     */
    private TextView monthView;
    /**
     * 年份
     */
    private TextView yearView;
    /**
     * 左按钮
     */
    private View leftView;
    /**
     * 右按钮
     */
    private View rightView;
    /**
     * 确定按钮
     */
    private TextView enterView;
    /**
     * 取消按钮
     */
    private TextView escView;
    /**
     * 月
     */
    private int month;
    /**
     * 年
     */
    private int year;
    /**
     * 日
     */
    private int day;
    /**
     * 今天
     */
    private int today;
    /**
     * 今年
     */
    private int thisYear;
    /**
     * 本月
     */
    private int thisMonth;
    /**
     * 回调
     */
    private CalendarDialogListener lis;
    /**
     * 起始年
     */
    private int startYear = -1;
    /**
     * 起始月
     */
    private int startMonth = -1;
    /**
     * 起始天
     */
    private int startDay = -1;
    /**
     * 日历滑动方式
     */
    private MyCalendarView.SlideType slideType = MyCalendarView.SlideType.Both;

    public interface CalendarDialogListener {
        public void calendarDialogListener(int year, int month, int day);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);// 去除屏幕title
        setContentView(R.layout.my_dialog_calendar_view);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        calendarView = (MyCalendarView) findViewById(R.id.dialog_calender_calender);
        monthView = (TextView) findViewById(R.id.dialog_calender_month);
        yearView = (TextView) findViewById(R.id.dialog_calender_year);
        leftView = findViewById(R.id.dialog_calender_left);
        rightView = findViewById(R.id.dialog_calender_right);
        enterView = (TextView) findViewById(R.id.dialog_calender_enter);
        escView = (TextView) findViewById(R.id.dialog_calender_esc);
        leftView.setOnClickListener(this);
        rightView.setOnClickListener(this);
        enterView.setOnClickListener(this);
        escView.setOnClickListener(this);
        calendarView.setCalendarViewListener(this);
        calendarView.setSlideType(slideType);
        init();
    }

    private void init() {
        enterView.setText("确定");
        escView.setText("取消");
        monthView.setText(month + "月");
        yearView.setText(year + "年");
        Calendar calendar = Calendar.getInstance();
        today = calendar.get(Calendar.DAY_OF_MONTH);
        thisMonth = calendar.get(Calendar.MONTH) + 1;
        thisYear = calendar.get(Calendar.YEAR);
        calendarView.setData(year, month, today, day,year, month);
        calendarStartSet();
        calendarView.setStart(startYear, startMonth, startDay);
    }

    private void calendarStartSet(){
        if(startYear>0 && startMonth>0 && startDay>0){
            if(year < startYear && month < startMonth){
                calendarView.setItems(0, 0);
            }else if(year == startYear && month == startMonth){
                calendarView.setItems(startDay, 31);
            }
        }
    }

    /**
     * 创建一个日期选择器    构造方法
     * 传入默认的时间
     * @param context
     * @param month
     * @param year
     * @param day
     * @param lis
     */
    public MyCalendarViewDialog(Context context, int month, int year, int day,
                                MyCalendarView.SlideType slideType, CalendarDialogListener lis) {
        super(context);
        this.month = month;
        this.year = year;
        this.day = day;
        this.lis = lis;
        this.slideType = slideType;
    }
    /**
     * 创建一个有限制的时间选择器        构造方法
     * @param context
     * @param month
     * @param year
     * @param day
     * @param startMonth 有效选择的开始月份
     * @param startYear 有效选择的开始年份
     * @param startDay 有效选择的开始天
     * @param lis
     */
    public MyCalendarViewDialog(Context context, int month, int year, int day, int startMonth, int startYear, int startDay,
                                MyCalendarView.SlideType slideType, CalendarDialogListener lis) {
        super(context);
        this.month = month;
        this.year = year;
        this.day = day;
        this.lis = lis;
        this.startMonth = startMonth;
        this.startYear = startYear;
        this.startDay = startDay;
        this.slideType = slideType;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dialog_calender_left:
                month--;
                if(startMonth>0&&startYear>0&&month<=startMonth&&year <= startYear){
                    leftView.setVisibility(View.INVISIBLE);
                    month=startMonth;
                }
                if(month<1){
                    year--;
                    month = 12;
                }
                yearView.setText(year+"年");
                monthView.setText(month+"月");
                if(year == thisYear && month==thisMonth){
                    calendarView.setData(year, month, today, day,year, month);
                }else{
                    calendarView.setData(year, month, 0, day,year, month);
                }
                calendarStartSet();
                break;
            case R.id.dialog_calender_right:
                month++;
                if(startMonth>0&&startYear>0&&month>startMonth&&year >= startYear){
                    leftView.setVisibility(View.VISIBLE);
                }
                if(month>12){
                    year++;
                    month = 1;
                }
                yearView.setText(year+"年");
                monthView.setText(month+"月");
                if(year == thisYear && month==thisMonth){
                    calendarView.setData(year, month, today, day,year, month);
                }else{
                    calendarView.setData(year, month, 0, day,year, month);
                }
                calendarStartSet();
                break;
            case R.id.dialog_calender_enter:
                lis.calendarDialogListener(year, month, day);
                dismiss();
                break;
            case R.id.dialog_calender_esc:
                dismiss();
                break;

        }
    }

    @Override
    public void calendarSelected(int year, int month, int d) {
        day = d;
    }

    @Override
    public void calendarChange(int year, int month) {
        this.year = year;
        this.month = month;
        yearView.setText(year+"年");
        monthView.setText(month+"月");
    }

    public MyCalendarView.SlideType getSlideType() {
        return slideType;
    }

    public void setSlideType(MyCalendarView.SlideType slideType) {
        this.slideType = slideType;
    }

}
