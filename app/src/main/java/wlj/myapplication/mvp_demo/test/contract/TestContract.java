package wlj.myapplication.mvp_demo.test.contract;

import wlj.myapplication.mvp_demo.test.bean.SystemVersionBean;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/23.
 * 说明：
 * ================================================
 */

public class TestContract {
    public interface doView{//请求结果处理
        void Success(SystemVersionBean systemVersionBean);

        void Fail(SystemVersionBean systemVersionBean);

        void FailMessage(String msg);
    }
    public interface doPresenter {
        void doForTestPresenter(String channel, int versionCode);//网络数据请求
    }
}
