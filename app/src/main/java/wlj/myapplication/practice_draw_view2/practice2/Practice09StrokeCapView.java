package wlj.myapplication.practice_draw_view2.practice2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/19.
 * 说明：setStrokeCap（）设置线头的形状。线头形状有三种：BUTT 平头、ROUND 圆头、SQUARE 方头。默认为 BUTT。
 *
 * Paint 的两个色彩优化的方法： setDither(dither) ，设置抖动来优化色彩深度降低时的绘制效果；
 * setFilterBitmap(filterBitmap) ，设置双线性过滤来优化 Bitmap 放大绘制的效果(暂无示例)
 * ================================================
 */

public class Practice09StrokeCapView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice09StrokeCapView(Context context) {
        super(context);
    }

    public Practice09StrokeCapView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice09StrokeCapView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setStrokeWidth(40);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置线头的形状。线头形状有三种：BUTT 平头、ROUND 圆头、SQUARE 方头。默认为 BUTT。

        // 使用 Paint.setStrokeCap() 来设置端点形状

        // 第一个：BUTT
        paint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawLine(50, 50, 400, 50, paint);

        // 第二个：ROUND
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawLine(50, 150, 400, 150, paint);

        // 第三个：SQUARE
        paint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawLine(50, 250, 400, 250, paint);
    }
}
