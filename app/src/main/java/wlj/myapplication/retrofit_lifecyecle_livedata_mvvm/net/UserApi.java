package wlj.myapplication.retrofit_lifecyecle_livedata_mvvm.net;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import wlj.myapplication.retrofit_lifecyecle_livedata_mvvm.bean.B_User;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/18.
 * 说明：网络接口参数方法
 * ================================================
 */

public interface UserApi {
    @GET("/users/{username}")
    Call<B_User> queryUserByUsername(@Path("username") String username);
}
