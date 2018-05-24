package wlj.myapplication.practice_draw_view2.practice2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/19.
 * 说明：通过设置画笔的着色器 绘制view的渐变  paint.setShader(LinearGradient)
 * ================================================
 */

public class Practice01LinearGradientView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice01LinearGradientView(Context context) {
        super(context);
    }

    public Practice01LinearGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice01LinearGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        // 用 Paint.setShader(shader) 设置一个 LinearGradient
        // LinearGradient 的参数：坐标：(100, 100) 到 (500, 500) ；颜色：#E91E63 到 #2196F3
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //画笔颜色设置        直接设置颜色
//        paint.setColor(Color.parseColor("#009688"));
//        canvas.drawRect(30, 30, 230, 180, paint);
//
//        paint.setColor(Color.parseColor("#FF9800"));
//        canvas.drawLine(300, 30, 450, 180, paint);
//
//        paint.setColor(Color.parseColor("#E91E63"));
//        canvas.drawText("HenCoder", 500, 130, paint);
//
//        //与setColor()差不多    参数RGB模式
//        paint.setARGB(100, 255, 0, 0);
//        canvas.drawRect(0, 0, 200, 200, paint);
//        paint.setARGB(100, 0, 0, 0);
//        canvas.drawLine(0, 0, 200, 200, paint);

        //paint.setARGB(100, 255, 0, 0); 除了直接设置颜色， Paint 还可以使用 Shader着色器
        //在 Android 的绘制里使用 Shader ，并不直接用 Shader 这个类，而是用它的几个子类
        //CLAMP, MIRROR 和  REPEAT 夹子模式 镜像模式和重复模式
        //注意：在设置了 Shader 的情况下， Paint.setColor/ARGB() 所设置的颜色就不再起作用

//        x0 y0 x1 y1：渐变的两个端点的位置
//        color0 color1 是端点的颜色
//        tile：端点范围之外的着色规则，类型是 TileMode。TileMode 一共有 3 个值可
        // 选： CLAMP, MIRROR 和  REPEAT。CLAMP （夹子模式）
        // 会在端点之外延续端点处的颜色；MIRROR 是镜像模式；REPEAT 是重复模式。具体的看一下例子就明白。

        paint.setShader(new LinearGradient(100,100,500,500,  Color.parseColor("#E91E63"),//解析颜色
                Color.parseColor("#2196F3"), Shader.TileMode.CLAMP));//夹子模式
//        paint.setShader(new LinearGradient(100,100,500,500,  Color.parseColor("#E91E63"),//解析颜色
//                Color.parseColor("#2196F3"), Shader.TileMode.MIRROR));//镜像模式
//        paint.setShader(new LinearGradient(100,100,500,500,  Color.parseColor("#E91E63"),//解析颜色
//                Color.parseColor("#2196F3"), Shader.TileMode.REPEAT));//重复模式
        canvas.drawCircle(300, 300, 200, paint);
    }
}
