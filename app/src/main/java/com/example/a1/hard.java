package com.example.a1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.naoui.rh.R;

public class hard extends AppCompatActivity {

    ImageButton web, mobile, desktop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard);

        web = findViewById(R.id.Web);
        mobile = findViewById(R.id.Mobile);
        desktop = findViewById(R.id.Desktop);

        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(hard.this, ac4.class);

                startActivity(myintent);

            }
        });
        desktop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent45 = new Intent(hard.this, Desktop.class);
                startActivity(myintent45);

            }
        });

        mobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent22 = new Intent(hard.this, Mobile.class);

                startActivity(myintent22);

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // R.menu.mymenu is a reference to an xml file named mymenu.xml which should be inside your res/menu directory.
        // If you don't have res/menu, just create a directory named "menu" inside res
        getMenuInflater().inflate(R.menu.actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // handle button activities
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.mysoft) {
            Intent intent=new Intent(hard.this,soft.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }}