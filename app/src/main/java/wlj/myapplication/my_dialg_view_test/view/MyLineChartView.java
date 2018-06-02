package wlj.myapplication.my_dialg_view_test.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.util.AttributeSet;

import java.text.DecimalFormat;
import java.util.ArrayList;

import wlj.myapplication.my_dialg_view_test.view.view_options.MyLineChartViewOption;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/30.
 * 说明：
 * <p>
 * 折线图
 * |
 * |         /\
 * |    /\  /  \
 * |   /  \/    \
 * |  /          \
 * |_/_____________
 * ================================================
 */

public class MyLineChartView extends android.support.v7.widget.AppCompatTextView {

    /**
     * 数据
     */
    private ArrayList<LLineChartBean> beans;
    /**
     * 参数类
     */
    private MyLineChartViewOption o;

    /**
     * 横坐标偏移量，用来滑动
     */
    private int offset;
    /**
     * 图表的范围
     */
    private int width, height;
    /**
     * 格子宽度，高度
     */
    private int gridW, gridH;
    /**
     * 画笔
     */
    private Paint chartPaint, lablePaint, gridPaint, pointPaint;
    /**
     * 四个方向的预留
     */
    private int left = 0, right = 0, bottom = 0, top = 0;
    /**
     * 移动步长
     */
    private float step;
    /**
     * 当前步数
     */
    private int index = 0;
    /**
     * 最大步数
     */
    private int maxIndex = 100;
    /**
     * 线条宽度
     */
    private int lineWidth = 0;
    /**
     * 浮点数格式化
     */
    private DecimalFormat df;
    /**
     * 虚线样式
     */
    private PathEffect effects;

    @Override
    protected void onDraw(Canvas canvas) {
        drawShell(canvas);
        if (o.isCurve) {
            drawScrollLine(canvas);
        } else {
            drawLine(canvas);
        }
        if (index < maxIndex) {
            invalidate();
            index++;
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        width = getWidth();
        height = getHeight();
        onDataChange();
        super.onLayout(changed, left, top, right, bottom);
    }

    /**
     * 画外壳
     *
     * @param canvas
     */
    private void drawShell(Canvas canvas) {
        int x, y;
        String s;
        if (df == null)
            df = new DecimalFormat("0.00");
        Paint.FontMetrics fm = lablePaint.getFontMetrics();//字体
        lablePaint.setTextSize(getTextSize());//y轴画笔的字体大小(官方方法)
        lablePaint.setColor(o.scaleColor);//y轴画笔的颜色(参数    x y刻度   的颜色)
        gridPaint.setColor(o.scaleColor);//x轴画笔颜色(参数    x y刻度  的颜色)
        //Y轴刻度标记文字
        for (int i = 0; i <= o.scaleSize; i++) {//刻度数量
            s = df.format(o.maxNum / o.scaleSize * i) + "";//第i个刻度的值
            x = (int) (left - ((0.5 + s.length()) * 0.5) * getTextSize() * 0.5);
            y = (int) (height - bottom - gridH * i - fm.descent + (fm.descent - fm.ascent) / 2);
            canvas.drawText(s, x, y, lablePaint);
        }
        //X轴刻度文字
        y = (int) (height - getTextSize() - fm.descent + (fm.descent - fm.ascent) / 2);
        for (int i = 0; i < o.lable.length; i++) {
            s = o.lable[i];
            x = left + gridW * (i + 1);
            canvas.drawText(s, x, y, lablePaint);
        }
        //画线
        gridPaint.setStrokeWidth(lineWidth);
        Path xyPath = new Path();
        xyPath.moveTo(left, top);
        //Y轴
        xyPath.lineTo(left, height - bottom);
        //X轴
        xyPath.lineTo(width - right, height - bottom);
        canvas.drawPath(xyPath, gridPaint);
        //更新线宽度
        gridPaint.setStrokeWidth(lineWidth * 0.3f);
        //更新线颜色
        gridPaint.setColor(o.gridColor);
        if (effects == null)
            effects = new DashPathEffect(new float[]{lineWidth, lineWidth, lineWidth * 4, lineWidth}, 1);
        gridPaint.setPathEffect(effects);
        //绘制横向网格线
        for (int i = 1; i < o.scaleSize; i++) {
            canvas.drawLine(left, height - bottom - i * gridH, width - right, height - bottom - i * gridH, gridPaint);
        }
        //绘制纵向网格线
        for (int i = 1; i <= o.lable.length; i++) {
            canvas.drawLine(left + i * gridW, top, left + i * gridW, height - bottom, gridPaint);
        }
        gridPaint.setPathEffect(null);
    }

    /**
     * 画曲线
     *
     * @param canvas 画布
     */
    private void drawScrollLine(Canvas canvas) {
        int x, y;
        int x1, y1;
        int x2, y2;
        int ind;
        Paint.FontMetrics fm = chartPaint.getFontMetrics();
        float textY;
        ind = (int) ((1 - 1.0 * index / maxIndex) * (height - top - bottom) + top);
        for (LLineChartBean bean : beans) {
            getChartPaint(bean.color);
            Path path = new Path();
            for (int i = 0; i < bean.lable.length; i++) {
                x = left + (i + 1) * gridW;
                y = (int) ((1 - bean.lable[i] / o.maxNum) * (height - top - bottom) + top);
                x1 = x2 = (int) (left + (i + 1) * gridW - 0.5 * gridW);
                if (i > 0) {
                    y1 = (int) ((1 - bean.lable[i - 1] / o.maxNum) * (height - top - bottom) + top);
                } else {
                    y1 = y;
                }
                y2 = y;
                y = y > ind ? y : ind;
                y1 = y1 > ind ? y1 : ind;
                y2 = y2 > ind ? y2 : ind;
                if (i == 0) {
                    path.moveTo(x, y);
                } else {
                    path.cubicTo(x1, y1, x2, y2, x, y);
                }
                canvas.drawCircle(x, y, lineWidth, pointPaint);
                textY = y - lineWidth - getTextSize() / 2 - fm.descent + (fm.descent - fm.ascent) / 2;
                canvas.drawText(bean.lable[i] + "", x, textY, lablePaint);
            }
            canvas.drawPath(path, chartPaint);
        }
    }

    private void getChartPaint(int color) {
        chartPaint.setColor(color);
        pointPaint.setColor(color);
        lablePaint.setColor(color);
        chartPaint.setStrokeWidth(lineWidth);
        pointPaint.setStrokeWidth(lineWidth);
    }

    /**
     * 画直线
     *
     * @param canvas 画布
     */
    private void drawLine(Canvas canvas) {
        int x, y, ind;
        Paint.FontMetrics fm = chartPaint.getFontMetrics();//直线画笔的
        float textY;
        ind = (int) ((1 - 1.0 * index / maxIndex) * (height - top - bottom) + top);
        for (LLineChartBean bean : beans) {
            getChartPaint(bean.color);
            Path path = new Path();
            for (int i = 0; i < bean.lable.length; i++) {
                x = left + (i + 1) * gridW;
                y = (int) ((1 - bean.lable[i] / o.maxNum) * (height - top - bottom) + top);

                y = y > ind ? y : ind;
                if (i == 0) {
                    path.moveTo(x, y);
                } else {
                    path.lineTo(x, y);
                }
                canvas.drawCircle(x, y, lineWidth, pointPaint);
                textY = y - lineWidth - getTextSize() / 2 - fm.descent + (fm.descent - fm.ascent) / 2;
                canvas.drawText(bean.lable[i] + "", x, textY, lablePaint);
            }
            canvas.drawPath(path, chartPaint);
        }
    }

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        width = getWidth();
        height = getHeight();
        //        onDataChange();
        super.onWindowVisibilityChanged(visibility);
    }

    private void onDataChange() {
        if (o != null && o.lable != null) {
            int i = 0;
            for (String l : o.lable) {
                if (l.length() > i)
                    i = l.length();
            }
            if (df == null)
                df = new DecimalFormat("0.00");
            left = (int) (df.format(o.maxNum).length() * getTextSize() * 0.6);
            bottom = top = right = (int) (2 * getTextSize());
            if (o.canSlide) {
                gridW = (int) ((i + 1) * getTextSize());
            } else {
                gridW = (int) ((width - left - right) * 1.0 / (o.lable.length + 1));
            }
            gridH = (int) ((height - top - bottom) * 1.0 / o.scaleSize);
        }
        step = (height - 4 * getTextSize()) / maxIndex;
        if (lineWidth == 0) {
            lineWidth = height / 100;
        }
        index = 0;
    }


    public void setBeans(ArrayList<LLineChartBean> beans) {
        this.beans = beans;
        index = maxIndex;
        invalidate();
    }

    public void setOption(MyLineChartViewOption o) {
        this.o = o;
        onDataChange();
        invalidate();
    }

    public MyLineChartView(Context context) {
        this(context, null, 0);
    }

    public MyLineChartView(Context context, MyLineChartViewOption o) {
        this(context, null, 0);
        this.o = o;
    }

    public MyLineChartView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyLineChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        chartPaint = new Paint();
        pointPaint = new Paint();
        gridPaint = new Paint();
        gridPaint.setAntiAlias(true);
        gridPaint.setStyle(Paint.Style.STROKE);
        lablePaint = new Paint();
        lablePaint.setAntiAlias(true);
        lablePaint.setStyle(Paint.Style.STROKE);
        lablePaint.setTextAlign(Paint.Align.CENTER);
        chartPaint.setAntiAlias(true);
        chartPaint.setStyle(Paint.Style.STROKE);
        pointPaint.setAntiAlias(true);
        pointPaint.setStyle(Paint.Style.FILL);
    }

    public class LLineChartBean {
        final float[] lable;
        final int color;

        public LLineChartBean(float[] lable, int color) {
            this.lable = lable;
            this.color = color;
        }
    }

}