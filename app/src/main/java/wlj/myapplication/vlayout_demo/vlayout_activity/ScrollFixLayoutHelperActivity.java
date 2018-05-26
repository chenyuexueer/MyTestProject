package wlj.myapplication.vlayout_demo.vlayout_activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.ScrollFixLayoutHelper;

import wlj.myapplication.R;
import wlj.myapplication.vlayout_demo.adapter.MyRecyclerAdapter;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/25.
 * 说明：
 * ================================================
 */

public class ScrollFixLayoutHelperActivity extends Activity {
    private RecyclerView recyclerview;
    private MyRecyclerAdapter myRecyclerAdapter;
    private DelegateAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_vlayout);
        recyclerview=(RecyclerView)findViewById(R.id.recyclerview);
        VirtualLayoutManager manager = new VirtualLayoutManager(this);
        recyclerview.setLayoutManager(manager);
        adapter =new DelegateAdapter(manager, true);

        adapter.addAdapter(initLinearLayout(this));
        adapter.addAdapter(init(this));
        recyclerview.setAdapter(adapter);
    }

    public MyRecyclerAdapter initLinearLayout(Context context){
        LinearLayoutHelper linearLayoutHelper=new LinearLayoutHelper();
        myRecyclerAdapter=new MyRecyclerAdapter(context,linearLayoutHelper,"LinearLayoutHelper");
        return myRecyclerAdapter;
    }

    public static MyRecyclerAdapter init(Context context){
        ScrollFixLayoutHelper scrollFixLayoutHelper = new ScrollFixLayoutHelper(500,300);//（x坐标，y坐标）
        //show_always:总是显示
        //show_on_enter:当页面滚动到这个视图的位置的时候，才显示
        //show_on_leave:当页面滚出这个视图的位置的时候显示
        scrollFixLayoutHelper.setShowType(ScrollFixLayoutHelper.SHOW_ON_ENTER);
        return new MyRecyclerAdapter(context, scrollFixLayoutHelper,"ScrollFixLayoutHelper");
    }

}
