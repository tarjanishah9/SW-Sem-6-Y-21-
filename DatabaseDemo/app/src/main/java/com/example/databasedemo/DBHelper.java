package com.example.databasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;



public class DBHelper extends SQLiteOpenHelper {
    String createPerson="CREATE TABLE tbPerson" +
            "(pid integer primary key autoincrement,fname varchar(20),lname varchar(20),email varchar(20),password varchar(20))";

    public DBHelper(@Nullable Context context,
                    @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(createPerson);
        Log.i("Create:","Person Table Created..");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public long addData(String fname, String lname, String email, String pass){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put("fname",fname);
        cv.put("lname",lname);
        cv.put("email",email);
        cv.put("password",pass);
        long row=db.insert("tbPerson",null,cv);
        db.close();
        return row;
    }
}
