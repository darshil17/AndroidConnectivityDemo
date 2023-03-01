package com.example.admin.rawqueryconnectivity;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn_upd,btn_ins,btn_del,btn_show;
    EditText etxt_id,etxt_nm;
    TextView txt_data;
    dbhelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_del=(Button) findViewById(R.id.btn_del);
        btn_upd=(Button) findViewById(R.id.btn_upd);
        btn_ins=(Button) findViewById(R.id.btn_ins);
        btn_show=(Button) findViewById(R.id.btn_show);
        etxt_id=(EditText)findViewById(R.id.etxt_id);
        etxt_nm=(EditText)findViewById(R.id.etxt_nm);
        txt_data=(TextView) findViewById(R.id.txtdata);
        helper =new dbhelper(this);
        btn_show.callOnClick();
    }
    public void display(){
        Cursor cursor = helper.showData();
        String data="";
        while (cursor.moveToNext()){
            data+="Id:"+cursor.getString(0)+"\n\t Name:"+cursor.getString(1);
        }
        txt_data.setText(data);
    }
    public void btn_ins_click(View view){
        helper.insertData(etxt_id.getText().toString(),etxt_nm.getText().toString());
        display();
    }
    public void btn_del_click(View view){
        helper.deleteData(etxt_id.getText().toString());
        display();
    }
    public void btn_upd_click(View view){
        helper.updateData(etxt_id.getText().toString(),etxt_nm.getText().toString());
        display();
    }
    public void btn_show_click(View view){
        display();
    }
}

