package wlj.myapplication.vlayout_demo.vlayout_activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;

import wlj.myapplication.R;
import wlj.myapplication.vlayout_demo.adapter.MyRecyclerAdapter;

import static wlj.myapplication.vlayout_demo.vlayout_activity.LinearLayoutHelperActivity.myRecyclerAdapter;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/25.
 * 说明：
 * ================================================
 */

public class ColumnLayoutHelperActivity extends AppCompatActivity {

    public static RecyclerView recyclerview;
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
        adapter.addAdapter(initLinearLayout(this));
        //5、recyclerview设置DelegateAdapter（外层列表adapter）
        recyclerview.setAdapter(adapter);
    }

    public MyRecyclerAdapter initLinearLayout(Context context){
        LinearLayoutHelper linearLayoutHelper=new LinearLayoutHelper();
        myRecyclerAdapter=new MyRecyclerAdapter(context,linearLayoutHelper,"LinearLayoutHelper");
        return myRecyclerAdapter;
    }

    public static MyRecyclerAdapter init(Context context){
        ColumnLayoutHelper columnLayoutHelper=new ColumnLayoutHelper();
        columnLayoutHelper.setWeights(new float[]{20,20,20,40});//每个子item占的宽度比重
        columnLayoutHelper.setMarginLeft(20);//左边外距
        columnLayoutHelper.setMarginTop(20);//上边外距
        columnLayoutHelper.setMarginRight(20);//右外边距
        columnLayoutHelper.setMarginBottom(20);//底外边距

        MyRecyclerAdapter myRecyclerAdapter=new MyRecyclerAdapter(context,columnLayoutHelper,"ColumnLayoutHelper");
        return myRecyclerAdapter;
    }
}
