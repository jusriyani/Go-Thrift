package com.example.gothrift.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.gothrift.R;

public class AllChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_chat);
    }

    public void notRead(View view){
        Intent myIntent = new Intent(this, NotReadChatActivity.class);
        startActivity(myIntent);
    }
}