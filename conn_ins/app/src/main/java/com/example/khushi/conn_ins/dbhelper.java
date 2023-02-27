package com.example.khushi.conn_ins;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.ContentValues;

public class dbhelper extends SQLiteOpenHelper {
    String tbl_nm="emp",col_1="rno",col_2="nm",col_3="mark";
    public dbhelper(Context context) {
        super(context, "tests.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + tbl_nm + "(" + col_1 + " integer , " + col_2 + " text," + col_3 + " text)");
    }
    public Cursor displaydata()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        return db.rawQuery("select * from emp",null);

    }
    public boolean insertdata(String rno,String nm,String mark){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(col_1,rno);
        cv.put(col_2,nm);
        cv.put(col_3,mark);
        long res=db.insert(tbl_nm,null,cv);
        if (res==-1){
            return false;
        }
        else {
            return  true;
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean deletedata(String rno) {
        SQLiteDatabase db=this.getWritableDatabase();
        long res=db.delete(tbl_nm,"rno=?",new String[]{rno});
        if (res==-1){
            return  false;

        }

        else {
            return true;
        }

    }


    public boolean updatedata(String roll, String name, String marks) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(col_2,name);
        cv.put(col_3,marks);
        long res=db.update(tbl_nm,cv,"rno=?",new String[]{roll});
        if (res==-1){
            return false;

        }
        else {
            return true;
        }
    }
}
