package wlj.myapplication.mvp_demo.observe;

import android.content.Context;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import wlj.myapplication.mvp_demo.utils.LogUtil;
import wlj.myapplication.mvp_demo.utils.NetworkUtil;
import wlj.myapplication.mvp_demo.utils.ToastUtil;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/23.
 * 说明：
 * ================================================
 */

public class CommonObserver<T> implements Observer<T> {
    private final String TAG = "CommonObserver";
    private Context context;
    /**
     * Disposable 相当于RxJava1.x中的 Subscription，用于解除订阅 disposable.dispose();
     */
    protected Disposable disposable;

    public CommonObserver(Context context) {
        this.context = context;
    }

    @Override
    public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {
        disposable = d;
        if (!NetworkUtil.isNetworkAvailable(context)) {
            LogUtil.e(TAG, "网络不可用");
        } else {
            LogUtil.e(TAG, "网络可用");
        }
    }

    @Override
    public void onNext(T t) {
        if (t == null) {
            return;
        }
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof ConnectException) {
            ToastUtil.showShort("链接超时");
        } else if (e instanceof SocketTimeoutException) {
            ToastUtil.showShort("链接超时");
        } else if (e instanceof UnknownHostException) {
            ToastUtil.showShort("未知名称或服务");
        }
    }

    @Override
    public void onComplete() {
        LogUtil.e(TAG, "成功了");
    }

}
