package wlj.myapplication.my_dialg_view_test.my_dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;

import wlj.myapplication.R;
import wlj.myapplication.my_dialg_view_test.view.MyJumpWordLoadView;
import wlj.myapplication.my_dialg_view_test.view.view_options.MyJumpWordLoadViewOption;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/30.
 * 说明：
 * ================================================
 */

public class MyJumpWordLoadViewDialog extends Dialog {

    private MyJumpWordLoadView load3;
    private int showType = MyJumpWordLoadViewOption.SHOW_TYPE_ALL;
    private MyJumpWordLoadViewOption o;

    public MyJumpWordLoadViewDialog(Context context) {
        super(context);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);// 去除屏幕title
        setContentView(R.layout.my_dialog_jump_word_load_view);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        load3 = (MyJumpWordLoadView) findViewById(R.id.load3);
        if(o==null){
            MyJumpWordLoadViewOption.Builder b = new MyJumpWordLoadViewOption.Builder();
            b.setValues("孤月雪狼▼◆★")
                    .setTextSize(100)
                    .setColors(Color.RED,Color.BLUE)
                    .setShadowColors(Color.RED,Color.BLUE)
                    .setShowType(showType)
                    .setTypefaces(Typeface.DEFAULT,Typeface.SERIF,Typeface.SANS_SERIF);
            o = new MyJumpWordLoadViewOption(b);
        }
        load3.setOption(o);
    }

    public MyJumpWordLoadViewDialog(Context context, int showType) {
        super(context);
        this.showType = showType;
    }

    public MyJumpWordLoadViewDialog(Context context, MyJumpWordLoadViewOption o) {
        super(context);
        this.o = o;
    }
}
