package wlj.myapplication.practice_draw_view2.practice2;

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
 * 说明： setShadowLayer(float radius, float dx, float dy, int shadowColor)
 * radius 是阴影的模糊范围； dx dy 是阴影的偏移量； shadowColor 是阴影的颜色
 * 如果要清除阴影层，使用 clearShadowLayer() 。
 *
 * 注意：

 在硬件加速开启的情况下， setShadowLayer() 只支持文字的绘制，
 文字之外的绘制必须关闭硬件加速才能正常绘制阴影。

 如果 shadowColor 是半透明的，阴影的透明度就使用 shadowColor 自己的透明度；
 而如果 shadowColor 是不透明的，阴影的透明度就使用 paint 的透明度。
 * ================================================
 */

public class Practice13ShadowLayerView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice13ShadowLayerView(Context context) {
        super(context);
    }

    public Practice13ShadowLayerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice13ShadowLayerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 使用 Paint.setShadowLayer() 设置阴影
        paint.setShadowLayer(10, 5, 5, Color.RED);

        paint.setTextSize(120);
        canvas.drawText("Hello HenCoder", 50, 200, paint);
    }
}
