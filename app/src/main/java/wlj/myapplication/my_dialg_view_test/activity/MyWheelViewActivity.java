package wlj.myapplication.my_dialg_view_test.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import wlj.myapplication.my_dialg_view_test.my_dialog.MyWheelViewDialog;
import wlj.myapplication.my_dialg_view_test.util.DialogUtil;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/30.
 * 说明：滚轮控件使用
 * ================================================
 */

public class MyWheelViewActivity extends AppCompatActivity {

    private DialogUtil dialogUtil;
    public static int DATE=2;
    public static int TIME=1;
    public static int ALL=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialogUtil=new DialogUtil();
        if (getIntent().hasExtra("type")){
           switch (getIntent().getIntExtra("type",0)){
               case 2:
                   dialogUtil.getWheelDialog(this, MyWheelViewDialog.MyWheelDialogType.DATE, null);
                   break;
               case 1:
                   dialogUtil.getWheelDialog(this, MyWheelViewDialog.MyWheelDialogType.TIME, null);
                   break;
               case 0 :
                   dialogUtil.getWheelDialog(this, MyWheelViewDialog.MyWheelDialogType.ALL, null);
                   break;
           }
        }

    }
}
