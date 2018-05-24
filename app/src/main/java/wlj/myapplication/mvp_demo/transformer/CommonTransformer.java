package wlj.myapplication.mvp_demo.transformer;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 说明：实现ObservableTransformer，完成线程切换，使用compose()操作符
 * ================================================
 */

public class CommonTransformer<T> implements ObservableTransformer<T, T> {
    @Override
    public ObservableSource<T> apply(@NonNull Observable<T> upstream) {
        return upstream.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                // UI线程
                .observeOn(AndroidSchedulers.mainThread());
        //                .compose(ErrorTransformer.<T>getInstance());
    }
}
