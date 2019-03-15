package com.example.lenovo.drawertest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TousuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tousu);
    }
    public void onClick(View v){
        Intent it=new Intent (Intent.ACTION_VIEW);
        switch(v.getId()){
            case R.id.button1:
                it.setData(Uri.parse("tel:15650584489"));
                break;
            case R.id.button2:
                it.setData(Uri.parse("sms:15650584489?body=您好！我对万达影院App有如下建议："));
                break;
            case R.id.button3:
                it.setData(Uri.parse("mailto:service@flag.com.tw"));
                it.putExtra(Intent.EXTRA_COMPONENT_NAME,
                        new String[]{"2441068595@qq.com"});
                it.putExtra(Intent.EXTRA_SUBJECT,"投诉建议");
                it.putExtra(Intent.EXTRA_TEXT,"您好，\n我对万达影院App有如下建议：");
                break;
        }
        startActivity(it);
    }
}