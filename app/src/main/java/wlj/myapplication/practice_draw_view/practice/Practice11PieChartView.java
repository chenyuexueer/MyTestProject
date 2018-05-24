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

public class Practice11PieChartView extends View {

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);//抗锯齿画笔
        paint.setColor(Color.WHITE);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//要api 21才可以
//            paint.setColor(Color.parseColor("#9C27B0"));
//            canvas.drawArc(200,100,800,700,0,9,true,paint);//绘制扇形
//            paint.setColor(Color.parseColor("#9E9E9E"));
//            canvas.drawArc(200,100,800,700,10,10,true,paint);//绘制扇形
//            paint.setColor(Color.parseColor("#009688"));
//            canvas.drawArc(200,100,800,700,21,54,true,paint);//绘制扇形
//            paint.setColor(Color.parseColor("#2196F3"));
//            canvas.drawArc(200,100,800,700,76,100,true,paint);//绘制扇形
//            paint.setColor(Color.parseColor("#FFC107"));
//            canvas.drawArc(200,100,800,700,314,45,true,paint);//绘制扇形
//
//
//            paint.setColor(Color.parseColor("#F44336"));
//            canvas.drawArc(180,80,780,680,177,135,true,paint);//绘制扇形
//        }

        // 先画 饼状图  半径 500
        paint.setColor(Color.RED);
        canvas.drawArc(150, 10, 650,510,-180, 120,true, paint);

        paint.setColor(Color.YELLOW);
        canvas.drawArc(170, 30, 670,530,-60, 60,true, paint);

        paint.setColor(Color.MAGENTA);
        canvas.drawArc(170, 32, 670,532,2, 6,true, paint);

        paint.setColor(Color.GRAY);
        canvas.drawArc(170, 34, 670,534,10, 5,true, paint);

        paint.setColor(Color.GREEN);
        canvas.drawArc(172, 35, 672,535,17, 60,true, paint);

        paint.setColor(Color.BLUE);
        canvas.drawArc(168, 34, 668,534,79, 100,true, paint);

        // 再画线
        paint.setColor(Color.LTGRAY);
        paint.setStrokeWidth(4);
        // Lollipop
        canvas.drawLine(120,30,240,30,paint);
        canvas.drawLine(240,30,260,50,paint);

        // Marshmallow
        canvas.drawLine(645,165,670,150,paint);
        canvas.drawLine(670,150,770,150,paint);

        // Froyo
        canvas.drawLine(670,285,770,285,paint);

        // Gingerbread
        canvas.drawLine(670,305,700,305,paint);
        canvas.drawLine(700,305,720,325,paint);
        canvas.drawLine(720,325,750,325,paint);

        // Ice Cream Sandwich
        canvas.drawLine(665,340,700,340,paint);
        canvas.drawLine(700,340,720,365,paint);
        canvas.drawLine(720,365,750,365,paint);

        // Jelly Bean
        canvas.drawLine(600,465,630,495,paint);
        canvas.drawLine(630,495,730,495,paint);

        // KitKat
        canvas.drawLine(120,495,240,495,paint);
        canvas.drawLine(240,495,260,475,paint);


        // 后画文字
        paint.setColor(Color.WHITE);
        paint.setTextSize(27);
        canvas.drawText("Lollipop",10,30,paint);
        canvas.drawText("Marshmallow",780,150,paint);
        canvas.drawText("Froyo",780,285,paint);
        canvas.drawText("Gingerbread",770,325,paint);
        canvas.drawText("Ice Cream Sandwich",770,365,paint);
        canvas.drawText("Jelly Bean",750,495,paint);
        canvas.drawText("KitKat",20,495,paint);

        paint.setTextSize(50);
        canvas.drawText("饼图",350,650,paint);
    }
}
