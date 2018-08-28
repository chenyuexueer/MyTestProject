package wlj.myapplication.databinding.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import wlj.myapplication.R;
import wlj.myapplication.databinding.DatabindingActivityBinding;
import wlj.myapplication.databinding.bean.UserBean;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/8/28.
 * 说明：DataBinddingActivity使用
 * ================================================
 */
public class DataBinddingActivity extends AppCompatActivity {
    //它是根据对应的布局文件的名字生成的,第一个单词首字母大写，第二个单词
    // 首字母大写，最后都会拼上Binding就是生成的Binding类
    private DatabindingActivityBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.databinding_activity);

        UserBean userBean=new UserBean("test","123456");

        binding.setUser(userBean );
    }
}
