package wlj.myapplication.practice_draw_view2.practice2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import wlj.myapplication.R;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/19.
 * 说明：通过设置画笔的颜色，改变view的图像 setColorFilter(ColorFilter colorFilter)       LightingColorFilter
 * ================================================
 */


public class Practice06LightingColorFilterView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;

    public Practice06LightingColorFilterView(Context context) {
        super(context);
    }

    public Practice06LightingColorFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice06LightingColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //mul 用来和目标像素相乘，add 用来和目标像素相加
        //如：
//        R' = R * mul.R / 0xff + add.R
//        G' = G * mul.G / 0xff + add.G
//        B' = B * mul.B / 0xff + add.B

//        ColorFilter colorFilter1 = new LightingColorFilter(0x00ffff, 0x000000);
        ColorFilter colorFilter2 = new LightingColorFilter(0xffffff, 0x003000);

        // 使用 Paint.setColorFilter() 来设置 LightingColorFilter
        paint.setColorFilter(new LightingColorFilter(0x00ffff, 0x000000));
        // 第一个 LightingColorFilter：去掉红色部分
        canvas.drawBitmap(bitmap, 0, 0, paint);

        // 第二个 LightingColorFilter：增强绿色部分
        paint.setColorFilter(colorFilter2);
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 100, 0, paint);

    }
}
