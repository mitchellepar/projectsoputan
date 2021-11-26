package com.example.gunungsoputan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class puncak extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puncak);


        ImageView kembali_finish = findViewById(R.id.imageView19);


        kembali_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(puncak.this, jalurpendakian.class);
                startActivity(intent);
            }
        });
    }
}