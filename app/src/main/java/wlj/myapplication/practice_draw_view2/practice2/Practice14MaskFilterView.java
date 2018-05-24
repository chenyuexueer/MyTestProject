package wlj.myapplication.practice_draw_view2.practice2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import wlj.myapplication.R;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/19.
 * 说明：setMaskFilter(MaskFilter maskfilter)
 *
 * 方法 setShadowLayer() 是设置的在绘制层下方的附加效果；
 * 而这个  MaskFilter 和它相反，设置的是在绘制层上方的附加效果
 *
 * 到现在已经有两个 setXxxFilter(filter) 了。前面有一个 setColorFilter(filter) ，
 * 是对每个像素的颜色进行过滤；而这里的 setMaskFilter(filter) 则是基于整个画面来进行过滤
 *
 * BlurMaskFilter  模糊效果的 MaskFilter
 * NORMAL: 内外都模糊绘制
 * SOLID: 内部正常绘制，外部模糊
 * INNER: 内部模糊，外部不绘制
 * OUTER: 内部不绘制，外部模糊
 *
 * 浮雕效果的 MaskFilter
 * direction 是一个 3 个元素的数组，指定了光源的方向；
 * ambient 是环境光的强度，数值范围是 0 到 1；
 * specular 是炫光的系数；
 * blurRadius 是应用光线的范围
 * ================================================
 */

public class Practice14MaskFilterView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;

    MaskFilter maskFilter1 = new BlurMaskFilter(50, BlurMaskFilter.Blur.NORMAL);//内外都模糊绘制
    MaskFilter maskFilter2 = new BlurMaskFilter(50, BlurMaskFilter.Blur.INNER);//内部正常绘制，外部模糊
    MaskFilter maskFilter3 = new BlurMaskFilter(50, BlurMaskFilter.Blur.OUTER);//内部模糊，外部不绘制
    MaskFilter maskFilter4 = new BlurMaskFilter(50, BlurMaskFilter.Blur.SOLID);//内部不绘制，外部模糊


    public Practice14MaskFilterView(Context context) {
        super(context);
    }

    public Practice14MaskFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice14MaskFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.what_the_fuck);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 用 Paint.setMaskFilter 来设置不同的 BlurMaskFilter

        // 第一个：NORMAL
        paint.setMaskFilter(maskFilter1);
        canvas.drawBitmap(bitmap, 100, 50, paint);

        // 第二个：INNER
        paint.setMaskFilter(maskFilter2);
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 200, 50, paint);

        // 第三个：OUTER
        paint.setMaskFilter(maskFilter3);
        canvas.drawBitmap(bitmap, 100, bitmap.getHeight() + 100, paint);

        // 第四个：SOLID
        paint.setMaskFilter(maskFilter4);
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 200, bitmap.getHeight() + 100, paint);
    }
}
