package wlj.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import wlj.myapplication.mvp_demo.test.view.TestMVPActviity;
import wlj.myapplication.practice_draw_view.PracticeDrawActivity;
import wlj.myapplication.practice_draw_view2.PracticeDrawActivity2;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_application: {
                startActivity(new Intent(this, MyUserActivity.class));
                break;
            }
            case R.id.btn_implementation: {
                //                startActivity(new Intent(this, ImplementationActivity.class));
                break;
            }
            case R.id.btn_practice_draw: {
                startActivity(new Intent(this, PracticeDrawActivity.class));
                break;
            }
            case R.id.btn_practice_draw2: {
                startActivity(new Intent(this, PracticeDrawActivity2.class));
                break;
            }
            case R.id.mvp: {
                startActivity(new Intent(this, TestMVPActviity.class));
                break;
            }
        }
    }
}