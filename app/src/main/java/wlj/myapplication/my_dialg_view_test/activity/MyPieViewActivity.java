package wlj.myapplication.my_dialg_view_test.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import wlj.myapplication.R;
import wlj.myapplication.my_dialg_view_test.view.MyPieView;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/29.
 * 说明：收入支出管理  饼图
 * ================================================
 */

public class MyPieViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_pie_view);

        MyPieView pieView = (MyPieView) findViewById(R.id.pie);
        pieView.setGreenSize(394);
        pieView.setRedSize(765);
    }
}
