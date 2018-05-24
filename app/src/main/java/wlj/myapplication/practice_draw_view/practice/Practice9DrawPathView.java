package wlj.myapplication.practice_draw_view.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
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

public class Practice9DrawPathView extends View {

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形

        Path path = new Path(); // 初始化 Path 对象，绘制路径

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);//抗锯齿画笔
        paint.setColor(Color.RED);

        //绘制路径 枚举
        {
            // 使用 path 对图形进行描述（这段描述代码可不必看懂,当然，懂最好）
            path.addArc(200, 200, 400, 400, -225, 225);
            path.arcTo(400, 200, 600, 400, -180, 225, false);
            path.lineTo(400, 542);
        }
        canvas.drawPath(path, paint); // 绘制出 path 描述的图形（心形）

        //绘制交叉圆
//        paint.setStyle(Paint.Style.STROKE);//划线模式
//        path.addCircle(300, 300, 200, Path.Direction.CW);//顺时针 CW
//        canvas.drawPath(path, paint);// 绘制出 path 描述的图形（圆形）
//        path.addCircle(500, 300, 200, Path.Direction.CW);//逆时针 CCW
//        canvas.drawPath(path, paint);// 绘制出 path 描述的图形（圆形）

        //绘制交叉圆 圆环
//        paint.setStyle(Paint.Style.STROKE);//划线模式
//        paint.setStrokeWidth(30);//交叉圆环
//        path.addCircle(300, 300, 200, Path.Direction.CW);//顺时针 CW
//        canvas.drawPath(path, paint);// 绘制出 path 描述的图形（圆形）
//        path.addCircle(500, 300, 200, Path.Direction.CW);//逆时针 CCW
//        canvas.drawPath(path, paint);// 绘制出 path 描述的图形（圆形）

        //绘制交叉圆  橄榄球1
//        paint.setColor(Color.BLACK);//画笔颜色
//        paint.setStyle(Paint.Style.FILL_AND_STROKE);//内容边框填充模式
//        path.addCircle(300, 300, 200, Path.Direction.CW);//顺时针 CW
//        canvas.drawPath(path, paint);// 绘制出 path 描述的图形（圆形）
//        paint.setColor(Color.WHITE);//画笔颜色
////        paint.setStyle(Paint.Style.FILL);//内容填充模式
//        path.addCircle(500, 300, 200, Path.Direction.CCW);//逆时针 CCW
//        canvas.drawPath(path, paint);// 绘制出 path 描述的图形（圆形）

        //绘制交叉圆  橄榄球2
//        paint.setColor(Color.WHITE);//画笔颜色
//        paint.setStyle(Paint.Style.FILL_AND_STROKE);//内容边框填充模式
//        path.addCircle(300, 300, 200, Path.Direction.CW);//顺时针 CW
//        canvas.drawPath(path, paint);// 绘制出 path 描述的图形（圆形）
//        paint.setColor(Color.BLACK);//画笔颜色
////        paint.setStyle(Paint.Style.FILL);//内容填充模式
//        path.addCircle(500, 300, 200, Path.Direction.CCW);//逆时针 CCW
//        canvas.drawPath(path, paint);// 绘制出 path 描述的图形（圆形）


        //其他的 Path.addXxx()+ canvas.drawPath()
        //addOval()
        //addRect()
        //addRoundRect()



    }
}
