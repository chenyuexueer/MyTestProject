package wlj.myapplication.my_dialg_view_test.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import wlj.myapplication.R;
import wlj.myapplication.my_dialg_view_test.view.MyThermometerView;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/29.
 * 说明：温度计视图view
 * ================================================
 */

public class MyThermometerViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_thermometer_view);
        MyThermometerView thermometerView = (MyThermometerView) findViewById(R.id.t);
        thermometerView.setMax(100);
    }
}
