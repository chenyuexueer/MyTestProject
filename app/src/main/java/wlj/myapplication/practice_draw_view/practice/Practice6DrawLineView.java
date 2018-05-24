package wlj.myapplication.practice_draw_view.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/19.
 * 说明：
 * ================================================
 */

public class Practice6DrawLineView extends View {

    public Practice6DrawLineView(Context context) {
        super(context);
    }

    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawLine() 方法画直线
        //由于直线不是封闭图形，所以 setStyle(style) 对直线没有影响。

        Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);//抗锯齿画笔
        paint.setStrokeWidth(10);//画笔填充大小
        paint.setColor(Color.GREEN);//画笔颜色,默认黑色
        canvas.drawLine(50, 50, 300, 500, paint);//起点（50,50）终点（100,500）开始绘制直线

        paint.setColor(Color.BLACK);//画笔颜色,默认黑色
        float[] points = {
                400, 50, 800, 50,//横
                600, 00, 600, 500,//竖
                600, 50, 450, 500,//左撇
                600, 50, 750, 500,//右撇
                400, 550, 350, 600,//左撇 点
                550, 550, 600, 600,//右撇 点
                650, 550, 700, 600,//右撇 点
                750, 550, 800, 600};//右撇 点
        canvas.drawLines(points, paint);

    }
}
