package wlj.myapplication.my_dialg_view_test.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import wlj.myapplication.R;
import wlj.myapplication.my_dialg_view_test.view.MyLineChartView;
import wlj.myapplication.my_dialg_view_test.view.view_options.MyLineChartViewOption;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/30.
 * 说明：折线图
 * ================================================
 */

public class MyLineChartViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_linechart_view);
        MyLineChartView lLineChartView = (MyLineChartView) findViewById(R.id.linechart);
        MyLineChartView lLineChartView2 = (MyLineChartView) findViewById(R.id.linechart2);
        MyLineChartViewOption.Builder bu = new MyLineChartViewOption.Builder();
        bu.setLable(new String[]{"哈哈","嘻嘻","呵呵","呼呼","拉拉","呜呜"});
        lLineChartView.setOption(new MyLineChartViewOption(bu));
        bu.setIsCurve(false);
        lLineChartView2.setOption(new MyLineChartViewOption(bu));
        ArrayList<MyLineChartView.LLineChartBean> beans = new ArrayList<>();
        ArrayList<MyLineChartView.LLineChartBean> beans2 = new ArrayList<>();
        MyLineChartView.LLineChartBean b = lLineChartView.new LLineChartBean(new float[]{32,64,95,0,89,54}, Color.WHITE);
        MyLineChartView.LLineChartBean b2 = lLineChartView.new LLineChartBean(new float[]{85,36,18,56,32,17},Color.GREEN);
        beans.add(b);
        beans.add(b2);
        beans2.add(b2);
        beans2.add(b);
        lLineChartView.setBeans(beans);
        lLineChartView2.setBeans(beans2);
    }
}
