package wlj.myapplication.mvp_demo.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/23.
 * 说明：
 * ================================================
 */

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements IView, View.OnClickListener {
    protected View view;
    protected P mPresenter;

    protected AppCompatActivity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (AppCompatActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(getLayoutId(), container, false);
        }
        initView(savedInstanceState);
        mPresenter = loadPresenter();
        initCommonData();
        initData();
        initListener();
        return view;
    }

    /**
     * 判断该Fragment是否显示在用户面前
     */
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            loadData();
        }
    }

    private void initCommonData() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    protected abstract void initView(Bundle savedInstanceState);

    protected abstract P loadPresenter();

    protected abstract int getLayoutId();

    protected abstract void initListener();

    protected abstract void initData();

    protected abstract void otherViewClick(View view);

    /**
     * 懒加载，当前Fragment显示的时候才进行网络请求
     * 如果数据不需要每次都刷新，可以先判断数据是否存在
     * 数据不存在 -> 进行网络请求    数据存在 -> 什么都不做
     */
    protected abstract void loadData();

    /**
     * 点击的事件的统一的处理
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            default:
                otherViewClick(view);
                break;
        }
    }

    /**
     * 显示一个内容为str的toast
     *
     * @param str
     */
    public void toast(String str) {
        if (getActivity() != null) {
//            ToastCompat.makeText(getActivity().getApplicationContext(), str, ToastCompat.LENGTH_SHORT).show();
        }
    }

    /**
     * 显示一个内容为contentId指定的toast
     *
     * @param contentId
     */
    public void toast(int contentId) {
        if (getActivity() != null) {
//            ToastCompat.makeText(getActivity().getApplicationContext(), contentId, ToastCompat.LENGTH_SHORT).show();
        }
    }
}
