package com.example.databasedemo;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


public class DBHelper extends SQLiteOpenHelper {
    public static final  String TB_NAME="tbPerson";
    public static final  String TB_PER_PID="pid";
    public static final  String TB_PER_FNAME="fname";
    public static final  String TB_PER_LNAME="lname";
    public static final  String TB_PER_EMAIL="email";
    public static final  String TB_PER_PASS="password";
    String createPerson="CREATE TABLE " +TB_NAME +
            "("+TB_PER_PID +" integer primary key autoincrement," +
            TB_PER_FNAME +" varchar(20)," +
            TB_PER_LNAME+" varchar(20)," +
            TB_PER_EMAIL+" varchar(20)," +
            TB_PER_PASS+" varchar(20))";

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
    public long addData(Person p){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(TB_PER_FNAME,p.getFname());
        cv.put(TB_PER_LNAME,p.getLname());
        cv.put(TB_PER_EMAIL,p.getEmail());
        cv.put(TB_PER_PASS,p.getPass());
        long row=db.insert(TB_NAME,null,cv);
        db.close();
        return row;
    }
    @SuppressLint("Range")
    public List<Person> getData(){
        SQLiteDatabase db=this.getReadableDatabase();
        String sql="SELECT * FROM "+TB_NAME;
        Person p=null;
        List<Person> personList=new ArrayList<>();
        Cursor cursor=db.rawQuery(sql,null);
        if(cursor.getCount()>0){
            while (cursor.moveToNext()){
                String fname=cursor.getString(cursor.getColumnIndex(TB_PER_FNAME));
                String lname=cursor.getString(cursor.getColumnIndex(TB_PER_LNAME));
                String email=cursor.getString(cursor.getColumnIndex(TB_PER_EMAIL));
                String pass=cursor.getString(cursor.getColumnIndex(TB_PER_PASS));
                p=new Person(fname,lname,email,pass);
                personList.add(p);
            }
        }
        return personList;

    }
    @SuppressLint("Range")
    public Person checkUser(Person p){
        SQLiteDatabase db=this.getReadableDatabase();

        Person per=null;
        String sql="SELECT * FROM "+ TB_NAME +" WHERE "+TB_PER_EMAIL +"='"+p.getEmail()+"'";
        Cursor c=db.rawQuery(sql,null);
        if(c.getCount()>0){
            c.moveToFirst();
             String pass=c.getString(c.getColumnIndex(TB_PER_PASS));
             if(pass.equals(p.getPass())){
                 per=new Person();
                 int id=c.getInt(c.getColumnIndex(TB_PER_PID));
                 String fName=c.getString(c.getColumnIndex(TB_PER_FNAME));
                 String lName=c.getString(c.getColumnIndex(TB_PER_LNAME));
                 per.setFname(fName);
                 per.setLname(lName);
                 per.setpId(id);
                 per.setEmail(p.getEmail());

             }

        }
        return per;
    }
    public int updateData(Person p){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(TB_PER_FNAME,p.getFname());
        cv.put(TB_PER_LNAME,p.getLname());
        int row=db.update(TB_NAME,cv,TB_PER_PID + "=?",new String[]{String.valueOf(p.getpId())});
        return row;
    }
}
