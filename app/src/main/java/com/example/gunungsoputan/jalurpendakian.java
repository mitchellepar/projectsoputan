package com.example.gunungsoputan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class jalurpendakian extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jalurpendakian);

        ImageView start = findViewById(R.id.imageView2);
        ImageView pinus1 = findViewById(R.id.imageView9);
        ImageView basecamp =  findViewById(R.id.imageView7);
        ImageView panorama = findViewById(R.id.imageView8);
        ImageView puncak_ = findViewById(R.id.imageView18);
        ImageView keminfo = findViewById(R.id.imageView10);

        start.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(jalurpendakian.this, start.class);
                startActivity(intent);
            }
        });


        pinus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(jalurpendakian.this, pinus1.class);
                startActivity(intent);
            }
        });

        basecamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(jalurpendakian.this, basecamp.class);
                startActivity(intent);
            }
        });


        panorama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(jalurpendakian.this, panorama.class);
                startActivity(intent);
            }
        });

        puncak_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(jalurpendakian.this, puncak.class);
                startActivity(intent);
            }
        });


        keminfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(jalurpendakian.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

