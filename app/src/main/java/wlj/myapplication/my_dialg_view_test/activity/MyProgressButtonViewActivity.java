package wlj.myapplication.my_dialg_view_test.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import wlj.myapplication.R;
import wlj.myapplication.my_dialg_view_test.view.MyProgressButtonView;
import wlj.myapplication.my_dialg_view_test.view.view_options.MyProgressButtonViewOption;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/29.
 * 说明：进度条按钮button          view
 * ================================================
 */

public class MyProgressButtonViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_progress_button_view);
        final MyProgressButtonView progressButton = (MyProgressButtonView) findViewById(R.id.pb);
        MyProgressButtonViewOption.Builder builder = new MyProgressButtonViewOption.Builder();

        builder.setBtnStartText("开始")
                .setBtnEndText("完成")
                .setShowPercent(true)
                .setBtnErrorIcon(R.mipmap.ic_launcher);

        progressButton.setOption(new MyProgressButtonViewOption(builder));
        progressButton.setClickListener(new MyProgressButtonView.MyProgressButtonOnClickListener(){
            @Override
            public void LPBOnClick(MyProgressButtonView btn) {
                switch (btn.getType()) {
                    case MyProgressButtonView.TYPE_END:
                        progressButton.reset();
                        break;
                    case MyProgressButtonView.TYPE_ERROR:
                        progressButton.onEnd();
                        break;
                    case MyProgressButtonView.TYPE_LOADING:
                        progressButton.onError();
                        break;
                    case MyProgressButtonView.TYPE_PREPARE:
                        progressButton.onLoad(100, 100);
                        break;
                    case MyProgressButtonView.TYPE_START:
                        progressButton.onPrepare();
                        // progressButton.onError();
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
