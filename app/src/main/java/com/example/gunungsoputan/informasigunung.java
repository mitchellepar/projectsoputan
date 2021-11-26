package com.example.gunungsoputan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class informasigunung extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informasigunung);

        ImageView kembaliinfo = findViewById(R.id.imageView6);

        kembaliinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(informasigunung.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}