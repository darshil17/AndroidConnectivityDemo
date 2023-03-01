package com.darshil.ormconnectivity;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

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
        List<User> list = helper.getAllUsers();
        String data="";
        for (User user: list){
            data+="Id: "+user.getId()+"\t Name: "+user.getNm()+"\n";
        }
        txt_data.setText(data);
    }
    public void btn_ins_click(View view){
        User user = new User(Integer.parseInt(etxt_id.getText().toString()),etxt_nm.getText().toString());
        helper.addUser(user);
        display();
    }
    public void btn_del_click(View view){
        User user = helper.getUser(Integer.parseInt(etxt_id.getText().toString()));
        helper.deleteUser(user);
        display();
    }
    public void btn_upd_click(View view){
        User user = new User(Integer.parseInt(etxt_id.getText().toString()),etxt_nm.getText().toString());
        helper.updateUser(user);
        display();
    }
    public void btn_show_click(View view){
        display();
    }
}
