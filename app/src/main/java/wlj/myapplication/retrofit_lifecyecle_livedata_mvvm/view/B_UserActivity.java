package wlj.myapplication.retrofit_lifecyecle_livedata_mvvm.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import wlj.myapplication.R;
import wlj.myapplication.retrofit_lifecyecle_livedata_mvvm.bean.B_User;
import wlj.myapplication.retrofit_lifecyecle_livedata_mvvm.viewmodel.UserViewModel;


/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/18.
 * 说明：retrofit view
 * ================================================
 */

public class B_UserActivity extends AppCompatActivity {
    private static final String TAG = B_UserActivity.class.getName();
    private UserViewModel userViewModel;
    private TextView tvId;
    private TextView tvName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b_activity_user);
        initView();
        initData();
    }

    private void initView() {
        tvId = (TextView) findViewById(R.id.tv_id);
        tvName = (TextView) findViewById(R.id.tv_name);
    }

    private void initData() {
        //lifecycle的方法，将数据与activity绑定
        //实例化viewholder，进行网络请求，得到数据
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        //设置可观察者，观察值的变化而更新UI
        userViewModel.getUser("ittianyu").observe(this, new Observer<B_User>() {
            @Override
            public void onChanged(@Nullable B_User BUser) {
                updateView(BUser);
            }
        });
    }

    private void updateView(B_User BUser) {
        Log.e(TAG, BUser.toString());
        tvId.setText(BUser.getId() + "");
        tvName.setText(BUser.getLogin());
    }

    public void onClickUpData(View view) {

        userViewModel.getUser("hongyang").observe(this, new Observer<B_User>() {
            @Override
            public void onChanged(@Nullable B_User BUser) {
                updateView(BUser);
            }
        });
    }
}
