package wlj.myapplication.my_dialg_view_test.util;

import android.app.Activity;
import android.app.Dialog;
import android.view.Display;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import wlj.myapplication.R;
import wlj.myapplication.my_dialg_view_test.activity.MyWaterDropLoadViewDialog;
import wlj.myapplication.my_dialg_view_test.my_dialog.MyCalendarViewDialog;
import wlj.myapplication.my_dialg_view_test.my_dialog.MyJumpWordLoadViewDialog;
import wlj.myapplication.my_dialg_view_test.my_dialog.MyLoadViewDialog;
import wlj.myapplication.my_dialg_view_test.my_dialog.MyProgressViewDialog;
import wlj.myapplication.my_dialg_view_test.my_dialog.MyWheelViewDialog;
import wlj.myapplication.my_dialg_view_test.view.MyCalendarView;
import wlj.myapplication.my_dialg_view_test.view.MyWheelView;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/29.
 * 说明：
 * ================================================
 */

public class DialogUtil {

    private double dialogWidthProportion = 0.7;
    private double dialogHeightProportion = 0.4;

//    public Dialog getClockDialog(Activity context, int hour, int minutes, ClockDialog.ClockDialogListener listener) {
//        ClockDialog dialog = new ClockDialog(context);
    //        dialog.setHours(hour);
    //        dialog.setMinutes(minutes);
    //        dialog.setListener(listener);
    //        Window window = dialog.getWindow();
    //        window.setGravity(Gravity.CENTER); // 此处可以设置dialog显示的位置
    //        dialog.setCancelable(true);
    //        dialog.show();
    //        WindowManager m = context.getWindowManager();
    //        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
    //        WindowManager.LayoutParams p = window.getAttributes(); // 获取对话框当前的参数值
    //        p.height = (int) (d.getHeight() * 0.6);
    //        p.width = (int) (d.getWidth() * dialogWidthProportion);
    //        dialog.onWindowAttributesChanged(p);
    //        window.setAttributes(p);
    //        return dialog;
//    }

    /**
     * 获取一个没有限制的日期选择对话框
     *
     * @param context
     * @param month
     * @param year
     * @param day
     * @param lis
     * @return
     */
    public Dialog getCalendarDialog(Activity context, int month, int year,
                                    int day, MyCalendarView.SlideType slideType, MyCalendarViewDialog.CalendarDialogListener lis) {
        MyCalendarViewDialog dialog = new MyCalendarViewDialog(context, month, year, day,
                slideType,lis);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.CENTER); // 此处可以设置dialog显示的位置
        dialog.setCancelable(true);
        dialog.show();
        WindowManager m = context.getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = window.getAttributes(); // 获取对话框当前的参数值
        p.height = (int) (d.getHeight() * dialogHeightProportion);
        p.width = (int) (d.getWidth() * dialogWidthProportion);
        dialog.onWindowAttributesChanged(p);
        window.setAttributes(p);
        return dialog;
    }
    /**
     * 获取一个有限制的日期选择对话框
     * @param context
     * @param month
     * @param year
     * @param day
     * @param startMonth 起始的月份
     * @param startYear 起始年份
     * @param startDay 起始日期
     * @param lis
     * @return
     */
    public Dialog getCalendarDialog(Activity context, int month, int year,
                                    int day, int startMonth, int startYear, int startDay,
                                    MyCalendarView.SlideType slideType, MyCalendarViewDialog.CalendarDialogListener lis) {
        MyCalendarViewDialog dialog = new MyCalendarViewDialog(context, month, year, day,
                startMonth, startYear, startDay,slideType, lis);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.CENTER); // 此处可以设置dialog显示的位置
        dialog.setCancelable(true);
        dialog.show();
        WindowManager m = context.getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = window.getAttributes(); // 获取对话框当前的参数值
        p.height = (int) (d.getHeight() * dialogHeightProportion);
        p.width = (int) (d.getWidth() * dialogWidthProportion);
        dialog.onWindowAttributesChanged(p);
        window.setAttributes(p);
        return dialog;
    }


    /**
     * 获取一个加载提示dialog
     *
     * @param context
     * @return
     */
    public Dialog getLoadDialog(Activity context) {
        MyLoadViewDialog dialog = new MyLoadViewDialog(context);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.CENTER); // 此处可以设置dialog显示的位置
        dialog.setCancelable(true);
        dialog.show();
        WindowManager m = context.getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = window.getAttributes(); // 获取对话框当前的参数值
        p.height = (int) (d.getHeight() * 0.2);
        p.width = (int) (d.getWidth() * 0.2);
        dialog.onWindowAttributesChanged(p);
        p.dimAmount = 0f;// 设置背景不变暗
        window.setAttributes(p);
        return dialog;
    }

    /**
     * 获取一个提交进度dialog
     *
     * @param context
     * @return
     */
    public Dialog getProgressDialog(Activity context, int allInt, int havingInt) {
        MyProgressViewDialog dialog = new MyProgressViewDialog(context, allInt, havingInt);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.CENTER); // 此处可以设置dialog显示的位置
        dialog.setCancelable(true);
        dialog.show();
        WindowManager m = context.getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = window.getAttributes(); // 获取对话框当前的参数值
        p.height = (int) (d.getHeight() * 0.6);
        p.width = (int) (d.getWidth() * 0.6);
        dialog.onWindowAttributesChanged(p);
        p.dimAmount = 0f;// 设置背景不变暗
        window.setAttributes(p);
        return dialog;
    }
        /**
         * 获取一个加载提示dialog
         *
         * 水滴状的
         *
         * @param context
         * @return
         */
        public Dialog getWaterDropViewLoadDialog(Activity context) {
            MyWaterDropLoadViewDialog dialog = new MyWaterDropLoadViewDialog(context);
            Window window = dialog.getWindow();
            window.setGravity(Gravity.CENTER); // 此处可以设置dialog显示的位置
            dialog.setCancelable(true);
            dialog.show();
            WindowManager m = context.getWindowManager();
            Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
            WindowManager.LayoutParams p = window.getAttributes(); // 获取对话框当前的参数值
            p.height = (int) (d.getHeight() * 0.5);
            p.width = (int) (d.getWidth() * 0.5);
            p.height = p.width = Math.min(p.height , p.width);
            dialog.onWindowAttributesChanged(p);
            p.dimAmount = 0f;// 设置背景不变暗
            window.setAttributes(p);
            return dialog;

    }
        /**
         * 获取一个加载提示dialog
         *
         * 跳动的文字加载动画
         *
         * @param context
         * @return
         */
        public Dialog getLoadDialog3(Activity context,int showType) {
            MyJumpWordLoadViewDialog dialog = new MyJumpWordLoadViewDialog(context,showType);
            Window window = dialog.getWindow();
            window.setGravity(Gravity.CENTER); // 此处可以设置dialog显示的位置
            dialog.setCancelable(true);
            dialog.show();
            WindowManager m = context.getWindowManager();
            Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
            WindowManager.LayoutParams p = window.getAttributes(); //获取对话框当前的参数值
            p.height = (int) (d.getHeight() * 0.5);
            p.width = (int) (d.getWidth() * 0.5);
            p.height = p.width = Math.min(p.height , p.width);
            dialog.onWindowAttributesChanged(p);
            p.dimAmount = 0f;// 设置背景不变暗
            window.setAttributes(p);
            return dialog;
    }


    /**
     * 获取一个时间滚轮选择器
     * @param context
     * @param type
     * @param listener
     * @return
     */
    public Dialog getWheelDialog(Activity context,MyWheelViewDialog.MyWheelDialogType type,MyWheelView.MyWheelViewListener listener){
        MyWheelViewDialog dialog = new MyWheelViewDialog(context, type, listener);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM); // 此处可以设置dialog显示的位置
        window.setWindowAnimations(R.style.dialogstyle_vertical); // 添加动画
        dialog.setCancelable(true);
        dialog.show();
        WindowManager m = context.getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = window.getAttributes(); // 获取对话框当前的参数值
        p.height = (int) (d.getHeight() * 0.5);
        p.width = (int) (d.getWidth());
        dialog.onWindowAttributesChanged(p);
        window.setAttributes(p);
        return dialog;
    }

    public DialogUtil(double dialogWidthProportion,
                      double dialogHeightProportion) {
        super();
        this.dialogWidthProportion = dialogWidthProportion;
        this.dialogHeightProportion = dialogHeightProportion;
    }

    public DialogUtil() {
        super();
    }

    public double getDialogWidthProportion() {
        return dialogWidthProportion;
    }

    public void setDialogWidthProportion(double dialogWidthProportion) {
        this.dialogWidthProportion = dialogWidthProportion;
    }

    public double getDialogHeightProportion() {
        return dialogHeightProportion;
    }

    public void setDialogHeightProportion(double dialogHeightProportion) {
        this.dialogHeightProportion = dialogHeightProportion;
    }

    public void setWidthAndHeight(double width, double height) {
        this.dialogHeightProportion = height;
        this.dialogWidthProportion = width;
    }

}

