package wlj.myapplication.mvp_demo.test.view;

import android.os.Bundle;
import android.view.View;

import wlj.myapplication.R;
import wlj.myapplication.mvp_demo.mvp.BaseActivity;
import wlj.myapplication.mvp_demo.test.bean.SystemVersionBean;
import wlj.myapplication.mvp_demo.test.contract.TestContract;
import wlj.myapplication.mvp_demo.test.presenter.TestPresenter;
import wlj.myapplication.mvp_demo.utils.LogUtil;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/23.
 * 说明：
 * ================================================
 */

public class TestMVPActviity extends BaseActivity<TestPresenter> implements TestContract.doView {

    @Override
    protected int getLayoutId() {
        return R.layout.test;
    }

    @Override
    protected TestPresenter loadPresenter() {
        return new TestPresenter();
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void initListener() {
        //      xx.setOnClick
    }

    @Override
    protected void initData() {
        mPresenter.doForTestPresenter("default", 217);
    }

    @Override
    protected void otherViewClick(View view) {
        //        switch (view.getId()) {
        //
        //        }
    }

        @Override
    public void Success(SystemVersionBean systemVersionBean) {
        LogUtil.e("Success===", systemVersionBean.toString());
    }

    @Override
    public void Fail(SystemVersionBean systemVersionBean) {
        LogUtil.e("Fail===", systemVersionBean.toString());
    }

    @Override
    public void FailMessage(String msg) {
        LogUtil.e("FailMessage===",msg);
    }

}
