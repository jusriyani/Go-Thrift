package com.example.gothrift.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.gothrift.R;
import com.example.gothrift.adapter.ViewPagerAdapterOnboarding;

public class MainActivity extends AppCompatActivity {

    ActionBar actionBar;

    ViewPager viewPager;
    LinearLayout linearLayout;
    TextView[] dostTv;
    int[] layouts;
    Button mNextBtn, mSkipBtn;
    ViewPagerAdapterOnboarding viewPagerAdapterOnboarding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!isFirstTimeAppStart()){
            setAppStartStatus(false);
            startActivity(new Intent(MainActivity.this, AnotherActivity.class));
            finish();
        }

        actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }

        viewPager = findViewById(R.id.viewPager);
        linearLayout = findViewById(R.id.dotsLayout);
        mNextBtn = findViewById(R.id.btn_next);
        mSkipBtn = findViewById(R.id.btn_skip);

//        statusBarTransparent();

        mSkipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAppStartStatus(false);
                startActivity(new Intent(MainActivity.this, AnotherActivity.class));
                finish();
            }
        });

        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPage = viewPager.getCurrentItem()+1;
                if (currentPage < layouts.length){
                    viewPager.setCurrentItem(currentPage);
                }else {
                    setAppStartStatus(false);
                    startActivity(new Intent(MainActivity.this, AnotherActivity.class));
                    finish();
                }
            }
        });

        layouts = new int[]{
                R.layout.slide_1,
                R.layout.slide_2,
                R.layout.slide_3
        };
        viewPagerAdapterOnboarding = new ViewPagerAdapterOnboarding(layouts,getApplicationContext());
        viewPager.setAdapter(viewPagerAdapterOnboarding);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == layouts.length-1){
                    mNextBtn.setText("Start");
                    mSkipBtn.setVisibility(View.GONE);
                } else{
                    mNextBtn.setText("Next");
                    mSkipBtn.setVisibility(View.VISIBLE);
                }
                setDots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        setDots(0);

    }

    private boolean isFirstTimeAppStart(){
        SharedPreferences pref = getApplicationContext().getSharedPreferences("SLIDER_APP", Context.MODE_PRIVATE);
        return pref.getBoolean("APP_START", true);
    }

    private void setAppStartStatus(boolean status){
        SharedPreferences pref = getApplicationContext().getSharedPreferences("SLIDER_APP", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("APP_START", status);
        editor.apply();
    }

//    private void statusBarTransparent() {
//
//        if (Build.VERSION.SDK_INT >= 21){
//            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE|View.SYSTEM_UI_FLAG_FULLSCREEN);
//            Window window = getWindow();
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(Color.TRANSPARENT);
//        }
//
//    }

    private void setDots(int page){
        linearLayout.removeAllViews();
        dostTv = new TextView[layouts.length];
        for (int i =0; i < dostTv.length; i++ ){
            dostTv[i] = new TextView(this);
            dostTv[i].setText(Html.fromHtml("&#8226;"));
            dostTv[i].setTextSize(30);
            dostTv[i].setTextColor(Color.parseColor("#FFFFFF"));
            linearLayout.addView(dostTv[i]);
        }
        if (dostTv.length > 0){
            dostTv[page].setTextColor(Color.parseColor("#FFFF5F00"));
        }
    }
}