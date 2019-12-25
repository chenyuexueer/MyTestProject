package wlj.myapplication.zxing;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;


/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/10/17.
 * 说明：zxing测试
 * ================================================
 */
public class ZXingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //只有当系统版本大于等于6.0时才需要
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //判断该应用是否有写SD卡权限，如果没有再去申请
            if (ContextCompat.checkSelfPermission(ZXingActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(ZXingActivity.this, new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE}, 123);
            }
        }

//        Intent intent = new Intent(ZXingActivity.this, CaptureActivity.class);
//        startActivityForResult(intent,0);
    }


    // 调用requestPermissions会弹出对话框，用户做出选择之后的回调
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //requestCode 是调用requestPermissions传入的123，当然你可以设置成其他值或者某个静态变量
        if (requestCode == 123) {
            if (grantResults.length >= 1) {
                //因为我们只申请了一个权限，所以这个数组只有一个
                int writeResult = grantResults[0];
                int readResult = grantResults[1];
                //判断是否授权，也就是用户点击的是拒绝还是接受
                boolean writeGranted = writeResult == PackageManager.PERMISSION_GRANTED;
                boolean readGranted = readResult == PackageManager.PERMISSION_GRANTED;
                if (writeGranted) {
                    //用户点击了接受，可以进行相应处理
                    Toast.makeText(ZXingActivity.this, "用户点击了接受",Toast.LENGTH_SHORT);
                } else {
                    //用户点击了拒绝，可以进行相应处理
                    Toast.makeText(ZXingActivity.this, "用户点击了拒绝",Toast.LENGTH_SHORT);
                }
                if (readGranted) {
                    //用户点击了接受，可以进行相应处理
                    //                    U.Toast(CommodityDetActivity.this,"");
                } else {
                    //用户点击了拒绝，可以进行相应处理
                    Toast.makeText(ZXingActivity.this, "用户点击了拒绝",Toast.LENGTH_SHORT);
                }
            }
        }
    }
}
