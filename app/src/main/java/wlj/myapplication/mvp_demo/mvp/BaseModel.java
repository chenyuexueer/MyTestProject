package wlj.myapplication.mvp_demo.mvp;

import wlj.myapplication.mvp_demo.http.ApiService;
import wlj.myapplication.mvp_demo.http.HttpUtil;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/23.
 * 说明：Model基类
 * ================================================
 */

public class BaseModel implements IModel {
    public static ApiService baseApiService() {
        return HttpUtil.getApiService();
    }
}
