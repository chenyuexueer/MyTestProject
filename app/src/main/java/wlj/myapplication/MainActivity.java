package wlj.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import wlj.myapplication.mvp_demo.test.view.TestMVPActviity;
import wlj.myapplication.my_dialg_view_test.MyViewTestActivity;
import wlj.myapplication.my_draw_view.MyDrawActivity;
import wlj.myapplication.practice_draw_view.PracticeDrawActivity;
import wlj.myapplication.practice_draw_view2.PracticeDrawActivity2;
import wlj.myapplication.room_test.MyRoomTestActivity;
import wlj.myapplication.vlayout_demo.VLayoutActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_application:
                startActivity(new Intent(this, MyUserActivity.class));
                break;

            case R.id.btn_implementation:
                //                startActivity(new Intent(this, ImplementationActivity.class));
                break;

            case R.id.btn_practice_draw:
                startActivity(new Intent(this, PracticeDrawActivity.class));
                break;

            case R.id.btn_practice_draw2:
                startActivity(new Intent(this, PracticeDrawActivity2.class));
                break;
            case R.id.my_draw_view:
                startActivity(new Intent(this, MyDrawActivity.class));
                break;

            case R.id.mvp:
                    startActivity(new Intent(this, TestMVPActviity.class));
                    break;

            case R.id.vlayout:
                startActivity(new Intent(this, VLayoutActivity.class));
                break;
            case R.id.my_dialog_view_test:
                startActivity(new Intent(this, MyViewTestActivity.class));
                break;
            case R.id.room:
                startActivity(new Intent(this, MyRoomTestActivity.class));
                break;
        }
    }
}