package wlj.myapplication.mvp_demo.utils;

import wlj.myapplication.mvp_demo.base.MyMVPApplication;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/23.
 * 说明：Toast工具类
 * ================================================
 */

public class ToastUtil {
    public static void showShort(CharSequence message) {
        ToastCompat.makeText(MyMVPApplication.getContext(), message, ToastCompat.LENGTH_SHORT).show();
    }
    public static void showShort(int resId) {
        ToastCompat.makeText(MyMVPApplication.getContext(), resId, ToastCompat.LENGTH_SHORT).show();
    }
}
