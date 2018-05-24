package wlj.myapplication.mvp_demo.http;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import wlj.myapplication.mvp_demo.base.MyMVPApplication;
import wlj.myapplication.mvp_demo.utils.LogConfig;
import wlj.myapplication.mvp_demo.utils.NetworkUtil;
import wlj.myapplication.mvp_demo.utils.SPUtils;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/23.
 * 说明：Retrofit 网络请求配置
 * ================================================
 */

public class HttpUtil {
    /**
     * volatile 修饰的成员变量在每次被线程访问时，都强迫从共享内存中重读该成员变量的值。而且，当成员变量发生变化
     * 时，强迫线程将变化值回写到共享内存。这样在任何时刻，两个不同的线程总是看到某个成员变量的同一个值。
     */
    private static volatile Retrofit retrofit;
    private static final String TAG = "Http";
    private static OkHttpClient client;//Retrofit网络层 客户端
    private static ApiService apiService;//接口配置
    private static String BASE_URL;

    private static File httpCacheDirectory = null;//缓存文件路径
    private static Cache cache = null;//缓存

    /**
     * @return retrofit的底层利用反射的方式, 获取所有的api接口的类
     */
    public static ApiService getApiService() {
        /**
         * 切换网络环境
         */
        if (LogConfig.DEBUG_URL) {
            BASE_URL = UrlHelper.TEST_URL;
        } else {
            BASE_URL = UrlHelper.ON_LINE_URL;
        }
        if (apiService == null) {
            apiService = getRetrofit().create(ApiService.class);
        }
        return apiService;
    }

    /**
     * 设置公共参数
     */
    private static Interceptor addQueryParameterInterceptor() {
        Interceptor addQueryParameterInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Request request;
                HttpUrl modifiedUrl = originalRequest.url().newBuilder()
                        // Provide your custom parameter here
                        //                        .addQueryParameter("phoneSystem", "")
                        //                        .addQueryParameter("phoneModel", "")
                        .build();
                request = originalRequest.newBuilder().url(modifiedUrl).build();
                return chain.proceed(request);
            }
        };
        return addQueryParameterInterceptor;
    }

    /**
     * 设置头
     */
    private static Interceptor addHeaderInterceptor() {
        Interceptor headerInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Request.Builder requestBuilder = originalRequest.newBuilder()
                        // Provide your custom header here
                        .header("token", (String) SPUtils.get("token", ""))
                        .method(originalRequest.method(), originalRequest.body());
                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        };
        return headerInterceptor;
    }

    /**
     * 设置缓存
     */
    private static Interceptor addCacheInterceptor() {
        Interceptor cacheInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (!NetworkUtil.isNetworkAvailable(MyMVPApplication.getContext())) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }
                Response response = chain.proceed(request);
                if (NetworkUtil.isNetworkAvailable(MyMVPApplication.getContext())) {
                    int maxAge = 0;
                    // 有网络时 设置缓存超时时间0个小时 ,意思就是不读取缓存数据,只对get有用,post没有缓冲
                    response.newBuilder()
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            // 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                            .removeHeader("Retrofit")
                            .build();
                } else {
                    // 无网络时，设置超时为4周  只对get有用,post没有缓冲
                    int maxStale = 60 * 60 * 24 * 28;
                    response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" +
                                    maxStale)
                            .removeHeader("nyn")
                            .build();
                }
                return response;
            }
        };
        return cacheInterceptor;
    }

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            synchronized (HttpUtil.class) {
                if (retrofit == null) {
                    // 添加一个log拦截器,打印所有的log
                    HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                    // 可以设置请求过滤的水平,body,basic,headers
                    httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

                    // 设置 请求的缓存的大小跟位置
                    if (httpCacheDirectory == null) {
                        httpCacheDirectory = new File(MyMVPApplication.getContext().getCacheDir(), "app_cache");
                    }
                    if (cache == null) {
                        cache = new Cache(httpCacheDirectory, 10 * 1024 * 1024);
                    }
                    if (client == null) {
                        client = new OkHttpClient
                                .Builder()
                                // 参数添加
                                .addInterceptor(addQueryParameterInterceptor())
                                // token过滤
                                .addInterceptor(addHeaderInterceptor())
                                // 日志,所有的请求响应度看到
                                .addInterceptor(httpLoggingInterceptor)
                                //设置网络缓存
                                .addNetworkInterceptor(addCacheInterceptor())
                                // 添加缓存
                                .cache(cache)
                                .connectTimeout(60L, TimeUnit.SECONDS)//超时
                                .readTimeout(60L, TimeUnit.SECONDS)//读取
                                .writeTimeout(60L, TimeUnit.SECONDS)//写入
                                .build();
                    }
                    // 获取retrofit的实例
                    retrofit = new Retrofit
                            .Builder()
                            // 自己配置
                            .baseUrl(BASE_URL)
                            .client(client)
                            // RxJava2与Retrofit混用
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            // Gson
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                }
            }
        }
        return retrofit;
    }
}
