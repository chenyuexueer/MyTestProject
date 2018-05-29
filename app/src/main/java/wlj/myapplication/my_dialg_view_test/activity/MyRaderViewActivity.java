package wlj.myapplication.my_dialg_view_test.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

import wlj.myapplication.R;
import wlj.myapplication.my_dialg_view_test.view.MyRadarView;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/29.
 * 说明：雷达图
 * ================================================
 */

public class MyRaderViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_radar_view);
        MyRadarView radarView = (MyRadarView) findViewById(R.id.r);
        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < 7; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put(MyRadarView.VALUE_NAME, "小建" + i + "号");
            map.put(MyRadarView.VALUE_PERCENT, i * 20);
            map.put(MyRadarView.VALUE_VALUE, i * 20);
            list.add(map);
        }
        radarView.setDataArray(list);
    }
}
