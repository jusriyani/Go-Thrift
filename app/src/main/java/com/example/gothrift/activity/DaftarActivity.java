package com.example.gothrift.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gothrift.R;

public class DaftarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
    }
    public void masuk(View view){
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }
}