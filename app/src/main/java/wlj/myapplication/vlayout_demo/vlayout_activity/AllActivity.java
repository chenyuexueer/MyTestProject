package wlj.myapplication.vlayout_demo.vlayout_activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;

import java.util.LinkedList;
import java.util.List;

import wlj.myapplication.R;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/25.
 * 说明：
 * ================================================
 */

public class AllActivity  extends AppCompatActivity {
    private RecyclerView recyclerview;
    private DelegateAdapter delegateAdapter ;
    final List<DelegateAdapter.Adapter> adapters = new LinkedList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_vlayout);
        recyclerview=(RecyclerView)findViewById(R.id.recyclerview);

        initView();
    }

    public void initView(){

        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        recyclerview.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0,10);

        VirtualLayoutManager manager = new VirtualLayoutManager(this);
        recyclerview.setLayoutManager(manager);
        delegateAdapter = new DelegateAdapter(manager);

        adapters.add(LinearLayoutHelperActivity.init(this));
        adapters.add(ColumnLayoutHelperActivity.init(this));
        //这个有些效果没出来应该是因为position不对应，因为是外层列表position
        adapters.add(GridLayoutHelperActivity.init(this));
        adapters.add(FixLayoutHelperActivity.init(this));
        adapters.add(ScrollFixLayoutHelperActivity.init(this));
        adapters.add(SingleLayoutHelperActivity.init(this));
        adapters.add(OnePlusNLayoutHelperActivity.init(this));
        //这里一开始无法移动是因为还没滚动到这个FloatLayoutHelper
        adapters.add(FloatLayoutHelperActivity.init(this));
        adapters.add(StickyLayoutHelperActivity.init(this));
        adapters.add(StaggeredGridLayoutHelperActivity.init(this));

        delegateAdapter.setAdapters(adapters);

        recyclerview.setAdapter(delegateAdapter);
    }
}
