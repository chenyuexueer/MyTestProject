package wlj.myapplication.my_dialg_view_test.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/30.
 * 说明：波浪样式
 * 
 * 支付宝咻一咻的View实现版   使用新的BitmapShader绘制圆形图片
 * ================================================
 */

public class MyXiuXiuImageView extends android.support.v7.widget.AppCompatImageView {
    private Paint paint;
    private Bitmap bitmap;
    private Bitmap img;
    private int color = 0;
    private int width, height;
    private ArrayList<Integer> radius;
    private int maxRadiu;
    private Integer step = 0;
    private float imgRatio = 0.3f;
    private Shader mRadialGradient = null;
    private int red, green, blue;
    private MyXiuXiuImageViewOnClickListener listener;
    private XiuXiuType xiuXiuType = XiuXiuType.OUT;
    private WaveType waveType = WaveType.SHADE;
    private int stepRatio = 5;
    private Matrix matrix;
    int bitmapRadiu = 0;
    private Paint bitmapPaint;

    private void init() {
        bitmapRadiu = (int) (maxRadiu * imgRatio);
        if (bitmapRadiu > Math.min(width, height) / 2) {
            bitmapRadiu = Math.min(width, height) / 2;
        }
        img = ((BitmapDrawable) getDrawable()).getBitmap();
        //使用Xfermode绘制圆形图片
        //		bitmap = getCroppedRoundBitmap(img, bitmapRadiu);
        //使用BitmapShader绘制圆形图片
        getCroppedRoundBitmap2(img, bitmapRadiu);
        if (color == 0)
            color = img.getPixel(img.getWidth() / 2, img.getHeight() / 2);
        if (step == 0)
            step = (maxRadiu - bitmapRadiu) / 100 * stepRatio;
        red = Color.red(color);
        green = Color.green(color);
        blue = Color.blue(color);
        onChange();
    }

    private void onChange() {
        Iterator<Integer> it = radius.iterator();
        switch (xiuXiuType) {
            case IN:
                while (it.hasNext()) {
                    if (it.next() >= maxRadiu * (1 - imgRatio))
                        it.remove();
                }
                break;
            case OUT:
                while (it.hasNext()) {
                    if (it.next() >= maxRadiu)
                        it.remove();
                }
                break;
        }
        for (int i = 0; i < radius.size(); i++) {
            radius.set(i, radius.get(i) + step);
        }
    }

    private void setColor(int r) {
        int alpha = 0;
        switch (xiuXiuType) {
            case IN:
                alpha = (int) ((maxRadiu * (1 - imgRatio) - r) * 1.0 / maxRadiu * 255);
                break;
            case OUT:
                alpha = (int) ((maxRadiu - r) * 1.0 / maxRadiu * 255);
                break;
        }
        if (alpha > 255)
            alpha = 255;
        if (alpha < 0)
            alpha = 0;
        int edgeColor = Color.argb(alpha, red, green, blue);
        mRadialGradient = new RadialGradient(width / 2, height / 2, r + maxRadiu * imgRatio, Color.TRANSPARENT,
                edgeColor, Shader.TileMode.REPEAT);
        paint.setShader(mRadialGradient);
    }

    private void setColor2(int r) {
        int alpha = 0;
        switch (xiuXiuType) {
            case IN:
                alpha = (int) ((maxRadiu * (1 - imgRatio) - r) * 1.0 / maxRadiu * 255);
                break;
            case OUT:
                alpha = (int) ((maxRadiu - r) * 1.0 / maxRadiu * 255);
                break;
        }
        if (alpha > 255)
            alpha = 255;
        if (alpha < 0)
            alpha = 0;
        paint.setAlpha(alpha);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        switch (waveType) {
            case ALWAYS:
                paint.setColor(color);
                for (Integer i : radius) {
                    setColor2(i);
                    canvas.drawCircle(width / 2, height / 2, i + (maxRadiu * imgRatio), paint);
                }
                paint.setAlpha(255);
                break;
            case SHADE:
                for (Integer i : radius) {
                    setColor(i);
                    canvas.drawCircle(width / 2, height / 2, i + (maxRadiu * imgRatio), paint);
                }
                break;
        }
        //使用Xfermode绘制圆形图片
        //		canvas.drawBitmap(bitmap, width / 2 - bitmap.getWidth() / 2, height / 2 - bitmap.getHeight() / 2, paint);
        //使用BitmapShader绘制圆形图片
        canvas.save();
        canvas.translate(width / 2-bitmapRadiu, height/2-bitmapRadiu);
        canvas.drawCircle(bitmapRadiu, bitmapRadiu, bitmapRadiu, bitmapPaint);
        canvas.restore();
        if (radius.size() > 0) {
            onChange();
            invalidate();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                if(isClick(event.getX(),event.getY())){
                    radius.add(0);
                    invalidate();
                    if (listener != null) {
                        listener.onXiu(this);
                    }
                    return true;
                }
                break;
            default:
                break;
        }
        //		return super.onTouchEvent(event);
        return true;
    }

    private boolean isClick(float x,float y){
        double x1 = Math.abs(x-width/2);
        double y1 = Math.abs(y-height/2);
        double r = Math.abs(Math.sqrt(x1*x1+y1*y1));
        if(r<bitmapRadiu)
            return true;
        return false;
    }

    public MyXiuXiuImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        bitmapPaint = new Paint();
        bitmapPaint.setAntiAlias(true);
        radius = new ArrayList<Integer>();
    }

    public MyXiuXiuImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyXiuXiuImageView(Context context) {
        this(context, null);
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        width = getWidth();
        height = getHeight();
        switch (this.xiuXiuType) {
            case IN:
                maxRadiu = Math.min(height, width) / 2;
                break;
            case OUT:
                maxRadiu = Math.max(height, width) / 2;
                break;
        }
        init();
        super.onWindowFocusChanged(hasWindowFocus);
    }

    /**
     * 获取裁剪后的圆形图片
     *
     * @param radius
     *            半径
     */
    public Bitmap getCroppedRoundBitmap(Bitmap bmp, int radius) {
        Bitmap scaledSrcBmp;
        int diameter = radius * 2;

        // 为了防止宽高不相等，造成圆形图片变形，因此截取长方形中处于中间位置最大的正方形图片
        int bmpWidth = bmp.getWidth();
        int bmpHeight = bmp.getHeight();
        int squareWidth = 0, squareHeight = 0;
        int x = 0, y = 0;
        Bitmap squareBitmap;
        if (bmpHeight > bmpWidth) {// 高大于宽
            squareWidth = squareHeight = bmpWidth;
            x = 0;
            y = (bmpHeight - bmpWidth) / 2;
            // 截取正方形图片
            squareBitmap = Bitmap.createBitmap(bmp, x, y, squareWidth, squareHeight);
        } else if (bmpHeight < bmpWidth) {// 宽大于高
            squareWidth = squareHeight = bmpHeight;
            x = (bmpWidth - bmpHeight) / 2;
            y = 0;
            squareBitmap = Bitmap.createBitmap(bmp, x, y, squareWidth, squareHeight);
        } else {
            squareBitmap = bmp;
        }

        if (squareBitmap.getWidth() != diameter || squareBitmap.getHeight() != diameter) {
            scaledSrcBmp = Bitmap.createScaledBitmap(squareBitmap, diameter, diameter, true);

        } else {
            scaledSrcBmp = squareBitmap;
        }
        Bitmap output = Bitmap.createBitmap(scaledSrcBmp.getWidth(), scaledSrcBmp.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, scaledSrcBmp.getWidth(), scaledSrcBmp.getHeight());

        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawCircle(scaledSrcBmp.getWidth() / 2, scaledSrcBmp.getHeight() / 2, scaledSrcBmp.getWidth() / 2,
                paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(scaledSrcBmp, rect, rect, paint);
        bmp = null;
        squareBitmap = null;
        scaledSrcBmp = null;
        return output;
    }

    /**
     * 使用渲染来绘制圆形图片
     *
     * @param bmp
     * @param radius
     * @return
     */
    public void getCroppedRoundBitmap2(Bitmap bmp, int radius) {
        // 将bmp作为着色器，就是在指定区域内绘制bmp
        Shader mBitmapShader = new BitmapShader(bmp, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        float scale = 1.0f;
        // 如果图片的宽或者高与view的宽高不匹配，计算出需要缩放的比例；缩放后的图片的宽高，一定要大于我们view的宽高；所以我们这里取大值；
        scale = Math.max(radius * 2.0f / bmp.getWidth(), radius * 2.0f / bmp.getHeight());
        if(matrix==null){
            matrix = new Matrix();
        }
        // shader的变换矩阵，我们这里主要用于放大或者缩小
        matrix.setScale(scale, scale);
        // 设置变换矩阵
        mBitmapShader.setLocalMatrix(matrix);
        // 设置shader
        bitmapPaint.setShader(mBitmapShader);
    }

    public interface MyXiuXiuImageViewOnClickListener {
        public void onXiu(View v);
    }

    public MyXiuXiuImageViewOnClickListener getListener() {
        return listener;
    }

    public void setListener(MyXiuXiuImageViewOnClickListener listener) {
        this.listener = listener;
    }

    public int getColor() {
        return color;
    }

    public Integer getStep() {
        return stepRatio;
    }

    /**
     * 最大99 最小1
     *
     * @param step
     */
    public void setStep(int step) {
        stepRatio = step;
    }

    public float getImgRatio() {
        return imgRatio;
    }

    public void setImgRatio(float imgRatio) {
        this.imgRatio = imgRatio;
    }

    public XiuXiuType getXiuXiuType() {
        return xiuXiuType;
    }

    /**
     * 设置波浪范围
     *
     * @param xiuXiuType
     */
    public void setXiuXiuType(XiuXiuType xiuXiuType) {
        this.xiuXiuType = xiuXiuType;
        switch (this.xiuXiuType) {
            case IN:
                maxRadiu = Math.min(height, width) / 2;
                break;
            case OUT:
                maxRadiu = Math.max(height, width) / 2;
                break;
        }
    }

    public WaveType getWaveType() {
        return waveType;
    }

    /**
     * 设置波浪样式
     *
     * @param waveType
     */
    public void setWaveType(WaveType waveType) {
        this.waveType = waveType;
    }

    public enum WaveType {
        SHADE, ALWAYS
    }

    public enum XiuXiuType {
        IN, OUT
    }
}