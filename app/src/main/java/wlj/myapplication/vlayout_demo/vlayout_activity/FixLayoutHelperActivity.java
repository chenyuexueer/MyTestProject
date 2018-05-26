package wlj.myapplication.vlayout_demo.vlayout_activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.FixLayoutHelper;

import wlj.myapplication.R;
import wlj.myapplication.vlayout_demo.adapter.MyRecyclerAdapter;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/25.
 * 说明：固定布局
 * ================================================
 */

public class FixLayoutHelperActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DelegateAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_vlayout);
        //1、初始化recyclerview
        recyclerView=(RecyclerView) findViewById(R.id.recyclerview);
        //2、初始化manager，设置manager（里层列表manager）
        VirtualLayoutManager manager = new VirtualLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        //3、初始化DelegateAdapter（外层列表的adapter），设置自定义adapter（里层列表的adapter）
        adapter =new DelegateAdapter(manager, true);
        //4、初始化自定义adapter（里层列表的adapter）
        adapter.addAdapter(init(this));

        recyclerView.setAdapter(adapter);
    }

    public static MyRecyclerAdapter init(Context context){
        FixLayoutHelper fixLayoutHelper=new FixLayoutHelper(FixLayoutHelper.TOP_LEFT, 200, 900);//(左对齐，相对于屏幕的x轴，相对屏幕的y轴)
        MyRecyclerAdapter myRecyclerAdapter=new MyRecyclerAdapter(context,fixLayoutHelper,"FixLayoutHelper");
        return myRecyclerAdapter;
    }
}
