package wlj.myapplication.drawerlayout_navigation_toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import wlj.myapplication.R;
import wlj.myapplication.my_dialg_view_test.activity.MyXiuXiuImageViewActivity;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/6/8.
 * 说明：通过模板生成的BasicActivity
 * ================================================
 */
public class DrawerLayoutActivityDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout_demo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.drawerlayout_navigation:
                startActivity(new Intent(this, DrawerlayoutNavigationViewActivity.class));
                break;
            case R.id.drawerlayout_navigation_below_toolbar:
                startActivity(new Intent(this, DrawerLayoutBelowToolbarActivity.class));
                break;
            case R.id.drawerlayout_navigation_other:
                startActivity(new Intent(this, DrawerLayoutOtherActivity.class));
                break;
                case R.id.drawerlayout_other2:
                startActivity(new Intent(this, MyXiuXiuImageViewActivity.class).putExtra("type", 1));
                break;
        }
    }
}
