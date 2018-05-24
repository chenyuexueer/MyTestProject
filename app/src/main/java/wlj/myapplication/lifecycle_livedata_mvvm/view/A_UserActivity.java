package wlj.myapplication.lifecycle_livedata_mvvm.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import wlj.myapplication.R;
import wlj.myapplication.lifecycle_livedata_mvvm.bean.A_User;
import wlj.myapplication.lifecycle_livedata_mvvm.viewmodel.UserViewModel;


/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/18.
 * 说明：view
 * ================================================
 */

public class A_UserActivity extends AppCompatActivity {
    private TextView tvId;
    private TextView tvName;
    private UserViewModel userViewModel;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_activity_user);
        initView();
        initData();
    }

    private void initView() {
        tvId = (TextView) findViewById(R.id.tv_id);
        tvName = (TextView) findViewById(R.id.tv_name);
    }

    private void initData() {
        //lifecycle的方法，将数据与activity绑定
        userViewModel=ViewModelProviders.of(this).get(UserViewModel.class);
        //设置可观察者，观察值的变化而更新UI
        userViewModel.getUser().observe(this, new Observer<A_User>() {
            @Override
            public void onChanged(@Nullable A_User AUser) {
                updateView(AUser);
            }
        });
        //通知viewholder执行获值操作，如网络请求
        userViewModel.setUser("test1");
    }

    //更新UI
    private void updateView(A_User AUser) {
        tvId.setText(AUser.getId() + "");
        tvName.setText(AUser.getName());
    }

    //响应用户操作
    public void onClickUpData(View view) {
        userViewModel.setUser("test2");
    }
}
