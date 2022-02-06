package com.example.gothrift.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.gothrift.R;
import com.example.gothrift.adapter.ViewPagerAdapter;
import com.example.gothrift.fragment.FragmentPopuler;
import com.example.gothrift.fragment.FragmentPria;
import com.example.gothrift.fragment.FragmentWanita;
import com.google.android.material.tabs.TabLayout;

public class AnotherActivity extends AppCompatActivity {

    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;

//    ActionBar actionBar;
//
//    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

//        toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        actionBar = getSupportActionBar();
//        if (actionBar != null){
//            actionBar.setTitle("Another Activity");
//        }

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.add(new FragmentPopuler(), "Populer");
        viewPagerAdapter.add(new FragmentWanita(), "Wanita");
        viewPagerAdapter.add(new FragmentPria(), "Pria");


        viewPager.setAdapter(viewPagerAdapter);
        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    @SuppressLint("NonConstantResourceId")
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.shop:
                break;
            case R.id.notif:
                break;
            case R.id.more_ap:
                break;
        }

        return true;
    }
}