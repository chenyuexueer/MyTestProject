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

public class Practice5DrawOvalView extends View {

    public Practice5DrawOvalView(Context context) {
        super(context);
    }

    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawOval() 方法画椭圆，这个要求API 21以上,
        // 斜的椭圆也可以，但不是直接使用 drawOval()，而是配合几何变换
        //重载方法 drawOval(RectF rect, Paint paint)，可以填写 RectF 来绘制椭圆

        Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);//抗锯齿画笔
        paint.setColor(Color.BLACK);//画笔颜色,默认黑色
        paint.setStrokeWidth(20);//画笔填充大小


        paint.setStyle(Paint.Style.FILL);//填充模式为内容填充 (内容  边框)
        canvas.drawOval(50, 50, 350, 200, paint);

        paint.setStyle(Paint.Style.STROKE);//填充模式为边框填充 (内容  边框)
        canvas.drawOval(400, 50, 700, 200, paint);

    }
}
