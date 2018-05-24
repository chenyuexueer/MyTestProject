package wlj.myapplication.mvp_demo.base;

import android.app.Application;
import android.content.Context;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/23.
 * 说明：MyMVPApplication
 * ================================================
 */

public class MyMVPApplication extends Application {
    private final String TAG = "MyMVPApplication";
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    /**
     * @return 全局的上下文
     */
    public static Context getContext() {
        return mContext;
    }
}
