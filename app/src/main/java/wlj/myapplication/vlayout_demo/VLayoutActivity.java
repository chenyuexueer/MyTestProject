package wlj.myapplication.vlayout_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import wlj.myapplication.R;
import wlj.myapplication.vlayout_demo.vlayout_activity.AllActivity;
import wlj.myapplication.vlayout_demo.vlayout_activity.ColumnLayoutHelperActivity;
import wlj.myapplication.vlayout_demo.vlayout_activity.FixLayoutHelperActivity;
import wlj.myapplication.vlayout_demo.vlayout_activity.FloatLayoutHelperActivity;
import wlj.myapplication.vlayout_demo.vlayout_activity.GridLayoutHelperActivity;
import wlj.myapplication.vlayout_demo.vlayout_activity.LinearLayoutHelperActivity;
import wlj.myapplication.vlayout_demo.vlayout_activity.OnePlusNLayoutHelperActivity;
import wlj.myapplication.vlayout_demo.vlayout_activity.ScrollFixLayoutHelperActivity;
import wlj.myapplication.vlayout_demo.vlayout_activity.SingleLayoutHelperActivity;
import wlj.myapplication.vlayout_demo.vlayout_activity.StaggeredGridLayoutHelperActivity;
import wlj.myapplication.vlayout_demo.vlayout_activity.StickyLayoutHelperActivity;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/25.
 * 说明：VLayout总activity
 * ================================================
 */

public class VLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vlayout);
    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.linearLayoutHelper:
                startActivity(new Intent(this, LinearLayoutHelperActivity.class));
                break;
            case R.id.gridLayoutHelper:
                startActivity(new Intent(this, GridLayoutHelperActivity.class));
                break;
            case R.id.staggeredGridLayoutHelper:
                startActivity(new Intent(this, StaggeredGridLayoutHelperActivity.class));
                break;
            case R.id.fixLayoutHelper:
                startActivity(new Intent(this, FixLayoutHelperActivity.class));
                break;
            case R.id.scrollFixLayoutHelper:
                startActivity(new Intent(this, ScrollFixLayoutHelperActivity.class));
                break;
            case R.id.columnLayoutHelper:
                startActivity(new Intent(this, ColumnLayoutHelperActivity.class));
                break;
            case R.id.singleLayoutHelper:
                startActivity(new Intent(this, SingleLayoutHelperActivity.class));
                break;
            case R.id.onePlusNLayoutHelper:
                startActivity(new Intent(this, OnePlusNLayoutHelperActivity.class));
                break;
            case R.id.floatLayoutHelper:
                startActivity(new Intent(this, FloatLayoutHelperActivity.class));
                break;
            case R.id.stickyLayoutHelper:
                startActivity(new Intent(this, StickyLayoutHelperActivity.class));
                break;
            case R.id.all:
                startActivity(new Intent(this,AllActivity.class));
                break;
        }
    }
}
