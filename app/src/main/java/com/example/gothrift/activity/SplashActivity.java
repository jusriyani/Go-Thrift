package com.example.gothrift.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gothrift.R;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 5000;

    //variables of animation
    Animation topAnim, bottomAnim;
    ImageView logo;
    TextView eduChildTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //animation
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        //hooks
        logo = findViewById(R.id.goThriftLogo);
        eduChildTextView = findViewById(R.id.goThriftTextView);

        logo.setAnimation(topAnim);
        eduChildTextView.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);

    }
}