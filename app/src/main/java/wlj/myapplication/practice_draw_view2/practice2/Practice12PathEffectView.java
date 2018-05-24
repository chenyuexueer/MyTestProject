package wlj.myapplication.practice_draw_view2.practice2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.SumPathEffect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/19.
 * 说明：使用 PathEffect 来给图形的轮廓设置效果
 *
 * PathEffect 在有些情况下不支持硬件加速，需要关闭硬件加速才能正常使用
 *
 *  6 种 PathEffect。PathEffect 分为两类，
 *  单一效果的 CornerPathEffect DiscretePathEffect DashPathEffect PathDashPathEffect ，
 *  和组合效果的 SumPathEffect ComposePathEffect
 * ================================================
 */

public class Practice12PathEffectView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();

    public Practice12PathEffectView(Context context) {
        super(context);
    }

    public Practice12PathEffectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice12PathEffectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private final CornerPathEffect cornerPathEffect;
    private final DiscretePathEffect discretePathEffect;
    private final DashPathEffect dashPathEffect;
    private final PathDashPathEffect pathDashPathEffect;
    private final SumPathEffect sumPathEffect;
    private final ComposePathEffect composePathEffect;

    {
        paint.setStyle(Paint.Style.STROKE);

        path.moveTo(50, 100);
        path.rLineTo(50, 100);
        path.rLineTo(80, -150);
        path.rLineTo(100, 100);
        path.rLineTo(70, -120);
        path.rLineTo(150, 80);

        //CornerPathEffect(float radius) 的参数 radius 是圆角的半径。
         cornerPathEffect = new CornerPathEffect(20);

        //DiscretePathEffect 具体的做法是，把绘制改为使用定长的线段来拼接，
        // 并且在拼接的时候对路径进行  随机偏离segmentLength 是用来拼接的每个线段的长度，
        // deviation 是偏离量
         discretePathEffect = new DiscretePathEffect(20, 5);

        //使用虚线来绘制线条
        //第一个参数 intervals 是一个数组，它指定了虚线的格式：数组中元素必须为偶数（最少是 2 个），
        // 按照「画线长度、空白长度、画线长度、空白长度」……的顺序排列，
        // 例如上面代码中的 20, 5, 10, 5 就表示虚线是按照「画 20 像素、空 5 像素、画 10 像素、空 5 像素」
        // 的模式来绘制；第二个参数 phase 是虚线的偏移量
         dashPathEffect = new DashPathEffect(new float[]{20, 10, 5, 10}, 0);

        //这个方法比 DashPathEffect 多一个前缀 Path ，所以顾名思义，它是使用一个 Path 来绘制「虚线
        //shape 参数是用来绘制的 Path ； advance 是两个相邻的 shape 段之间的间隔，不过注意，这个间隔是两
        // 个 shape 段的起点的间隔，而不是前一个的终点和后一个的起点的距离； phase 和 DashPathEffect 中一样，
        // 是虚线的偏移；最后一个参数 style，是用来指定拐弯改变的时候 shape 的转换方式。
        // style 的类型为 PathDashPathEffect.Style ，是一个 enum ，具体有三个值：
        //TRANSLATE：位移  ROTATE：旋转   MORPH：变体
        Path dashPath = new Path();
        dashPath.lineTo(20, -30);
        dashPath.lineTo(40, 0);
        dashPath.close();
         pathDashPathEffect= new PathDashPathEffect(dashPath, 50, 0, PathDashPathEffect.Style.MORPH);

        //一个组合效果类的 PathEffect   分别按照两种 PathEffect 分别对目标进行绘制
         sumPathEffect = new SumPathEffect(dashPathEffect, discretePathEffect);

        //一个组合效果类的 PathEffect 。不过它是先对目标 Path 使用一个 PathEffect，
        // 然后再对这个改变后的 Path 使用另一个 PathEffect
        //innerpe 是先应用的， outerpe 是后应用的。所以上面的代码就是「先偏离，再变虚线」。
        // 而如果把两个参数调换，就成了「先变虚线，再偏离」
         composePathEffect = new ComposePathEffect(dashPathEffect, discretePathEffect);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 Paint.setPathEffect() 来设置不同的 PathEffect

        // 第一处：CornerPathEffect  把所有拐角变成圆角
        paint.setPathEffect(cornerPathEffect);
        canvas.drawPath(path, paint);

        canvas.save();
        canvas.translate(500, 0);
        // DiscretePathEffect
        paint.setPathEffect(discretePathEffect);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 200);
        // 第三处：DashPathEffect
        paint.setPathEffect(dashPathEffect);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 200);
        // 第四处：PathDashPathEffect
        paint.setPathEffect(pathDashPathEffect);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 400);
        // 第五处：SumPathEffect
        // SumPathEffect
        paint.setPathEffect(sumPathEffect);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 400);
        // 第六处：ComposePathEffect
        paint.setPathEffect(composePathEffect);
        canvas.drawPath(path, paint);
        canvas.restore();
    }
}
