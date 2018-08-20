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
 * 仿微信或者360悬浮框自动靠边对齐
 * ================================================
 */
public class MyLinearLayout4 extends LinearLayout {

    ViewDragHelper viewDragHelper;
    private String TAG="MyLinearLayout==";

    public MyLinearLayout4(Context context) {
        super(context);
        initViewDragHelper();
    }

    public MyLinearLayout4(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initViewDragHelper();
    }

    public MyLinearLayout4(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViewDragHelper();
    }

    public MyLinearLayout4(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initViewDragHelper();
    }








    private int mCurrentTop;
    private int mCurrentLeft;
    //初始化viewDragHelper
    private void initViewDragHelper() {

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
                Log.d(TAG, "tryCaptureView, 原始Left=" + child.getLeft() + "; 原始Top=" + child.getTop());
                return true;
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
                Log.d(TAG, "left=" + left + "; dx=" + dx);
                // 最小 x 坐标值不能小于 leftBound
                final int leftBound = getPaddingLeft();
                // 最大 x 坐标值不能大于 rightBound
                final int rightBound = getWidth() - child.getWidth() - getPaddingRight();
                final int newLeft = Math.min(Math.max(left, leftBound), rightBound);
                mCurrentLeft = newLeft;
                return newLeft;
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
                // 最小 y 坐标值不能小于 topBound
                final int topBound = getPaddingTop();
                // 最大 y 坐标值不能大于 bottomBound
                final int bottomBound = getHeight() - child.getHeight() - getPaddingBottom();
                final int newTop = Math.min(Math.max(top, topBound), bottomBound);
                mCurrentTop = newTop;
                return newTop;
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
                super.onViewReleased(releasedChild, xvel, yvel);
                Log.d(TAG, "onViewReleased, xvel=" + xvel + "; yvel=" + yvel);
                int childWidth = releasedChild.getWidth();
                int parentWidth = getWidth();
                int leftBound = getPaddingLeft();// 左边缘
                int rightBound = getWidth() - releasedChild.getWidth() - getPaddingRight();// 右边缘
                // 方块的中点超过 ViewGroup 的中点时，滑动到左边缘，否则滑动到右边缘
                if ((childWidth / 2 + mCurrentLeft) < parentWidth / 2) {
                    viewDragHelper.settleCapturedViewAt(leftBound, mCurrentTop);
                } else {
                    viewDragHelper.settleCapturedViewAt(rightBound, mCurrentTop);
                }
                invalidate();//系统方法view的刷新方法
            }

            //《《《《《《======================这三个方法能处理侧滑退出activity或者侧滑菜单场景
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
                super.onEdgeDragStarted(edgeFlags, pointerId);
            }
            //======================这三个方法能处理侧滑退出activity或者侧滑菜单场景》》》》》

            /**
             * 改变同一个坐标（x,y）去寻找captureView位置的方法
             * @param index
             * @return
             */
            @Override
            public int getOrderedChildIndex(int index) {
                return super.getOrderedChildIndex(index);
            }

            //<<<<================只要解决触摸事件被 消耗掉
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
                return super.getViewHorizontalDragRange(child);
            }

            /**
             * 返回子 View 在竖直方向可以被拖拽的范围，返回值的单位是 px。
             *垂直方向，子View要是消耗事件，就要重写此方法返回大于1的数。
             * @param child
             * @return
             */
            @Override
            public int getViewVerticalDragRange(@NonNull View child) {
                return super.getViewVerticalDragRange(child);
            }

            //==================只要解决触摸事件被消耗掉>>>>
        };

        viewDragHelper = ViewDragHelper.create(this, 1.0f,callback);
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







    /**
     * 配合这个系统(View)方法使用
     */
    @Override
    public void computeScroll() {
        super.computeScroll();
        if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
            invalidate();
        }
    }

}
