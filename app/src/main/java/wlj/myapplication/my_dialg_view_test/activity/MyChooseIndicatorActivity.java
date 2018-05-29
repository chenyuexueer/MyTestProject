package wlj.myapplication.my_dialg_view_test.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import wlj.myapplication.R;
import wlj.myapplication.my_dialg_view_test.view.MyChooseBgView;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/29.
 * 说明：选择指示器(左右两个)
 * ================================================
 */

public class MyChooseIndicatorActivity extends AppCompatActivity {
    private MyChooseBgView myChooseBgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_dialog_choose_view);
        myChooseBgView = (MyChooseBgView) findViewById(R.id.c);
        Intent intent = getIntent();
        myChooseBgView.setStyle(intent.getBooleanExtra("type", true));
        myChooseBgView.setLeftName("左边");
        myChooseBgView.setRightName("右边");
        myChooseBgView.setChooseBgViewListener(new MyChooseBgView.ChooseBgViewListener() {
            @Override
            public void onChooseViewClick(boolean isLeft) {
                Toast.makeText(MyChooseIndicatorActivity.this, isLeft?"左":"右", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
