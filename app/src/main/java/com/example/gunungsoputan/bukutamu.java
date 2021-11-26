package com.example.gunungsoputan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class bukutamu extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bukutamu);


        ImageView kembalibuku = findViewById(R.id.imageView14);
        EditText nama, alamat;
        Button submit, view;
        DBHelper DB;

        nama = findViewById(R.id.PTnama);
        alamat = findViewById(R.id.PTalamat);
        submit = findViewById(R.id.BTbukutamu);
        view = findViewById(R.id.BTview);
        DB = new DBHelper(this);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namaTXT = nama.getText().toString();
                String alamatTXT = alamat.getText().toString();

                Boolean checkinsertdata = DB.insertuserdata(namaTXT,alamatTXT);
                if(checkinsertdata==true)
                    Log.i("Insert Berhasil", namaTXT + " " + alamatTXT);
                else
                    Log.i("Insert" ,"Gagal");

            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = DB.getdata();
                if(res.getCount()==0) {
                    Log.i("View", "No Entery Exists");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("Nama :"+res.getString(0) + "\n");
                    buffer.append("Alamat :"+res.getString(1) + "\n\n");
                    buffer.append("=================================\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(bukutamu.this);
                builder.setCancelable(true);
                builder.setTitle("Daftar Pengunjung :");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
        kembalibuku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bukutamu.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}