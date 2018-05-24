package wlj.myapplication.mvp_demo.utils;

import android.util.Log;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/23.
 * 说明：Log工具类
 * ================================================
 */

public class LogUtil {
    //规定每段显示的长度
    private static int LOG_MAXLENGTH = 2000;
    private LogUtil() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static final boolean isDebug = LogConfig.DEBUG;

    public static void e(String tag, String msg) {
        if (isDebug) {
            int strLength = msg.length();
            int start = 0;
            int end = LOG_MAXLENGTH;
            for (int i = 0; i < 100; i++) {
                //剩下的文本还是大于规定长度则继续重复截取并输出
                if (strLength > end) {
                    Log.e(tag + i, msg.substring(start, end));
                    start = end;
                    end = end + LOG_MAXLENGTH;
                } else {
                    Log.e(tag, msg.substring(start, strLength));
                    break;
                }
            }
        }
    }

    public static void e(Object object, String msg) {
        if (isDebug) {
            int strLength = msg.length();
            int start = 0;
            int end = LOG_MAXLENGTH;
            for (int i = 0; i < 100; i++) {
                //剩下的文本还是大于规定长度则继续重复截取并输出
                if (strLength > end) {
                    Log.e(object.getClass().getSimpleName() + i, msg.substring(start, end));
                    start = end;
                    end = end + LOG_MAXLENGTH;
                } else {
                    Log.e(object.getClass().getSimpleName(), msg.substring(start, strLength));
                    break;
                }
            }
        }
    }

}