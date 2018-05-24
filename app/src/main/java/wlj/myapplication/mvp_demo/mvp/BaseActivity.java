package wlj.myapplication.mvp_demo.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/23.
 * 说明：
 * ================================================
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements
        IView, View.OnClickListener {
    protected View view;
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getView());
        mPresenter = loadPresenter();
        initView(savedInstanceState);
        initCommonData();
        initData();
        initListener();
    }

    /**
     * @return 显示的内容
     */
    public View getView() {
        view = View.inflate(this, getLayoutId(), null);
        return view;
    }

    private void initCommonData() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    protected abstract int getLayoutId();

    protected abstract P loadPresenter();

    protected abstract void initView(Bundle savedInstanceState);

    protected abstract void initListener();

    protected abstract void initData();

    protected abstract void otherViewClick(View view);

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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    /**
     * 显示一个内容为str的toast
     *
     * @param str
     */
    public void toast(String str) {
//        ToastCompat.makeText(getApplicationContext(), str, ToastCompat.LENGTH_SHORT).show();
    }

    /**
     * 显示一个内容为contentId指定的toast
     *
     * @param contentId
     */
    public void toast(int contentId) {
//        ToastCompat.makeText(getApplicationContext(), contentId, ToastCompat.LENGTH_SHORT).show();
    }
}
