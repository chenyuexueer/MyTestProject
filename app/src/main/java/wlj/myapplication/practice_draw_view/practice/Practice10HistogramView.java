package wlj.myapplication.practice_draw_view.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/19.
 * 说明：
 * ================================================
 */

public class Practice10HistogramView extends View {

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图

        Path path = new Path(); // 初始化 Path 对象，绘制路径

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);//抗锯齿画笔
        paint.setColor(Color.WHITE);
//
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth(5);
//        path.rMoveTo(100,0);//移动起点 偏移量x=100，y=0
//        path.lineTo(200, 100); // 由当前位置 (0, 0) 向 (100, 100) 画一条直线
//        path.rLineTo(100, 0); // 由当前位置 (100, 100) 向正右方 偏移量x=100像素，y=0 像素的位置画一条直线
//        canvas.drawPath(path, paint);// 绘制出 path 描述的图形（）
//
//        path.rMoveTo(-200,0);//移动起点 偏移量x=-200，y=0
//        path.lineTo(200, 200); // 由当前位置 (0, 0) 向 (100, 100) 画一条直线
//        path.rLineTo(100, 0); // 由当前位置 (100, 100) 向正右方 100 像素的位置画一条直线
//        canvas.drawPath(path, paint);// 绘制出 path 描述的图形（）
        
        paint.setStrokeWidth(2);
        float[] pos = {150, 100, 150, 560, 150, 560, 1000, 560};//线的多个点，每两个坐标为一个点
        canvas.drawLines(pos, paint);//绘制多条线，即x y两条轴
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);//内容填充
        path.addRect(175, 555, 267.85f, 560, Path.Direction.CW);
        path.addRect(292.85f, 540, 385.7f, 560, Path.Direction.CW);
        path.addRect(410.7f, 540, 503.55f, 560, Path.Direction.CW);
        path.addRect(528.55f, 400, 621.4f, 560, Path.Direction.CW);
        path.addRect(646.4f, 280, 739.25f, 560, Path.Direction.CW);
        path.addRect(764.25f, 200, 857.1f, 560, Path.Direction.CW);
        path.addRect(882.1f, 420, 974.95f, 560, Path.Direction.CW);
        canvas.drawPath(path, paint);

        paint.reset();//画笔重置
        paint.setColor(Color.WHITE);
        paint.setTextSize(TypedValue.applyDimension(2, 12.0F, this.getResources().getDisplayMetrics()));//设置绘制字体大小
        canvas.drawText("Froyo", (175 + 46.425f - paint.measureText("Froyo") / 2), 590, paint);//绘制文字
        canvas.drawText("GB", (292.85f + 46.425f - paint.measureText("GB") / 2), 590, paint);//绘制文字
        canvas.drawText("ICS", (410.7f + 46.425f - paint.measureText("ICS") / 2), 590, paint);//绘制文字
        canvas.drawText("JB", (528.55f + 46.425f - paint.measureText("JB") / 2), 590, paint);//绘制文字
        canvas.drawText("KitKat", (646.4f + 46.425f - paint.measureText("KitKat") / 2), 590, paint);//绘制文字
        canvas.drawText("L", (764.25f + 46.425f - paint.measureText("L") / 2), 590, paint);//绘制文字
        canvas.drawText("M", (882.1f + 46.425f - paint.measureText("M") / 2), 590, paint);//绘制文字

        paint.setTextSize(TypedValue.applyDimension(2, 22.0F, this.getResources().getDisplayMetrics()));//设置绘制字体大小
        canvas.drawText("直方图", 500, 690, paint);//绘制文字

    }
}
