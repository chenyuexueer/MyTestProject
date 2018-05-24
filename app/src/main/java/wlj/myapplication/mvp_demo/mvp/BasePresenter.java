package wlj.myapplication.mvp_demo.mvp;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/23.
 * 说明：Presenter基类
 * ================================================
 */

public abstract class BasePresenter<V extends IView> implements IPresenter {
    /**
     * View接口类型的弱引用
     */
    private WeakReference<V> mViewRef;

    /**
     * 建立关联
     */
    @Override
    public void attachView(IView iview) {
        mViewRef = new WeakReference(iview);
    }

    /**
     * 解除关联
     */
    @Override
    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

    /**
     * 获取View
     */
    @Override
    public V getIView() {
        return mViewRef==null?null:mViewRef.get();
    }

    /**
     * 判断是否与View建立了关联
     *
     * @return 建立则返回true
     */
    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    public abstract HashMap<String, IModel> getIModelMap();

    /**
     * @param models
     * @return 添加多个model, 如有需要
     */
    public abstract HashMap<String, IModel> loadModelMap(IModel... models);
}
