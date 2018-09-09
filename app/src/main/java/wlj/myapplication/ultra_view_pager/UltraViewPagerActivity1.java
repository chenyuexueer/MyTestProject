package wlj.myapplication.ultra_view_pager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;

import com.tmall.ultraviewpager.UltraViewPager;

import wlj.myapplication.R;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/9/3.
 * 说明：
 * ================================================
 */
public class UltraViewPagerActivity1 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ultra_view_pager);

        UltraViewPager ultraViewPager = (UltraViewPager)findViewById(R.id.ultra_viewpager);
        //设置滚动方向
        ultraViewPager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);

        PagerAdapter adapter = new UltraPagerAdapter();
        //给ultraViewPager设置adapter
        ultraViewPager.setAdapter(adapter);
    }
}
