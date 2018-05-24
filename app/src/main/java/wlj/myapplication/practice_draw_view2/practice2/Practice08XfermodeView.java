package wlj.myapplication.practice_draw_view2.practice2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import wlj.myapplication.R;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/19.
 * 说明：Xfermode 指的是你要绘制的内容和 Canvas 的目标位置的内容应该怎样结
 * 合计算出最终的颜色。但通俗地说，其实就是要你以绘制的内容作为源图像，以 View 中
 * 已有的内容作为目标图像，选取一个  PorterDuff.Mode 作为绘制内容的颜色处理方案
 * ================================================
 */


public class Practice08XfermodeView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap1;
    Bitmap bitmap2;

    public Practice08XfermodeView(Context context) {
        super(context);
    }

    public Practice08XfermodeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice08XfermodeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.batman_logo);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 paint.setXfermode() 设置不同的结合绘制效果
        // 别忘了用 canvas.saveLayer() 开启 off-screen buffer 离屏缓冲

        int saved = canvas.saveLayer(null, null, Canvas.ALL_SAVE_FLAG);//开启 离屏缓冲


        Xfermode xfermode1 = new PorterDuffXfermode(PorterDuff.Mode.SRC);
        canvas.drawBitmap(bitmap1, 0, 0, paint);
        paint.setXfermode(xfermode1);// 设置 Xfermode
        // 第一个：PorterDuff.Mode.SRC
        canvas.drawBitmap(bitmap2, 0, 0, paint);
        paint.setXfermode(null);// 用完及时清除 Xfermode


        Xfermode xfermode2 = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        canvas.drawBitmap(bitmap1, bitmap1.getWidth() + 100, 0, paint);
        paint.setXfermode(xfermode2);// 设置 Xfermode
        // 第二个：PorterDuff.Mode.DST_IN
        canvas.drawBitmap(bitmap2, bitmap1.getWidth() + 100, 0, paint);
        paint.setXfermode(null);// 用完及时清除 Xfermode


        Xfermode xfermode3 = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        canvas.drawBitmap(bitmap1, 0, bitmap1.getHeight() + 20, paint);
        paint.setXfermode(xfermode3);// 设置 Xfermode
        // 第三个：PorterDuff.Mode.DST_OUT
        canvas.drawBitmap(bitmap2, 0, bitmap1.getHeight() + 20, paint);
        paint.setXfermode(null);// 用完及时清除 Xfermode


        // 用完之后使用 canvas.restore() 恢复 off-screen buffer  关闭离屏缓冲
        canvas.restoreToCount(saved);

    }
}
