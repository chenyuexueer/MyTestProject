package wlj.myapplication.my_dialg_view_test.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import wlj.myapplication.my_dialg_view_test.util.DialogUtil;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/29.
 * 说明：加载进度动画 view
 * ================================================
 */

public class MyProgressViewActivity extends AppCompatActivity {
    private DialogUtil dialogUtil;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialogUtil = new DialogUtil();
        dialogUtil.getProgressDialog(this, 100, 100);
    }
}
