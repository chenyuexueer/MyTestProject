package wlj.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import wlj.myapplication.lifecycle_livedata_mvvm.view.A_UserActivity;
import wlj.myapplication.retrofit_lifecyecle_livedata_mvvm.view.B_UserActivity;


/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/18.
 * 说明：
 * ================================================
 */

public class MyUserActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_a: {
                startActivity(new Intent(this, A_UserActivity.class));
                break;
            }
            case R.id.btn_b: {
                startActivity(new Intent(this, B_UserActivity.class));
                break;
            }
            case R.id.btn_c: {
//                startActivity(new Intent(this, .class));
                break;
            }
            case R.id.btn_d: {
//                startActivity(new Intent(this, .class));
                break;
            }
            case R.id.btn_e: {
//                startActivity(new Intent(this, .class));
                break;
            }
            case R.id.btn_f: {
//                startActivity(new Intent(this, .class));
                break;
            }
            case R.id.btn_g: {
//                startActivity(new Intent(this, .class));
                break;
            }
            case R.id.btn_h: {
//                startActivity(new Intent(this, .class));
                break;
            }
            case R.id.btn_i: {
//                startActivity(new Intent(this, .class));
                break;
            }

        }
    }
}
