package com.example.khushi.conn_ins;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class connect1 extends AppCompatActivity {
    EditText rno,nm,mak,disp;
    Button btnins,del,upd;
    dbhelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect1);
        rno=(EditText)findViewById(R.id.txtrno);
        nm=(EditText)findViewById(R.id.txtnm);
        mak=(EditText)findViewById(R.id.txtmark);
        disp=(EditText)findViewById(R.id.disp1);
        helper=new dbhelper(this);
        del=(Button)findViewById(R.id.btndel);
        upd=(Button)findViewById(R.id.btnupdate);
        btnins=(Button)findViewById(R.id.btninsert);
        display();
        btnins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String roll = rno.getText().toString();
                String name = nm.getText().toString();
                String marks = mak.getText().toString();
                if (helper.insertdata(roll, name, marks)) {
                    Toast.makeText(getApplicationContext(), "recorded inserted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_SHORT).show();
                }
                display();
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String roll = rno.getText().toString();

                if (helper.deletedata(roll)) {
                    Toast.makeText(getApplicationContext(), "recorded deleted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_SHORT).show();
                }
                display();
            }
        });
        upd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String roll = rno.getText().toString();
                String name = nm.getText().toString();
                String marks = mak.getText().toString();
                if (helper.updatedata(roll, name, marks)) {
                    Toast.makeText(getApplicationContext(), "recorded inserted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_SHORT).show();
                }
                display();
            }
        });



    }
//    public void display(){
//        Cursor c=helper.displaydata();
//        String data="";
//        while (c.moveToNext()){
//            data+="Rollno:"+c.getString(0)+"\n\tName:"+c.getString(1)+"\n\tmark:"+c.getString(2);
//        }
//        disp.setText(data);
//
//    }

    public void display(){
        Cursor c=helper.displaydata();
        String data="";
        while (c.moveToNext()){
            data+="Rollno"+c.getString(0)+"\n\t Name:"+c.getString(1)+"\n\tmark"+c.getString(2);

        }
        disp.setText(data);
    }
















}
