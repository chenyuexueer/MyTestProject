package wlj.myapplication.retrofit_lifecyecle_livedata_mvvm.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import wlj.myapplication.retrofit_lifecyecle_livedata_mvvm.bean.B_User;
import wlj.myapplication.retrofit_lifecyecle_livedata_mvvm.net.RetrofitUtil;


/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/18.
 * 说明：viewmodel类，处理数据逻辑get set方法暴露
 *              执行网络请求等获取数据
 * ================================================
 */

public class UserViewModel extends ViewModel {
    private RetrofitUtil userRepository = RetrofitUtil.getInstance();
    private LiveData<B_User> user;

    public LiveData<B_User> getUser(String username) {
            user = userRepository.getUserFromNet(username);
        return user;
    }
}
