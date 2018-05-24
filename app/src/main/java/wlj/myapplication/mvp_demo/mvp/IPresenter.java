package wlj.myapplication.mvp_demo.mvp;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/23.
 * 说明：mvp之presenter
 *
 * 得到view   绑定view  解绑view
 * ================================================
 */

public interface IPresenter<V extends IView> {

    /**
     * 绑定
     * @param view
     */
    void attachView(V view);
    /**
     * 防止内存的泄漏, 清除Presenter与Activity之间的绑定
     */
    void detachView();
    /**
     * @return 获取View
     */
    V getIView();

}
