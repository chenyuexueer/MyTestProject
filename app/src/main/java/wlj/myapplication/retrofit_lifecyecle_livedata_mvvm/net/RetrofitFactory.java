package wlj.myapplication.retrofit_lifecyecle_livedata_mvvm.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/18.
 * 说明：RetrofitFactory工厂
 * ================================================
 */

public class RetrofitFactory {
    private static OkHttpClient client;
    private static Retrofit retrofit;

    private static final String HOST = "https://api.github.com";//baseurl

    static {
        //初始化ok3   client
        client=new OkHttpClient.Builder().connectTimeout(9, TimeUnit.SECONDS).build();

        retrofit=new Retrofit.Builder()
                .baseUrl(HOST)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    //获取单例
     public static Retrofit getInstance() {
        return retrofit;
    }

}
