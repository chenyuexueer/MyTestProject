package wlj.myapplication.vlayout_demo.vlayout_activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;

import wlj.myapplication.R;
import wlj.myapplication.vlayout_demo.adapter.MyRecyclerAdapter;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/25.
 * 说明：LinearLayoutHelper的单独使用
 *
 * 1、recyclerview
 *      1.1、recyclerview设置VirtualLayoutManager                        里层的recyclerview(个人理解)
 * 2、继承 DelegateAdapter.Adapter自定义adapter
 *      2.1、recyclerview设置adapter
 * 3、DelegateAdapter.addAdapter(第二步的 自定义adapter )   最外层的recyclerview(个人理解)
 *      3.1、初始化LinearLayoutHelper
 *      3.2、将LinearLayoutHelper传到第二步的  自定义adapter
 * ================================================
 */

public class LinearLayoutHelperActivity extends AppCompatActivity {
    public static RecyclerView recyclerview;
    //继承 DelegateAdapter.Adapter，就是单个的recyclerview adapter（里层列表adapter）
    public static MyRecyclerAdapter myRecyclerAdapter;
    public DelegateAdapter adapter;//adapter.addAdapter(DelegateAdapter.Adapter);（外层列表adapter）
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

    public static MyRecyclerAdapter init(Context context) {
        //4.1、 给自定义recyclerview adapter初始化LayoutHelper
        LinearLayoutHelper linearLayoutHelper=new LinearLayoutHelper();
        //设置间隔高度
        linearLayoutHelper.setDividerHeight(50);//里层的  列表item  的item与item的上下距离
        //设置布局底部与下个布局的间隔
        linearLayoutHelper.setMarginBottom(20);//但这里只有一个布局所以看不出效果
        //设置间距
        //里层  列表item  与里层  列表item  ，这里只有一个layouthelper也就是相当于
        // 一个  里层  列表item  ，不过也可以看效果
        linearLayoutHelper.setMargin(200,200,200,200);
        //4.2、自定义recyclerview adapter继承DelegateAdapter.Adapter
        myRecyclerAdapter=new MyRecyclerAdapter(context,linearLayoutHelper,"LinearLayoutHelper");
        return myRecyclerAdapter;
    }
}
