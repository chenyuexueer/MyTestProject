package wlj.myapplication.my_dialg_view_test.my_dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

import wlj.myapplication.R;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/29.
 * 说明：
 * ================================================
 */
public class MyLoadViewDialog extends Dialog {

	public MyLoadViewDialog(Context context) {
		super(context);
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去除屏幕title
		setContentView(R.layout.my_dialog_load_view);
		getWindow().setBackgroundDrawableResource(android.R.color.transparent);
	}
}
