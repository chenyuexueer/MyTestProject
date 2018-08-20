package wlj.weights;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/8/18.
 * 说明：viewdraghelper自定义view
 *
 *
 * 主要解决触摸事件被消耗掉
 * ================================================
 */
public class MyLinearLayout3 extends LinearLayout {

    ViewDragHelper viewDragHelper;
    private String TAG="MyLinearLayout==";
    private View mParent;
    private View mBottomMenu;

    public MyLinearLayout3(Context context) {
        super(context);
        initViewDragHelper();
    }

    public MyLinearLayout3(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initViewDragHelper();
    }

    public MyLinearLayout3(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViewDragHelper();
    }

    public MyLinearLayout3(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initViewDragHelper();
    }










    //初始化viewDragHelper
    private void initViewDragHelper() {

        setOrientation(VERTICAL);

        ViewDragHelper.Callback callback = new ViewDragHelper.Callback() {
            /**
             *
             * @param child
             * @param pointerId
             * @return
             *
             * 返回值表示是否捕捉这个 view 的拖拽事件,这个方法会多次被调用，每次都会被调用即使是同
             * 一个view已经被拖拽过下次拖拽也会被调用，如果要对某个子view进行拖拽处理，一般是这样
             * 子写child == mDragView，但这个view被拖拽就会返回true，触发这个方法
             *
             * tryCaptureView如何返回ture则表示可以捕获该view即是哪个View可以滑动，哪个不可以滑动，在这个方
             *法里面控制
             *
             */
            @Override
            public boolean tryCaptureView(View child, int pointerId) {
                Log.d(TAG, "tryCaptureView, left="+child.getLeft()+"; top="+child.getTop());

                //在tryCaptureView中，捕捉到的是底部菜单的 View，内容区域的 View 不需要捕捉
                return child == mBottomMenu;
            }

            /**
             * 约束了 View 在水平方向上的运动。该方法默认是返回0的，所以一般都是需要重写的
             * 可处理子view拖拽不能超出屏幕边缘
             *
             * @param child 被拖拽的 View
             * @param left  拖动的 View 理论上将要滑动到的水平方向上的值
             * @param dx    滑动的速度，单位是 px 每秒。
             * @return  返回值是水平方向上的实际的x坐标的值
             */
            @Override
            public int clampViewPositionHorizontal(View child, int left, int dx) {
                return super.clampViewPositionHorizontal( child,  left,  dx);
            }

            /**
             * 约束了 View 在垂直方向上的运动。该方法默认是返回0的，所以一般都是需要重写的
             * 可处理子view拖拽不能超出屏幕边缘
             *
             * @param child 被拖拽的 View
             * @param top  拖动的 View 理论上将要滑动到的垂直方向上的值
             * @param dy    滑动的速度，单位是 px 每秒。
             * @return  返回值是垂直方向上的实际的y坐标的值
             */
            @Override
            public int clampViewPositionVertical(View child, int top, int dy) {
                Log.d(TAG, "top=" + top + "; dy=" + dy);
                return Math.max(getHeight() - child.getHeight(), top);
            }

            /**
             * 子view的
             * 当ViewDragHelper拖拽状态发生变化时回调（IDLE,DRAGGING,SETTING[自动滚动时]）
             * @param state
             */
            @Override
            public void onViewDragStateChanged(int state) {
                super.onViewDragStateChanged(state);
            }

            /**
             * 当captureView的位置发生改变时回调
             *
             * @param changedView
             * @param left
             * @param top
             * @param dx
             * @param dy
             */
            @Override
            public void onViewPositionChanged(@NonNull View changedView, int left, int top, int dx, int dy) {
                super.onViewPositionChanged(changedView, left, top, dx, dy);
            }

            /**
             *当CaptureView被捕获时回调
             *
             * @param capturedChild
             * @param activePointerId
             */
            @Override
            public void onViewCaptured(@NonNull View capturedChild, int activePointerId) {
                super.onViewCaptured(capturedChild, activePointerId);
            }

            /**
             *
             *
             *  手指释放的时候回调，就是这个 View 已经不再被拖拽的时候调用,但此时这个view并没有停止滚动
             *
             *  可处理类似的情况：微信的语音视频的悬浮按钮，会自动吸附靠近屏幕边沿
             *
             * @param releasedChild
             * @param xvel
             * @param yvel
             */
            @Override
            public void onViewReleased(@NonNull View releasedChild, float xvel, float yvel) {
                if (yvel <= 0) {
                    viewDragHelper.settleCapturedViewAt(0,
                            getHeight() - releasedChild.getHeight());
                } else {
                    viewDragHelper.settleCapturedViewAt(0, getHeight());
                }
                invalidate();//刷新view
            }

            //<<<<<======================这三个方法能处理侧滑退出activity或者侧滑菜单场景
            /**
             * 当触摸到边界时回调。
             *
             * 表示开始触摸到 ViewGroup 的边缘，此时并不一定开始有拖拽的动作的回调
             *
             * @param edgeFlags
             * @param pointerId
             */
            @Override
            public void onEdgeTouched(int edgeFlags, int pointerId) {
                super.onEdgeTouched(edgeFlags, pointerId);
                Log.d(TAG, "onEdgeTouched");
            }

            /**
             * true的时候会锁住当前的边界，false则unLock。
             *
             * 这个方法返回 true 会锁住当前的边界。
             *
             * @param edgeFlags
             * @return
             */
            @Override
            public boolean onEdgeLock(int edgeFlags) {
                Log.d(TAG, "onEdgeLock");
                return super.onEdgeLock(edgeFlags);
            }

            /**
             * 在边界拖动时状态回调
             * 表示用户开始从边缘拖拽
             *
             * @param edgeFlags
             * @return
             */
            @Override
            public void onEdgeDragStarted(int edgeFlags, int pointerId) {
                Log.d(TAG, "onEdgeDragStarted");
                viewDragHelper.captureChildView(mBottomMenu, pointerId);
            }
            //======================这三个方法能处理侧滑退出activity或者侧滑菜单场景>>>>>

            /**
             * 改变同一个坐标（x,y）去寻找captureView位置的方法
             * @param index
             * @return
             */
            @Override
            public int getOrderedChildIndex(int index) {
                return super.getOrderedChildIndex(index);
            }

            //<<<<================主要解决触摸事件被 消耗掉
            /**
             * 水平方向，子View要是消耗事件，就要重写此方法返回大于1的数。
             *
             * 返回子 View 在水平方向可以被拖拽的范围，返回值的单位是 px。
             *
             * @param child
             * @return
             */
            @Override
            public int getViewHorizontalDragRange(@NonNull View child) {
                Log.d(TAG, "getViewHorizontalDragRange");
                return getMeasuredWidth() - child.getMeasuredWidth();//与5的区别---------主要解决触摸事件被 消耗掉
            }

            /**
             * 返回子 View 在竖直方向可以被拖拽的范围，返回值的单位是 px。
             *垂直方向，子View要是消耗事件，就要重写此方法返回大于1的数。
             * @param child
             * @return
             */
            @Override
            public int getViewVerticalDragRange(@NonNull View child) {
                Log.d(TAG, "getViewVerticalDragRange");
                return getMeasuredHeight() - child.getMeasuredHeight();//与5的区别--------主要解决触摸事件被 消耗掉
            }

            //==================主要解决触摸事件被消耗掉>>>>
        };

        viewDragHelper = ViewDragHelper.create(this, 1.0f,callback);
        // 触发边缘为下边缘
        viewDragHelper.setEdgeTrackingEnabled(ViewDragHelper.EDGE_BOTTOM);
    }







    //<<<<<<<<<<<<<<<<<<<<<<<<拖拽拦截
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return viewDragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        viewDragHelper.processTouchEvent(event);
        return true;
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>拖拽拦截











    //-----------------------------配合这几个方法------------------------
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        // 假设第一个子 view 是内容区域，第二个是菜单
        mParent = getChildAt(0);
        mBottomMenu = getChildAt(1);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
            invalidate();
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (mBottomMenu != null && mParent != null) {
            mBottomMenu.layout(0, getHeight(), mBottomMenu.getMeasuredWidth(),
                    getHeight() + mBottomMenu.getMeasuredHeight());
            mParent.layout(0, 0, mParent.getMeasuredWidth(), mParent.getMeasuredHeight());
        }
    }

}
