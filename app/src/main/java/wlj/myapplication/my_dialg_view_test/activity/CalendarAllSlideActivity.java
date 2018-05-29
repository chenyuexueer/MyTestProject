package wlj.myapplication.my_dialg_view_test.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;

import wlj.myapplication.R;
import wlj.myapplication.my_dialg_view_test.my_dialog.MyCalendarViewDialog;
import wlj.myapplication.my_dialg_view_test.util.DialogUtil;
import wlj.myapplication.my_dialg_view_test.view.MyCalendarView;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/29.
 * 说明：
 * ================================================
 */

public class CalendarAllSlideActivity extends AppCompatActivity {

    private DialogUtil dialogUtil;

    private Calendar calendar;

    private boolean type;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);


        if (getIntent().hasExtra("type")) {
            type=getIntent().getBooleanExtra("type",true);
        }

        calendar = Calendar.getInstance();
        dialogUtil = new DialogUtil();

        findViewById(R.id.bt_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
        showDialog();
    }

    private void showDialog() {
        if (type){//全向拖拽

            dialogUtil.getCalendarDialog(
                    this,
                    calendar.get(Calendar.MONTH) + 1,
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.DAY_OF_MONTH),
                    MyCalendarView.SlideType.Both,//全向拖拽
                    new MyCalendarViewDialog.CalendarDialogListener() {
                        @Override
                        public void calendarDialogListener(int year, int month, int day) {
                            toast(year + "-" + month + "-" + day);
                        }
                    });
        }else {//单向横向拖拽

            dialogUtil.getCalendarDialog(
                    this,
                    calendar.get(Calendar.MONTH) + 1,
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.DAY_OF_MONTH),
                    MyCalendarView.SlideType.Horizontal,//单向横向拖拽
                    new MyCalendarViewDialog.CalendarDialogListener() {
                        @Override
                        public void calendarDialogListener(int year, int month, int day) {
                            toast(year + "-" + month + "-" + day);
                        }
                    });
        }

    }

    private void toast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
