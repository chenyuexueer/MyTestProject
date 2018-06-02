package wlj.myapplication.my_dialg_view_test.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import wlj.myapplication.my_dialg_view_test.view.MyGradualView;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/30.
 * 说明：一个渐变的动画View
 * ================================================
 */

public class MyGradualViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGradualView(this));
    }
}
