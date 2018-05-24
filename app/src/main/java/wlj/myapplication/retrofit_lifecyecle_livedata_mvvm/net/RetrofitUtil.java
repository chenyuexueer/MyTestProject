package wlj.myapplication.retrofit_lifecyecle_livedata_mvvm.net;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import wlj.myapplication.retrofit_lifecyecle_livedata_mvvm.bean.B_User;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/18.
 * 说明：实例化网络请求方法，与livedata结合
 * ================================================
 */

public class RetrofitUtil {

    private RetrofitUtil() {//构造方法
    }

    private static final RetrofitUtil instance = new RetrofitUtil();//单例，方便使用与优化
    public static RetrofitUtil getInstance() {//返回单例，方便得到  实例对象
        return instance;
    }
    //实例化retrofit，进行网络请求实例化
    private UserApi userApi = RetrofitFactory.getInstance().create(UserApi.class);

    //接收参数  进行网络请求
    public LiveData<B_User> getUserFromNet(String username) {
        final MutableLiveData<B_User> user = new MutableLiveData<>();
        userApi.queryUserByUsername(username).enqueue(new Callback<B_User>() {
            @Override
            public void onResponse(Call<B_User> call, Response<B_User> response) {
                user.setValue(response.body());
            }

            @Override
            public void onFailure(Call<B_User> call, Throwable t) {
                Log.e("TAG","网络请求失败=="+t.toString());
            }
        });
        return user;
    }
}
