package com.example.gunungsoputan;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView buku_tamu = findViewById(R.id.tombolbuku);
        ImageView informasi = findViewById(R.id.tombolinformasi);
        ImageView jalur = findViewById(R.id.tomboljalur);
        ImageView darurat = findViewById(R.id.tomboldarurat);
        ImageView exit = findViewById(R.id.tombolexit);

        buku_tamu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, scanbarcodetamu.class);
                startActivity(intent);
            }
        });

       informasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, informasigunung.class);
                startActivity(intent);
            }
        });

        jalur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, jalurpendakian.class);
                startActivity(intent);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });

        darurat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomor="081244477260";
                Intent memangil = new Intent(Intent.ACTION_DIAL);
                memangil.setData(Uri.fromParts("tel",nomor, null));
                startActivity(memangil);
            }
        });
    }









}