package com.darshil.ormconnectivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 01-03-2023.
 */

public class dbhelper extends SQLiteOpenHelper {
    String col_1="id",col_2="nm",tbl_nm="data";
    String tbl_sql="create table "+tbl_nm+"("+
            col_1+" integer,"+
            col_2+" text)";
    public dbhelper(Context context){
        super(context,"test.db",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tbl_sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS ");
        onCreate(db);
    }
    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(col_1,user.getId());
        values.put(col_2, user.getNm());;
        db.insert(tbl_nm, null, values);
        db.close();
    }
    public User getUser(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from "+tbl_nm+" where "+col_1+"="+id,null);
        if (cursor != null)
            cursor.moveToFirst();
            User user = new User(Integer.parseInt(cursor.getString(0)),cursor.getString(1));
        return user;
    }
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + tbl_nm;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(Integer.parseInt(cursor.getString(0)));
                user.setNm(cursor.getString(1));
                userList.add(user);
            } while (cursor.moveToNext());
        }
        return userList;
    }
    public int updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(col_2, user.getNm());
        return db.update(tbl_nm, values, col_1 + " = ?",
                new String[] { String.valueOf(user.getId()) });
    }

    public void deleteUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tbl_nm, col_1 + " = ?",
                new String[] { String.valueOf(user.getId()) });
        db.close();
    }

}
