package wlj.myapplication.view_drag_helper.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import wlj.myapplication.R;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/8/18.
 * 说明：ViewDragHelper自定义view的手势拖拽神器ViewDragHelper界面
 *
 * 参考：
 *          https://www.jianshu.com/p/111a7bc76a0e
 *          https://www.jianshu.com/p/0e8ed99b4fb9
 *          https://www.jianshu.com/p/a9e0a98e4d42
 *
 * ================================================
 */
public class ViewDragHelperActivity_Test extends AppCompatActivity {
    private RecyclerView recycler;
    private List<String> chatInteractionData;
    private ViewDragHelperRecyclerAdapter viewDragHelperRecyclerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_drag_helper_test);
        recycler=findViewById(R.id.chat_interaction_recycler);

        chatInteractionData = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            chatInteractionData.add("数据 " + i);
        }

        initRecycler();//初始化Recycler
    }

    //初始化Recycler
    private void initRecycler() {


        viewDragHelperRecyclerAdapter = new ViewDragHelperRecyclerAdapter(ViewDragHelperActivity_Test.this, chatInteractionData);
        recycler.setAdapter(viewDragHelperRecyclerAdapter);

        viewDragHelperRecyclerAdapter.setOnItemClickListener(new ViewDragHelperRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.e("", "点击 position " + position);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Log.e("", "点击 position " + position);
            }
        });
    }

}
