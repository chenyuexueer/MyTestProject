package wlj.myapplication.lifecycle_livedata_mvvm.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import wlj.myapplication.lifecycle_livedata_mvvm.bean.A_User;


/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/18.
 * 说明：viewmodel类，处理数据逻辑get set方法暴露
 *              执行网络请求等获取数据
 * ================================================
 */

public class UserViewModel extends ViewModel {
    //livedata类与viewholder配合
    private MutableLiveData<A_User> user;

    public LiveData<A_User> getUser() {
        if (user == null)
            user = new MutableLiveData<>();
        return user;
    }

    public void setUser(String username) {
        //类似网络操作
        user.setValue(new A_User(1, username));
    }
}
