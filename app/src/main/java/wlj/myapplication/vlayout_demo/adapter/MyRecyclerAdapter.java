package wlj.myapplication.vlayout_demo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;

import wlj.myapplication.R;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/25.
 * 说明：recyclerview adapter （里层列表，个人理解）
 * <p>
 * 继承DelegateAdapter.Adapter
 * 其他的跟普通recyclerview的写法一样,只是多了一个onCreateLayoutHelper()
 * 方法，将传过来的LayoutHelper返回就可以了
 * ================================================
 */

public class MyRecyclerAdapter extends DelegateAdapter.Adapter {
    private LayoutInflater layoutInflater;
    public Context context;
    private LayoutHelper helper;
    private String name;

    public MyRecyclerAdapter(Context context, LayoutHelper linearLayoutHelper, String name) {
        layoutInflater = LayoutInflater.from(context);
        helper = linearLayoutHelper;
        this.context = context;
        this.name = name;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return helper;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(layoutInflater.inflate(R.layout.item_vlayout, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MyViewHolder myViewHolder = (MyViewHolder) holder;
//        if (name.equals("GridLayoutHelper")) {}else

        if (name.equals("StaggeredGridLayoutHelper")) {
            //修改MyViewholder布局参数，这样看起来更像瀑布流
            ViewGroup.LayoutParams layoutParams = myViewHolder.name.getLayoutParams();
            layoutParams.height = 260 + position % 7 * 20;
            myViewHolder.name.setLayoutParams(layoutParams);

            if (position % 2 == 0) {
                holder.itemView.setBackgroundColor(Color.BLUE);
            } else {
                holder.itemView.setBackgroundColor(Color.GREEN);
            }

        }else if (name.equals("FixLayoutHelper")) {
            holder.itemView.setBackgroundColor(Color.RED);
        }else if (name.equals("ScrollFixLayoutHelper")) {
            holder.itemView.setBackgroundColor(Color.RED);
        }

//        else if (name.equals("ColumnLayoutHelper")) {}
//        else if (name.equals("SingleLayoutHelper")) {}
//        else if (name.equals("OnePlusNLayoutHelper")) {}

        else if (name.equals("FloatLayoutHelper")) {
            //修改MyViewholder布局参数，这样看起来更像瀑布流
            ViewGroup.LayoutParams layoutParams = myViewHolder.name.getLayoutParams();
            layoutParams.width = 400;
            myViewHolder.itemView.setLayoutParams(layoutParams);

            holder.itemView.setBackgroundColor(Color.RED);
        } else if (name.equals("StickyLayoutHelper")) {
            holder.itemView.setBackgroundColor(Color.RED);
        } else {
            if (position % 2 == 0) {
                holder.itemView.setBackgroundColor(Color.BLUE);
            } else {
                holder.itemView.setBackgroundColor(Color.GREEN);
            }
        }
        myViewHolder.name.setText(name + position + "");
    }

    @Override
    public int getItemCount() {
        if (name.equals("GridLayoutHelper")) {
            return 50;
        }  else if (name.equals("StaggeredGridLayoutHelper")) {
            return 60;
        } else if (name.equals("FixLayoutHelper")) {
            return 1;
        } else if (name.equals("ScrollFixLayoutHelper")) {
            return 1;
        }else if (name.equals("ColumnLayoutHelper")) {
            return 3;
        }else if (name.equals("SingleLayoutHelper")) {
            return 1;
        } else if (name.equals("OnePlusNLayoutHelper")) {
            return 3;
        }else if (name.equals("FloatLayoutHelper")) {
            return 1;
        } else if (name.equals("StickyLayoutHelper")) {
            return 1;
        } else {
            return 50;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.item_name);
        }
    }
}
