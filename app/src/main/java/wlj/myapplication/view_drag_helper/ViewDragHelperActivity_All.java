package wlj.myapplication.view_drag_helper;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import wlj.myapplication.R;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/8/18.
 * 说明：ViewDragHelper自定义view的手势拖拽神器ViewDragHelper界面
 *
 * 参考：
 *          https://www.jianshu.com/p/111a7bc76a0e
 *          https://www.jianshu.com/p/0e8ed99b4fb9
 *          https://www.jianshu.com/p/a9e0a98e4d42
 *
 * ================================================
 */
public class ViewDragHelperActivity_All extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_drag_helper);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_1:
                startActivity(new Intent(this, ViewDragHelperActivity1.class));
                break;
            case R.id.tv_2:
                startActivity(new Intent(this, ViewDragHelperActivity2.class));
                break;
            case R.id.tv_3:
                startActivity(new Intent(this, ViewDragHelperActivity3.class));
                break;
            case R.id.tv_4:
                startActivity(new Intent(this, ViewDragHelperActivity4.class));
                break;
            case R.id.tv_5:
                startActivity(new Intent(this, ViewDragHelperActivity5.class));
                break;
            case R.id.tv_6:
                Toast.makeText(this, "没做，嘻嘻嘻", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_7:
                Toast.makeText(this, "没做，嘻嘻嘻", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_8:
                Toast.makeText(this, "没做，嘻嘻嘻", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_9:
                Toast.makeText(this, "没做，嘻嘻嘻", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
