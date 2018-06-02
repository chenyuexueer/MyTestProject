package wlj.myapplication.my_dialg_view_test.activity;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import wlj.myapplication.R;
import wlj.myapplication.my_dialg_view_test.view.MyScratchCardView;
import wlj.myapplication.my_dialg_view_test.view.view_options.MyScratchCardViewOption;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/30.
 * 说明：刮刮卡
 * ================================================
 */

public class MyScratchCardViewActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, CompoundButton.OnCheckedChangeListener {




    //========================2222222222222====================
    private MyScratchCardView scratchCard;
    private TextView mulchText;
    private TextView valueText;
    private Button mulchBtn;
    private Button valueBtn;
    private SeekBar mulchTextSizeBar;
    private SeekBar valueTextSizeBar;
    private SeekBar touchWidthBar;
    private SeekBar autoCleanSizeBar;
    private SeekBar roundRadiusBar;
    private Button mulchTextSizeBarBtn;
    private Button valueTextSizeBarBtn;
    private Button touchWidthBarBtn;
    private Button autoCleanSizeBarBtn;
    private Button roundRadiusBarBtn;
    private Switch transparentBg;
    private Switch autoClean;
    private MyScratchCardViewOption.Builder builder;
    private Resources res;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getIntent().hasExtra("type")){
            switch (getIntent().getIntExtra("type",0)){
                case 0:
                    setContentView(R.layout.my_scratch_card_view1);
                    scratchCard = (MyScratchCardView) findViewById(R.id.scratchcard);

                    initBuilder1();
                    break;
                case 1:
                    setContentView(R.layout.my_scratch_card_view2);

                    res = getResources();
                    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
                    toolbar.setTitle("刮刮卡");
                    toolbar.setBackgroundColor(res.getColor(R.color.colorPrimary));
                    setSupportActionBar(toolbar);
                    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

                    scratchCard = (MyScratchCardView) findViewById(R.id.scratchcard);

                    mulchText = (TextView) findViewById(R.id.mulch_text);//表面覆盖 刮开涂层有奖
                    valueText = (TextView) findViewById(R.id.value_text);//刮开文字，恭喜你获得一等奖

                    mulchBtn = (Button) findViewById(R.id.mulch_btn);
                    valueBtn = (Button) findViewById(R.id.value_btn);

                    mulchTextSizeBar = (SeekBar) findViewById(R.id.mulch_size);
                    valueTextSizeBar = (SeekBar) findViewById(R.id.value_size);
                    touchWidthBar = (SeekBar) findViewById(R.id.touch_width);
                    autoCleanSizeBar = (SeekBar) findViewById(R.id.auto_clean_size);
                    roundRadiusBar = (SeekBar) findViewById(R.id.round_radius);

                    mulchTextSizeBarBtn = (Button) findViewById(R.id.mulch_size_btn);
                    valueTextSizeBarBtn = (Button) findViewById(R.id.value_size_btn);
                    touchWidthBarBtn = (Button) findViewById(R.id.touch_width_btn);
                    autoCleanSizeBarBtn = (Button) findViewById(R.id.auto_clean_size_btn);
                    roundRadiusBarBtn = (Button) findViewById(R.id.round_radius_btn);

                    transparentBg = (Switch) findViewById(R.id.transparent_bg);
                    autoClean = (Switch) findViewById(R.id.auto_clean);

                    mulchBtn.setOnClickListener(this);
                    valueBtn.setOnClickListener(this);
                    mulchTextSizeBarBtn.setOnClickListener(this);
                    valueTextSizeBarBtn.setOnClickListener(this);
                    touchWidthBarBtn.setOnClickListener(this);
                    autoCleanSizeBarBtn.setOnClickListener(this);
                    roundRadiusBarBtn.setOnClickListener(this);

                    mulchTextSizeBar.setOnSeekBarChangeListener(this);
                    valueTextSizeBar.setOnSeekBarChangeListener(this);
                    touchWidthBar.setOnSeekBarChangeListener(this);
                    autoCleanSizeBar.setOnSeekBarChangeListener(this);
                    roundRadiusBar.setOnSeekBarChangeListener(this);

                    transparentBg.setOnCheckedChangeListener(this);
                    autoClean.setOnCheckedChangeListener(this);

                    initBuilder2();
                    break;


            }
        }
    }
    private void initBuilder1() {
        builder = new MyScratchCardViewOption.Builder();
        builder.setBackgroundColor(Color.parseColor("#00E3E3"),Color.parseColor("#6FB7B7"),Color.parseColor("#84C1FF"))
                .setBackgroundColorAngle(30)
                .setMulchColorAngle(90)
                .setBackgroundImg(BitmapFactory.decodeResource(res, R.drawable.phone))
                .setBackgroundImgScaleType(ImageView.ScaleType.CENTER_CROP)
                .setRoundRadius(20)
                .setTextSize(140)//里层文字大小
                .setValueImg(BitmapFactory.decodeResource(res,R.drawable.batman))
                .setValueImgScaleType(ImageView.ScaleType.CENTER_INSIDE)
                .setText("恭喜你获得一等奖")
                .setTextColor(Color.BLUE,Color.RED,Color.CYAN)
                .setMulchColor(Color.BLACK,Color.WHITE,Color.GRAY,Color.WHITE,Color.BLACK)
                .setMulchImg(BitmapFactory.decodeResource(res,R.mipmap.ic_launcher))
                .setMulchImgScaleType(ImageView.ScaleType.CENTER_INSIDE)
                .setMulchText("刮开涂层有奖")
                .setMulchTextColor(Color.parseColor("#FF5809"),Color.parseColor("#B15BFF"))
                .setMulchTextSize(100)//表层的字体大小
                .setRoundRadius(160)//整个view的四周圆角
                .setTouchWdth(100);//涂笔大小
        scratchCard.setOption(new MyScratchCardViewOption(builder));
    }
    private void initBuilder2() {
        builder = new MyScratchCardViewOption.Builder();
        builder.setBackgroundColor(Color.parseColor("#00E3E3"),Color.parseColor("#6FB7B7"),Color.parseColor("#84C1FF"))
                .setBackgroundColorAngle(30)
                .setMulchColorAngle(90)
                .setBackgroundImg(BitmapFactory.decodeResource(res, R.drawable.batman))
                .setBackgroundImgScaleType(ImageView.ScaleType.CENTER_CROP)
                .setRoundRadius(20)
                .setValueImg(BitmapFactory.decodeResource(res,R.drawable.phone))
                .setValueImgScaleType(ImageView.ScaleType.CENTER_INSIDE)
                .setText(valueText.getText().toString())
                .setTextColor(Color.BLUE,Color.RED,Color.CYAN)
                .setMulchColor(Color.BLACK,Color.WHITE,Color.GRAY,Color.WHITE,Color.BLACK)
                .setMulchImg(BitmapFactory.decodeResource(res,R.mipmap.ic_launcher))
                .setMulchImgScaleType(ImageView.ScaleType.CENTER_INSIDE)
                .setMulchText(mulchText.getText().toString())
                .setMulchTextColor(Color.parseColor("#FF5809"),Color.parseColor("#B15BFF"))
                .setMulchTextSize(mulchTextSizeBar.getProgress()*3)
                .setRoundRadius(roundRadiusBar.getProgress()*3)
                .setTouchWdth(touchWidthBar.getProgress()*3);
        scratchCard.setOption(new MyScratchCardViewOption(builder));
    }

    //=======setDisplayHomeAsUpEnabled        start       ==================
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        if (id == android.R.id.home) {
//            finish();
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
    //=======setDisplayHomeAsUpEnabled        end       ==================

    //=======onclick        start       ==================
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mulch_btn:
                builder.setMulchText(mulchText.getText().toString());
                break;
            case R.id.value_btn:
                builder.setText(valueText.getText().toString());
                break;
            case R.id.mulch_size_btn:
                builder.setMulchTextSize(mulchTextSizeBar.getProgress()*3);
                break;
            case R.id.value_size_btn:
                builder.setTextSize(valueTextSizeBar.getProgress()*3);
                break;
            case R.id.touch_width_btn:
                builder.setTouchWdth(touchWidthBar.getProgress()*3);
                break;
            case R.id.auto_clean_size_btn:
                builder.setAutoClean(autoCleanSizeBar.getProgress()*1.0f/100);
                break;
            case R.id.round_radius_btn:
                builder.setRoundRadius(roundRadiusBar.getProgress());
                break;
        }
        scratchCard.setOption(new MyScratchCardViewOption(builder));
    }
    //=======onclick        end       =======================


    //============seekbar       start    ===================
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //        switch (seekBar.getId()){
        //            case R.id.mulch_size:
        //                builder.setMulchTextSize(seekBar.getProgress());
        //                break;
        //            case R.id.value_size:
        //                builder.setTextSize(seekBar.getProgress());
        //                break;
        //            case R.id.touch_width:
        //                builder.setTouchWdth(seekBar.getProgress());
        //                break;
        //            case R.id.auto_clean_size:
        //                builder.setAutoClean(seekBar.getProgress()*1.0f/100);
        //                break;
        //            case R.id.round_radius:
        //                builder.setRoundRadius(seekBar.getProgress());
        //                break;
        //        }
        //        scratchCard.setOption(new LScratchCardOption(builder));
    }
    //============seekbar       end    ======================


    //============CheckButton       end    ===================
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        switch (compoundButton.getId()){
            case R.id.transparent_bg:
                builder.setTransparentBg(isChecked);
                break;
            case R.id.auto_clean:
                builder.setAutoCleanEnable(isChecked);
                break;
        }
        scratchCard.setOption(new MyScratchCardViewOption(builder));
    }
    //============CheckButton       end    ===================
}
