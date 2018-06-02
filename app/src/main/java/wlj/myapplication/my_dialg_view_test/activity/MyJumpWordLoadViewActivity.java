package wlj.myapplication.my_dialg_view_test.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import wlj.myapplication.my_dialg_view_test.util.DialogUtil;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/30.
 * 说明：文字跳跳跳加载动画
 * ================================================
 */

public class MyJumpWordLoadViewActivity extends AppCompatActivity {
    private DialogUtil dialogUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialogUtil=new DialogUtil();
        if (getIntent().hasExtra("type")){
            switch (getIntent().getIntExtra("type",0)){
                case 0:
                    dialogUtil.getLoadDialog3(this,0);
                    break;
                case 1:
                    dialogUtil.getLoadDialog3(this,1);
                    break;
            }
        }
    }
}
