package com.example.lenovo.drawertest;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class zhuce extends AppCompatActivity {
    private EditText edittext1,edittext2,edittext3;
    private Button button;
    private DatabaseHelper databaseHelper;
    //数据库名称
    private static final String DATABASE_NAME="usermsg.db";
    //数据库版本号
    private static final int DATABASE_VERSION=1;

    private static final String TABLE_NAME="username";
    private SQLiteDatabase db;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_zhuce);
        edittext1=(EditText)findViewById(R.id.editview1);
        edittext2=(EditText)findViewById(R.id.editview2);
        edittext3=(EditText)findViewById(R.id.editview3);

        button=(Button)findViewById(R.id.tijiao);
        button.setOnClickListener(new OnClickListener(){


            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String namestring = edittext1.getText().toString();
                String passstring = edittext2.getText().toString();
                String repassstring=edittext3.getText().toString();
                if(passstring.equals(repassstring))
                {
                    databaseHelper=new DatabaseHelper(zhuce.this);
                    db =  databaseHelper.getReadableDatabase();
                    db.execSQL("insert into username (name,password) values(?,?)",new String[]{namestring,passstring});

                    Toast.makeText(zhuce.this, "注册成功！", Toast.LENGTH_LONG).show();
                    Intent b=new Intent(zhuce.this,login.class);
                    startActivity(b);
                }
                else
                {
                    Toast.makeText(zhuce.this,"两次密码不一致", Toast.LENGTH_LONG).show();
                }
            }

        });
    }


}
