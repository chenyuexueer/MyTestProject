package wlj.myapplication.vlayout_demo.vlayout_activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.OnePlusNLayoutHelper;

import wlj.myapplication.R;
import wlj.myapplication.vlayout_demo.adapter.MyRecyclerAdapter;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/25.
 * 说明：一行平均 OnePlusNLayoutHelper
 * ================================================
 */

public class OnePlusNLayoutHelperActivity extends AppCompatActivity {
    public DelegateAdapter adapter;//adapter.addAdapter(DelegateAdapter.Adapter);（外层列表adapter）
    public static RecyclerView recyclerview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_vlayout);
        //1、获取recyclerview
        recyclerview=(RecyclerView)findViewById(R.id.recyclerview);
        //2、初始化manager，recyclerview设置manager（里层列表manager）
        VirtualLayoutManager manager = new VirtualLayoutManager(this);
        recyclerview.setLayoutManager(manager);
        //3、初始化DelegateAdapter（外层列表adapter）
        adapter =new DelegateAdapter(manager, true);
        //4、DelegateAdapter添加recyclerview  adapter（DelegateAdapter.Adapter，里层列表adapter）
        adapter.addAdapter(init(this));
        //5、recyclerview设置DelegateAdapter（外层列表adapter）
        recyclerview.setAdapter(adapter);
    }

    public static MyRecyclerAdapter init(Context context){
        OnePlusNLayoutHelper onePlusNLayoutHelper=new OnePlusNLayoutHelper();
        //设置布局底部与下个布局的间隔
        onePlusNLayoutHelper.setMarginBottom(20);
        MyRecyclerAdapter myRecyclerAdapter=new MyRecyclerAdapter(context,onePlusNLayoutHelper,"OnePlusNLayoutHelper");
        return myRecyclerAdapter;
    }
}
