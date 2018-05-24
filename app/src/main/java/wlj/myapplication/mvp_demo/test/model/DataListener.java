package wlj.myapplication.mvp_demo.test.model;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/23.
 * 说明：通过接口产生信息回调
 * ================================================
 */

public interface DataListener<T> {
    void successInfo(T result);

    void failInfo(T result);

    void failMessage(T result);

}
