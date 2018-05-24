package wlj.myapplication.mvp_demo.test.presenter;

import java.util.HashMap;

import wlj.myapplication.mvp_demo.mvp.BasePresenter;
import wlj.myapplication.mvp_demo.mvp.IModel;
import wlj.myapplication.mvp_demo.test.bean.SystemVersionBean;
import wlj.myapplication.mvp_demo.test.contract.TestContract;
import wlj.myapplication.mvp_demo.test.model.DataListener;
import wlj.myapplication.mvp_demo.test.model.TestModel;
import wlj.myapplication.mvp_demo.test.view.TestMVPActviity;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/23.
 * 说明：数据处理
 * ================================================
 */

public class TestPresenter extends BasePresenter<TestMVPActviity> implements TestContract.doPresenter {


    @Override
    public HashMap<String, IModel> getIModelMap() {
        return loadModelMap(new TestModel());
    }

    @Override
    public HashMap<String, IModel> loadModelMap(IModel... models) {
        HashMap<String, IModel> map = new HashMap<>(16);
        map.put("systemVersion", models[0]);
        return map;
    }

    @Override
    public void doForTestPresenter(String channel, int versionCode) {
        ((TestModel) getIModelMap().get("systemVersion")).systemVersion(channel, versionCode, new DataListener<SystemVersionBean>() {
            @Override
            public void successInfo(SystemVersionBean result) {
                if (getIView() != null && result != null) {
                    getIView().Success(result);
                }
            }

            @Override
            public void failInfo(SystemVersionBean result) {
                if (getIView() != null && result != null) {
                    getIView().Fail(result);
                }
            }

            @Override
            public void failMessage(SystemVersionBean result) {
                if (getIView() != null && result != null) {
                    getIView().FailMessage(result.getMsg());
                }
            }
        });
    }
}