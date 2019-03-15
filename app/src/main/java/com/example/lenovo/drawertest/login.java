package com.example.lenovo.drawertest;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    private TextView textview;

    private static final String TABLE_NAME="username";
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase db;
    private Button button1;
    private EditText nameText,passText;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        nameText=(EditText)findViewById(R.id.username);
        passText=(EditText)findViewById(R.id.pasw);

        button1=(Button)findViewById(R.id.tijiao);
        textview=(TextView)findViewById(R.id.zhuce);
        textview.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                intent=new Intent(login.this,zhuce.class);
                startActivity(intent);
            }

        });

        //启动注册页面


        //启动随便看看页面
        TextView textview1=(TextView)findViewById(R.id.suibian);
        textview1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent a=new Intent(login.this,MainActivity.class);
                startActivity(a);
            }

        });
        button1.setOnClickListener(new LoginListener());
    }
    class LoginListener implements View.OnClickListener {
        public void onClick(View v){
            String nameString =nameText.getText().toString();
            String passString=passText.getText().toString();
            if(nameString.equals("")||passString.equals(""))
            {
                //弹出消息框
                new AlertDialog.Builder(login.this).setTitle("错误")
                        .setMessage("帐号或密码不能空").setPositiveButton("确定", null)
                        .show();
            }else{
                isUserinfo(nameString,passString);
            }
        }
    }

    public Boolean isUserinfo(String name,String pass)
    {
        String nameString=name;
        String passString=pass;
        databaseHelper=new DatabaseHelper(this);
        db =  databaseHelper.getReadableDatabase();
        try{
            Cursor cursor=db.query(TABLE_NAME, new String[]{"name","password"},"name=?",new String[]{nameString},null,null,"password");
            while(cursor.moveToNext())
            {
                String password=cursor.getString(cursor.getColumnIndex("password"));


                if(passString.equals(password))
                {
                    new AlertDialog.Builder(login.this).setTitle("正确")
                            .setMessage("成功登录").setPositiveButton("确定", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent a=new Intent(login.this,MainActivity.class);
                            startActivity(a);
                        }
                    }).show();

                    break;
                }
                else
                {
                    Toast.makeText(this, "用户名密码不正确", Toast.LENGTH_LONG).show();
                    break;
                }
            }




        }catch(SQLiteException e){
            CreatTable();
        }
        return false;
    }



    private void CreatTable() {
        // TODO Auto-generated method stub
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME
                + " (name varchar(30) primary key,password varchar(30));";
        try{
            db.execSQL(sql);
        }catch(SQLException ex){}
    }







}

