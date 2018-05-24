package wlj.myapplication.practice_draw_view2.practice2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import wlj.myapplication.R;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/19.
 * 说明：通过设置画笔的着色器  绘制view的渐变  ComposeShader 混合着色器
 * +BitmapShader=paint.setShader(SweepGradient)
 * ================================================
 */

public class Practice05ComposeShaderView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Bitmap bitmap1;
    private final BitmapShader shader1;
    private final Bitmap bitmap2;
    private final BitmapShader shader2;

    public Practice05ComposeShaderView(Context context) {
        super(context);
    }

    public Practice05ComposeShaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice05ComposeShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        setLayerType(LAYER_TYPE_SOFTWARE, null); // 硬件加速下 ComposeShader 不能使用两个同类型的 Shader

        // 第一个 Shader：头像的 Bitmap
         bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
         shader1 = new BitmapShader(bitmap1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        //        Shader shader1 = new BitmapShader(bitmap1, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR);
        //        Shader shader1 = new BitmapShader(bitmap1, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);

        // 第二个 Shader：从上到下的线性渐变（由透明到黑色）
         bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.batman_logo);
         shader2 = new BitmapShader(bitmap2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        //        Shader shader2 = new BitmapShader(bitmap2, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR);
        //        Shader shader2 = new BitmapShader(bitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 用 Paint.setShader(shader) 设置一个 ComposeShader
        // Shader 1: BitmapShader 图片：R.drawable.batman
        // Shader 2: BitmapShader 图片：R.drawable.batman_logo


        // ComposeShader：结合两个 Shader
        //SRC_OVER两个 Shader 的叠加模式    DST_OU挖空效果    DST蒙版抠图效果
        //ComposeShader() 在硬件加速下是不支持两个相同类型的 Shader 的，所以这里也需要关闭硬件加速才能看到效果
        Shader shader = new ComposeShader(shader1, shader2, PorterDuff.Mode.DST_IN);
        paint.setShader(shader);

        canvas.drawCircle(500, 400, 300, paint);
    }
}
