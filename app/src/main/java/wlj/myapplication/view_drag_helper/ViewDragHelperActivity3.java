package wlj.myapplication.view_drag_helper;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import wlj.myapplication.R;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/8/18.
 * 说明：ViewDragHelper自定义view的手势拖拽神器ViewDragHelper界面
 *
 * 主要解决触摸事件被消耗掉
 * ================================================
 */
public class ViewDragHelperActivity3 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_drag_helper3);
    }
}
