package com.example.gothrift.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.gothrift.R;

public class NotReadChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_read_chat);
    }
    public void allChats(View view){
        Intent myIntent = new Intent(this, DaftarActivity.class);
        startActivity(myIntent);
    }
}