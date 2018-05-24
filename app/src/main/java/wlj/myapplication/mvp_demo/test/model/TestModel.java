package wlj.myapplication.mvp_demo.test.model;

import io.reactivex.annotations.NonNull;
import wlj.myapplication.mvp_demo.base.MyMVPApplication;
import wlj.myapplication.mvp_demo.mvp.BaseModel;
import wlj.myapplication.mvp_demo.observe.CommonObserver;
import wlj.myapplication.mvp_demo.test.bean.SystemVersionBean;
import wlj.myapplication.mvp_demo.transformer.CommonTransformer;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/23.
 * 说明：网络数据请求
 * ================================================
 */

public class TestModel extends BaseModel {

    public void systemVersion(@NonNull String channel, @NonNull int versionCode, @NonNull final DataListener listener) {
        if (listener == null) {
            throw new RuntimeException("listener不能为空");
        }
        baseApiService().systemVersion(channel, String.valueOf(versionCode))
                .compose(new CommonTransformer<SystemVersionBean>())
                .subscribe(new CommonObserver<SystemVersionBean>(MyMVPApplication.getContext()) {

                    @Override
                    public void onNext(@io.reactivex.annotations.NonNull SystemVersionBean systemVersionBean) {
                        switch (systemVersionBean.getStatus()) {
                            case 200:
                                listener.successInfo(systemVersionBean);
                                break;
                            case 401:
                            case 402:
                                listener.failMessage(systemVersionBean);
                                break;
                            default:
                                listener.failInfo(systemVersionBean);
                                break;
                        }
                    }
                });
    }
}
