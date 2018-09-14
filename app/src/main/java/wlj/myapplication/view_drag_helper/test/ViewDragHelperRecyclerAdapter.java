//自动生成包名 
package wlj.myapplication.view_drag_helper.test;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import wlj.myapplication.R;

//用默认的File Header即可 

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/9/14.
 * 说明：聊天互动Adapter
 * ================================================
 */
public class ViewDragHelperRecyclerAdapter<E> extends RecyclerView.Adapter<ViewDragHelperRecyclerAdapter.ViewHolder> { //包名也需要自动生成,同时注意List传参为泛型
    private Context mActivity;
    private List<E> chatInteractionData;//数据集合
    private OnItemClickListener mOnItemClickListener;

    //存放所有已经打开的删除菜单
    private List<ViewDragHelperRelativeLayout> openList = new ArrayList<ViewDragHelperRelativeLayout>();


    public ViewDragHelperRecyclerAdapter(Context mActivity, List<E> chatInteractionData) {
        this.mActivity = mActivity;
        this.chatInteractionData = chatInteractionData;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int itemViewId = R.layout.item_view_drag_helper_test;
        ViewHolder holder = new ViewHolder(LayoutInflater.from(mActivity).inflate(itemViewId, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.chatInteractionMessageNumberTv.setText("" + position);

        holder.viewDragHelperLayout.setSwipeChangeListener(new ViewDragHelperRelativeLayout.OnSwipeChangeListener() {

            @Override
            public void onStartOpen(ViewDragHelperRelativeLayout mViewDragHelperRelativeLayout) {

                for (ViewDragHelperRelativeLayout layout : openList) {
                    layout.close();
                }
                openList.clear();
            }

            @Override
            public void onStartClose(ViewDragHelperRelativeLayout mViewDragHelperRelativeLayout) {

            }

            @Override
            public void onOpen(ViewDragHelperRelativeLayout mViewDragHelperRelativeLayout) {
                openList.add(mViewDragHelperRelativeLayout);
            }

            @Override
            public void onDraging(ViewDragHelperRelativeLayout mViewDragHelperRelativeLayout) {

            }

            @Override
            public void onClose(ViewDragHelperRelativeLayout mViewDragHelperRelativeLayout) {
                openList.remove(mViewDragHelperRelativeLayout);
            }
        });


        // 如果设置了回调,则设置点击事件 
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView, pos);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemLongClick(holder.itemView, pos);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return null == chatInteractionData ? 0 : chatInteractionData.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView chatInteractionHeadIv;
        TextView chatInteractionMessageNumberTv;
        RelativeLayout chatInteractionHeadimgRl;
        TextView itemChatInteractionNameTv;
        TextView itemChatInteractionMessageTv;
        TextView chatInteractionTimeTv;
        ViewDragHelperRelativeLayout viewDragHelperLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            chatInteractionHeadIv= itemView.findViewById(R.id.chat_interaction_head_iv);
            chatInteractionMessageNumberTv=itemView.findViewById(R.id.chat_interaction_message_number_tv);
            chatInteractionHeadimgRl=itemView.findViewById(R.id.chat_interaction_headimg_rl);
            itemChatInteractionNameTv=itemView.findViewById(R.id.item_chat_interaction_name_tv);
            itemChatInteractionMessageTv=itemView.findViewById(R.id.item_chat_interaction_message_tv);
            viewDragHelperLayout=itemView.findViewById(R.id.view_drag_helper_layout);
        }
    }
}