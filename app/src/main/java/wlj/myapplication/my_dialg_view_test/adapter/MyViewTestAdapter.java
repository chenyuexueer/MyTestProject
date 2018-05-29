package wlj.myapplication.my_dialg_view_test.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import wlj.myapplication.R;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/29.
 * 说明：
 * ================================================
 */

public class MyViewTestAdapter extends RecyclerView.Adapter<MyViewTestAdapter.MyViewHolder> {

    private String[] data;

    private static final int item_click = 200;

    //item点击
    private OnItemClickListener onItemClickListener;
    public interface OnItemClickListener{
        void onItemClick(String data,int position);
    }

    //item点击回调
    private OnItemClickHandler handler;
    private class OnItemClickHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case item_click:
                    if(onItemClickListener!=null){
                        int p = (int) msg.obj;
                        onItemClickListener.onItemClick(data[p],p);
                    }
                    break;
            }
            super.handleMessage(msg);
        }
    }

    //点击实现
    private class OnClick implements View.OnClickListener{
        private final int position;

        public OnClick(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View v) {
            Message message = new Message();
            message.what = item_click;
            message.obj = position;
            handler.sendMessage(message);//发送message  回调点击事件处理
        }
    }

    private static Context context;

    public MyViewTestAdapter(Context context,String[] data){
        super();
        this.data = data;
        this.context = context;
        handler = new OnItemClickHandler();
    }

    public MyViewTestAdapter(String[] data, OnItemClickListener onItemClickListener, Context context) {
        this(context, data);//调用两个参数的
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_my_view_test, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ((MyViewHolder)holder).text.setText(data[position]);
        ((MyViewHolder)holder).text.setOnClickListener(new OnClick(position));
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView text;
        public MyViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.item_main_text);

        }
    }
}
