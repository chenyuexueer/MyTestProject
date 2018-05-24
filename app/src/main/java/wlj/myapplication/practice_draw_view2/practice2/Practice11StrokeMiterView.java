package wlj.myapplication.practice_draw_view2.practice2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/19.
 * 说明：setStrokeMiter(float miter)这个方法是对于 setStrokeJoin() 的一个补充，
 * 它用于设置 MITER 型拐角的延长线的最大值 而这种补偿方案会有一个问题：
 * 如果拐角的角度太小，就有可能由于出现连接点过长的情况所以为了避免意料之外
 * 的过长的尖角出现， MITER 型连接点有一个额外的规则：当尖角过长时，自动改
 * 用  BEVEL 的方式来渲染连接点。例如上图的这个尖角，在默认情况下是不会出现的，
 * 而是会由于延长线过长而被转为 BEVEL 型连接点：
 * 至于多尖的角属于过于尖，尖到需要转为使用 BEVEL 来绘制，则是由一个属性控制的，
 * 而这个属性就是  setStrokeMiter(miter) 方法中的 miter 参数。miter 参数是对于转角长
 * 度的限制，具体来讲，是指尖角的外缘端点和内部拐角的距离与线条宽度的比
 *
 * ================================================
 */

public class Practice11StrokeMiterView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();

    public Practice11StrokeMiterView(Context context) {
        super(context);
    }

    public Practice11StrokeMiterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11StrokeMiterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setStrokeWidth(40);
        paint.setStyle(Paint.Style.STROKE);

        path.rLineTo(200, 0);
        path.rLineTo(-160, 120);


        canvas.save();

        canvas.translate(100, 100);
        // MITER 值：1
        paint.setStrokeMiter(1);
        canvas.drawPath(path, paint);

        canvas.translate(300, 0);
        // MITER 值：2
        paint.setStrokeMiter(3);
        canvas.drawPath(path, paint);

        canvas.translate(300, 0);
        // MITER 值：5
        paint.setStrokeMiter(5);
        canvas.drawPath(path, paint);

        canvas.restore();
    }
}
