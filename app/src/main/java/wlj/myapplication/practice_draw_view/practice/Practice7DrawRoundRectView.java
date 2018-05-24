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

public class Practice7DrawRoundRectView extends View {

    public Practice7DrawRoundRectView(Context context) {
        super(context);
    }

    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawRoundRect() 方法画圆角矩形
        //有一个重载方法 drawRoundRect(RectF rect, float rx, float ry, Paint paint)，
        // 可以直接填写 RectF 来绘制圆角矩形

        Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeWidth(10);//画笔填充大小
        paint.setColor(Color.GREEN);//画笔颜色,默认黑色
        paint.setStyle(Paint.Style.STROKE);//填充模式为边框填充 (内容  边框)
        canvas.drawRoundRect(100, 100, 500, 300, 30, 30, paint);

        paint.setStrokeWidth(0);//画笔填充大小
        paint.setColor(Color.BLACK);//画笔颜色,默认黑色
        paint.setStyle(Paint.Style.FILL);//填充模式为内容填充 (内容  边框)
        canvas.drawRoundRect(550, 100, 950, 300, 30, 30, paint);

    }
}
