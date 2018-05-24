package wlj.myapplication.practice_draw_view2.sample;

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
 * 说明：设置线头的形状。线头形状有三种：BUTT 平头、ROUND 圆头、SQUARE 方头。默认为 BUTT。
 * ================================================
 */

public class Sample09StrokeCapView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Sample09StrokeCapView(Context context) {
        super(context);
    }

    public Sample09StrokeCapView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample09StrokeCapView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setStrokeWidth(40);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawLine(50, 50, 400, 50, paint);

        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawLine(50, 150, 400, 150, paint);

        paint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawLine(50, 250, 400, 250, paint);
    }
}
