package wlj.myapplication.drawerlayout_navigation_toolbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import wlj.myapplication.R;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/6/8.
 * 说明：其他drawerlayout 用法1
 * ================================================
 */
public class DrawerLayoutOtherActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout_other);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}
