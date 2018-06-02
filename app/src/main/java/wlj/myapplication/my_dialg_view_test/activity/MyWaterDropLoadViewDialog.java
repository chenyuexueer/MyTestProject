package wlj.myapplication.my_dialg_view_test.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Window;

import wlj.myapplication.R;
import wlj.myapplication.my_dialg_view_test.view.MyWaterDropLoadView;
import wlj.myapplication.my_dialg_view_test.view.view_options.MyWaterDropLoadViewOption;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/30.
 * 说明：加载动画，水滴状的
 * ================================================
 */

public class MyWaterDropLoadViewDialog extends Dialog {

    private MyWaterDropLoadView myWaterDropLoadView;

    public MyWaterDropLoadViewDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);// 去除屏幕title
        setContentView(R.layout.my_water_drop_load_view);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        myWaterDropLoadView = (MyWaterDropLoadView) findViewById(R.id.my_water_drop_load_view);
        myWaterDropLoadView.setOption(new MyWaterDropLoadViewOption(new MyWaterDropLoadViewOption.Builder()));
    }
}
