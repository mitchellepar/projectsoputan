package com.example.gunungsoputan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class pinus1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pinus1);

        ImageView kembali_1 = findViewById(R.id.imageView3);

        kembali_1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pinus1.this, jalurpendakian.class);
                startActivity(intent);
            }
        });
    }


}