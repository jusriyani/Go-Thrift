package com.example.gothrift.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.gothrift.R;

public class DikemasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dikemas);
    }

    public void dikemas(View view){
        Intent myIntent = new Intent(this, DikemasActivity.class);
        startActivity(myIntent);
    }
    public void dikirim(View view){
        Intent myIntent = new Intent(this, DikirimActivity.class);
        startActivity(myIntent);
    }
    public void diterima(View view){
        Intent myIntent = new Intent(this, DiterimaActivity.class);
        startActivity(myIntent);
    }
}