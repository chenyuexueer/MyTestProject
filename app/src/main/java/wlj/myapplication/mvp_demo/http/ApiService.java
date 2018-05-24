package wlj.myapplication.mvp_demo.http;


import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import wlj.myapplication.mvp_demo.test.bean.SystemVersionBean;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/23.
 * 说明：网络请求的接口设置
 * ================================================
 */

public interface ApiService {

    /**
     * 系统版本
     *
     * @param channel     渠道号
     * @param versionCode 当前版本号
     */
    @FormUrlEncoded
    @POST("index.php?m=system_version")
    Observable<SystemVersionBean> systemVersion(@Field("channel") String channel,
                                                @Field("versionCode") String versionCode);
}
