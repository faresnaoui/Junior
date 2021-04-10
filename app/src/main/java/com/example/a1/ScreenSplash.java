package com.example.a1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.naoui.rh.R;

public class ScreenSplash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_splash);
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                Intent i = new Intent(com.example.a1.ScreenSplash.this, MainActivity.class); startActivity(i);
                finish(); } }, 2000);
    }
    }
