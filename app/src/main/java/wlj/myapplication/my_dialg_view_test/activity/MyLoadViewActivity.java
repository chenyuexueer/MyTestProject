package wlj.myapplication.my_dialg_view_test.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import wlj.myapplication.my_dialg_view_test.util.DialogUtil;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/29.
 * 说明：加载动画
 * ================================================
 */

public class MyLoadViewActivity extends AppCompatActivity {
    private DialogUtil dialogUtil;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialogUtil = new DialogUtil();
        dialogUtil.getLoadDialog(this);
    }
}
