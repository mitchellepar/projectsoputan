package com.example.gunungsoputan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "bukutamu.db", null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("CREATE TABLE buku_tamu(nama TEXT, alamat TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("DROP TABLE IF EXISTS buku_tamu");
    }

    public Boolean insertuserdata(String nama, String alamat)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nama", nama);
        contentValues.put("alamat", alamat);
        long result = DB.insert("buku_tamu", null, contentValues);
        if(result==-1){
            return false;
        }else {
            return true;
        }
    }

    public Boolean updateuserdata(String nama, String alamat)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nama", nama);
        contentValues.put("alamat", alamat);
        Cursor cursor = DB.rawQuery("SELECT * FROM buku_tamu WHERE nama = ?", new String[]{nama});
        if(cursor.getCount()>0) {


        long result = DB.update("buku_tamu", contentValues, "nama=?", new String[] {nama});
        if(result==-1){
            return false;
        }else {
            return true;
        }
        }else
        {
            return false;
        }
    }

    public Cursor getdata()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("SELECT * FROM buku_tamu ", null);

        return cursor;

    }

}
