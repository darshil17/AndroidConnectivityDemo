package com.example.admin.rawqueryconnectivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Admin on 28-02-2023.
 */

public class dbhelper extends SQLiteOpenHelper {
    String tbl_nm="data",col_1="id",col_2="nm";
    public dbhelper(Context context){
        super(context,"test.db",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table "+tbl_nm+"("+col_1+" integer,"+col_2+" text)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,int newVersion){}
    public Cursor showData(){
        SQLiteDatabase db=this.getReadableDatabase();
        return db.rawQuery("select * from "+tbl_nm,null);
    }
    public void insertData(String id,String nm){
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("insert into "+tbl_nm+"("+col_1+","+col_2+") values("+id+",'"+nm+"')");
    }
    public void  updateData(String id,String nm){
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("update "+tbl_nm+" set "+col_2+"='"+nm+"' where "+col_1+"="+id);
    }
    public void  deleteData(String id){
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("delete from "+tbl_nm+" where "+col_1+"="+id);
    }
}
