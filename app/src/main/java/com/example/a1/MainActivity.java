package com.example.a1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.naoui.rh.R;

public class MainActivity extends AppCompatActivity {
ImageButton hard,soft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainly);
        hard=findViewById(R.id.hard);
        soft=findViewById(R.id.Soft);

        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(MainActivity.this,hard.class);

                startActivity(myintent);
            }
        });

        soft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(MainActivity.this,soft.class);
                startActivity(myintent);

            }
        });
    }
}