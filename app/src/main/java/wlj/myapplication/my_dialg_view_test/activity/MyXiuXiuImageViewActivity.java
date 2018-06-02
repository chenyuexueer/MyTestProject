package wlj.myapplication.my_dialg_view_test.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

import wlj.myapplication.R;
import wlj.myapplication.my_dialg_view_test.view.MyXiuXiuImageView;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/30.
 * 说明：支付宝咻一咻的View       波浪样式
 * ================================================
 */

public class MyXiuXiuImageViewActivity extends AppCompatActivity {

    private MyXiuXiuImageView myXiuXiu1;
    private MyXiuXiuImageView myXiuXiu2;
    private MyXiuXiuImageView myXiuXiu3;
    private MyXiuXiuImageView myXiuXiu4;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getIntent().hasExtra("type")) {
            switch (getIntent().getIntExtra("type", 0)) {
                case 0:
                    init1();
                    break;
                case 1:
                    init2();
                    break;
            }
        }
    }

    private void init1() {
        setContentView(R.layout.my_xiuxiu_image_view);

        myXiuXiu1 = (MyXiuXiuImageView) findViewById(R.id.xiu1);
        myXiuXiu1.setStep(5);
        myXiuXiu2 = (MyXiuXiuImageView) findViewById(R.id.xiu2);
        myXiuXiu2.setXiuXiuType(MyXiuXiuImageView.XiuXiuType.IN);
        myXiuXiu3 = (MyXiuXiuImageView) findViewById(R.id.xiu3);
        myXiuXiu3.setStep(3);
        myXiuXiu3.setWaveType(MyXiuXiuImageView.WaveType.ALWAYS);
        myXiuXiu4 = (MyXiuXiuImageView) findViewById(R.id.xiu4);
        myXiuXiu4.setXiuXiuType(MyXiuXiuImageView.XiuXiuType.IN);
        myXiuXiu4.setWaveType(MyXiuXiuImageView.WaveType.ALWAYS);
    }

    private void init2() {
        setContentView(R.layout.my_xiuxiu_image_view_in_drawerslayout);

        LinearLayout builtLeft = (LinearLayout) findViewById(R.id.built_in_left);
        WindowManager m = getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        ViewGroup.LayoutParams p = builtLeft.getLayoutParams();// getWindow().getAttributes();
        p.width = (int) (d.getWidth() * 0.7);
        builtLeft.setLayoutParams(p);

        LinearLayout buildRight = (LinearLayout) findViewById(R.id.built_in_right);
        WindowManager m2 = getWindowManager();
        Display d2 = m2.getDefaultDisplay(); // 获取屏幕宽、高用
        ViewGroup.LayoutParams p2 = buildRight.getLayoutParams();// getWindow().getAttributes();
        p2.width = (int) (d2.getWidth() * 0.7);
        buildRight.setLayoutParams(p2);
    }
}
