package wlj.myapplication.my_dialg_view_test;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import wlj.myapplication.R;
import wlj.myapplication.my_dialg_view_test.activity.CalendarAllSlideActivity;
import wlj.myapplication.my_dialg_view_test.activity.MyChooseIndicatorActivity;
import wlj.myapplication.my_dialg_view_test.activity.MyLoadViewActivity;
import wlj.myapplication.my_dialg_view_test.activity.MyPieViewActivity;
import wlj.myapplication.my_dialg_view_test.activity.MyProgressButtonViewActivity;
import wlj.myapplication.my_dialg_view_test.activity.MyProgressViewActivity;
import wlj.myapplication.my_dialg_view_test.activity.MyRaderViewActivity;
import wlj.myapplication.my_dialg_view_test.activity.MySlideButtonViewActivity;
import wlj.myapplication.my_dialg_view_test.activity.MyThermometerViewActivity;
import wlj.myapplication.my_dialg_view_test.adapter.MyViewTestAdapter;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/29.
 * 说明：recyclerview使用 点击事件  floactionbutton使用 点击事件
 * ================================================
 */

public class MyViewTestActivity extends AppCompatActivity implements View.OnClickListener, MyViewTestAdapter.OnItemClickListener  {

    private static final String GithubPath = " https://github.com/chenyuexueer/MyTestProject";
    private String[] names = {
            "日历选择-日期没有限制&全向拖动", "日历选择-日期有限制&单向", "选项卡切换-三角形", "选项卡切换-线形", "时间选择",
            "时间选择（占位用的）", "加载等待动画", "饼图", "进度图", "雷达图",
            "圆形图片", "滑动按钮", "温度计", "进度条按钮", "页面下方小点",
            "tab小点", "日期滚轮", "时间滚轮", "全套滚轮", "tab条形",
            "倒计时View", "商品列表", "支付宝咻一咻", "系统自带的抽屉用法演示", "现在较流行的抽屉样式",
            "带涟漪的Layout", "渐变的View", "通讯录", "添加快捷方式", "删除快捷方式",
            "水滴加载动画", "跑马灯", "折线图", "刮刮卡", "转动的心（未完成）",
            "文字跳跳加载动画1","文字跳跳加载动画2","会动的返回键(模仿谷歌抽屉箭头)"};
    private RecyclerView recyclerView;
    private MyViewTestAdapter adapter;
    private FloatingActionButton fab;

    //官方的   剪切板
    private ClipboardManager myClipboard;
    //官方的   剪切板的内容
    private ClipData myClip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view_test);

        myClipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);//官方的

        recyclerView = (RecyclerView) findViewById(R.id.my_view_test_rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter = new MyViewTestAdapter(names, this, this));

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);
    }

    //控件点击事件的处理
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab:
                //snackbar的使用（加强版的toast）
                Snackbar.make(view, GithubPath, Snackbar.LENGTH_LONG)
                        .setAction("复制", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //给剪切板设置内容
                                myClip = ClipData.newPlainText("text", GithubPath);
                                myClipboard.setPrimaryClip(myClip);
                            }
                        }).show();
                break;
        }
    }

    //recyclerview的item点击事件的处理
    @Override
    public void onItemClick(String data, int position) {
        Intent intent=null;
        switch (position) {
            case 0:
                toast(data);
                intent=new Intent(this, CalendarAllSlideActivity.class);
                intent.putExtra("type",true);//全向拖拽
                startActivity(intent);
                break;
            case 1:
                toast(data);
                intent=new Intent(this, CalendarAllSlideActivity.class);
                intent.putExtra("type",false);//单（横）向拖拽
                startActivity(intent);
                break;
            case 2:
                toast(data);
                intent=new Intent(this, MyChooseIndicatorActivity.class);
                intent.putExtra("type", true);//三角形选项卡指示器
                startActivity(intent);
                break;
            case 3:
                toast(data);
                intent=new Intent(this, MyChooseIndicatorActivity.class);
                intent.putExtra("type", false);//线性选项卡指示器
                startActivity(intent);
                break;
            case 4:
                toast(data);//时钟选择器
//                intent=new Intent(this, CalendarAllSlideActivity.class);
//                startActivity(intent);
                break;
            case 5://时钟选择器
                toast(data);
//                intent=new Intent(this, CalendarAllSlideActivity.class);
//                startActivity(intent);
                break;
            case 6:
                toast(data);
                intent=new Intent(this, MyLoadViewActivity.class);
                startActivity(intent);//加载等待动画
                break;
            case 7:
                toast(data);
                intent=new Intent(this, MyPieViewActivity.class);
                startActivity(intent);//收入支出管理  饼图
                break;
            case 8:
                toast(data);
                intent=new Intent(this, MyProgressViewActivity.class);
                startActivity(intent);//加载进度view
                break;
            case 9:
                toast(data);
                intent=new Intent(this, MyRaderViewActivity.class);
                startActivity(intent);//雷达图
                break;
            case 10:
                toast(data);
//                intent=new Intent(this, CalendarAllSlideActivity.class);
//                startActivity(intent);//圆形图
                break;
            case 11:
                toast(data);
                intent=new Intent(this, MySlideButtonViewActivity.class);
                startActivity(intent);//滚动开关按钮
                break;
            case 12:
                toast(data);
                intent=new Intent(this, MyThermometerViewActivity.class);
                startActivity(intent);//温度计视图
                break;
            case 13:
                toast(data);
                intent=new Intent(this, MyProgressButtonViewActivity.class);
                startActivity(intent);//进度条按钮
                break;
            case 14:
                toast(data);
//                intent=new Intent(this, CalendarAllSlideActivity.class);
//                startActivity(intent);//页面下方点指示器
                break;
            case 15:
                toast(data);
//                intent=new Intent(this, CalendarAllSlideActivity.class);
//                startActivity(intent);
                break;
            case 16:
                toast(data);
                intent=new Intent(this, CalendarAllSlideActivity.class);
                startActivity(intent);//日期滚轮
                break;
            case 17:
                toast(data);
                intent=new Intent(this, CalendarAllSlideActivity.class);
                startActivity(intent);//时间滚轮
                break;
            case 18:
                toast(data);
                intent=new Intent(this, CalendarAllSlideActivity.class);
                startActivity(intent);
                break;
            case 19:
                toast(data);
                intent=new Intent(this, CalendarAllSlideActivity.class);
                startActivity(intent);
                break;
            case 20:
                toast(data);
                intent=new Intent(this, CalendarAllSlideActivity.class);
                startActivity(intent);
                break;
            case 21:
                toast(data);
                intent=new Intent(this, CalendarAllSlideActivity.class);
                startActivity(intent);
                break;
            case 22:
                toast(data);
                intent=new Intent(this, CalendarAllSlideActivity.class);
                startActivity(intent);
                break;
            case 23:
                toast(data);
                intent=new Intent(this, CalendarAllSlideActivity.class);
                startActivity(intent);
                break;
            case 24:
                toast(data);
                intent=new Intent(this, CalendarAllSlideActivity.class);
                startActivity(intent);
                break;
            case 25:
                toast(data);
                intent=new Intent(this, CalendarAllSlideActivity.class);
                startActivity(intent);
                break;
            case 26:
                toast(data);
                intent=new Intent(this, CalendarAllSlideActivity.class);
                startActivity(intent);
                break;
            case 27:
                toast(data);
                intent=new Intent(this, CalendarAllSlideActivity.class);
                startActivity(intent);
                break;
            case 28:
                toast(data);
                intent=new Intent(this, CalendarAllSlideActivity.class);
                startActivity(intent);
                break;
            case 29:
                toast(data);
                intent=new Intent(this, CalendarAllSlideActivity.class);
                startActivity(intent);
                break;
            case 30:
                toast(data);
                intent=new Intent(this, CalendarAllSlideActivity.class);
                startActivity(intent);
                break;
            case 31:
                toast(data);
                intent=new Intent(this, CalendarAllSlideActivity.class);
                startActivity(intent);
                break;
            case 32:
                toast(data);
                intent=new Intent(this, CalendarAllSlideActivity.class);
                startActivity(intent);
                break;
            case 33:
                toast(data);
                intent=new Intent(this, CalendarAllSlideActivity.class);
                startActivity(intent);
                break;
            case 34:
                toast(data);
                intent=new Intent(this, CalendarAllSlideActivity.class);
                startActivity(intent);
                break;
            case 35:
                toast(data);
                intent=new Intent(this, CalendarAllSlideActivity.class);
                startActivity(intent);
                break;
            case 36:
                toast(data);
                intent=new Intent(this, CalendarAllSlideActivity.class);
                startActivity(intent);
                break;
            case 37:
                toast(data);
                intent=new Intent(this, CalendarAllSlideActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void toast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
