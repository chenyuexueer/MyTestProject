package wlj.myapplication.practice_draw_view.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import static android.graphics.Paint.ANTI_ALIAS_FLAG;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/19.
 * 说明：
 * ================================================
 */

public class Practice2DrawCircleView extends View {

    public Practice2DrawCircleView(Context context) {
        super(context);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆

        Paint paint=new Paint(ANTI_ALIAS_FLAG);//抗锯齿画笔ANTI_ALIAS_FLAG
        paint.setColor(Color.BLACK);//画笔颜色
        canvas.drawCircle(300, 200, 150, paint);//开始绘制

        paint.setColor(Color.BLACK);//画笔颜色
        paint.setStyle(Paint.Style.STROKE); // Style 修改为画线模式，默认是FILL內容填充模式
        canvas.drawCircle(700, 200, 150, paint);//开始绘制

        paint.setColor(Color.BLUE);//画笔颜色
        paint.setStyle(Paint.Style.FILL_AND_STROKE); // Style 修改为画线模式+內容填充模式,即圆的半径为150+30
        paint.setStrokeWidth(30); // 线条宽度为 30 像素
        canvas.drawCircle(300, 600, 150, paint);//开始绘制

        paint.setColor(Color.BLACK);//画笔颜色
        paint.setStyle(Paint.Style.STROKE); // Style 修改为画线模式
        paint.setStrokeWidth(30); // 线条宽度为 30 像素
        canvas.drawCircle(700, 600, 150, paint);//开始绘制
    }
}
