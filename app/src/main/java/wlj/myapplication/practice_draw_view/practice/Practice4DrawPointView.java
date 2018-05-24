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

public class Practice4DrawPointView extends View {

    public Practice4DrawPointView(Context context) {
        super(context);
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPoint() 方法画点
//        一个圆点，一个方点
//        圆点和方点的切换使用 paint.setStrokeCap(cap)：`ROUND` 是圆点，`BUTT` 或 `SQUARE` 是方点


        Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);//抗锯齿画笔
        paint.setColor(Color.BLACK);//画笔颜色,默认黑色
        paint.setStrokeWidth(20);//画笔填充大小
        //填充模式  ROUND 画出来是圆形的点，SQUARE 或 BUTT 画出来是方形的点
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPoint(350, 50, paint);//点的位置（350,50）开始绘制

        paint.setStrokeWidth(20);//画笔填充大小
        paint.setColor(Color.RED);//画笔颜色,默认黑色
        //填充模式  ROUND 画出来是圆形的点，SQUARE 或 BUTT 画出来是方形的点
        paint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawPoint(650, 50, paint);//点的位置（650,50）开始绘制

        paint.setStrokeWidth(20);//画笔填充大小
        paint.setColor(Color.BLUE);//画笔颜色,默认黑色
        //填充模式  ROUND 画出来是圆形的点，SQUARE 或 BUTT 画出来是方形的点
        paint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawPoint(350, 350, paint);//点的位置（350,350）开始绘制

        paint.setStrokeWidth(50);//画笔填充大小
        paint.setColor(Color.GREEN);//画笔颜色,默认黑色
        //填充模式  ROUND 画出来是圆形的点，SQUARE 或 BUTT 画出来是方形的点
        paint.setStrokeCap(Paint.Cap.ROUND);
//        float[] points = {0, 0, 50, 50, 50, 100, 200, 100, 200, 200, 50, 200};
        float[] points = { 0, 0, 50, 50 , 50, 100, 200, 100, 200, 200, 50, 200};
        // 绘制四个点：(50, 50) (50, 100) (100, 50) (100, 100)
        canvas.drawPoints(points, 4 /* 跳过四个数，即前两个 点(0,0),(50,50)*/,
                8 /* 一共绘制 8 个数（4 个点）*/, paint);
    }
}
