package wlj.myapplication.my_dialg_view_test.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import wlj.myapplication.R;
import wlj.myapplication.my_dialg_view_test.view.MySlideButtonView;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/29.
 * 说明：滑动开关按钮
 * ================================================
 */

public class MySlideButtonViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_slide_button_view);

        MySlideButtonView buttonView = (MySlideButtonView) findViewById(R.id.b);
        buttonView.setOnSlideListener(new MySlideButtonView.SlideButtonViewListener() {
            @Override
            public void SlideButtonOnClick(MySlideButtonView SlideButtonView, boolean isOpen) {
                Toast.makeText(MySlideButtonViewActivity.this, isOpen + "", Toast.LENGTH_SHORT).show();
            }
        });

        MySlideButtonView buttonView2 = (MySlideButtonView) findViewById(R.id.btn);
        buttonView2.setOnSlideListener(new MySlideButtonView.SlideButtonViewListener() {
            @Override
            public void SlideButtonOnClick(MySlideButtonView SlideButtonView, boolean isOpen) {
                Toast.makeText(MySlideButtonViewActivity.this, isOpen + "", Toast.LENGTH_SHORT).show();
            }
        });

        MySlideButtonView buttonView3 = (MySlideButtonView) findViewById(R.id.btn2);
        buttonView3.setBtnType(false);
        buttonView3.setBtnColor(Color.WHITE);
        buttonView3.setOffColor(Color.GRAY);
        buttonView3.setTextColor(Color.GRAY);
        buttonView3.setOnSlideListener(new MySlideButtonView.SlideButtonViewListener() {
            @Override
            public void SlideButtonOnClick(MySlideButtonView SlideButtonView, boolean isOpen) {
                Toast.makeText(MySlideButtonViewActivity.this, isOpen + "", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
