package wlj.myapplication.vlayout_demo.vlayout_activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;

import wlj.myapplication.R;
import wlj.myapplication.vlayout_demo.adapter.MyRecyclerAdapter;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/25.
 * 说明：GridLayoutHelper的单独使用
 *
 * 1、 初始化recyclerview
 * 2、设置manager  ( VirtualLayoutManager )
 * 3、设置DelegateAdapter（自定义adapter）
 * 4、自定义adapter
 *       4.1、初始化GridLayoutHelper，设置布局间距等
 *       4.2、初始化自定义adapter
 * ================================================
 */

public class GridLayoutHelperActivity extends AppCompatActivity {

    public RecyclerView recyclerView;
    private static MyRecyclerAdapter myRecyclerAdapter;
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
        //设置为4列即 里层  列表item  的item列数分为四列
        GridLayoutHelper gridLayoutHelper=new GridLayoutHelper(4);
        //手动设置外层  列表item  的某个item 填充 几列
        gridLayoutHelper.setSpanSizeLookup(new GridLayoutHelper.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position <7) {//item0-item6这7个item每个填充一格，这里的设置受setAutoExpand()影响
                    return 1;
                }else if (position<12){//item7-item11这5个item每个填充两格
                    return 2;
                }else if (position<18){//item12-item17这6个item每个填充三格
                    return 3;
                }else if (position<25){//每个填充四格
                    return 4;
                }
                //item0-item6这7个item每个填充一格，这里的设置受setAutoExpand()影响，具体效果请修改
                //上面的position<25、24、23、22    看最后一行的效果
                else {
                    return 1;
                }




            }
        });

        //是否自动扩展，就是是否填充 里层  列表item  的整个item，就是比如 第二行，
        // item4 item5 item6这三个，若：setAutoExpand(true)，三个平分四列填充，
        // 若：setAutoExpand(false)，则不会填充，三个只会占三格，可自行测试看效果，
        // 或者修改上面的position<25、24、23、22    看最后一行的效果
        gridLayoutHelper.setAutoExpand(true);
        myRecyclerAdapter=new MyRecyclerAdapter(context,gridLayoutHelper,"GridLayoutHelper");
        return myRecyclerAdapter;
    }

}
