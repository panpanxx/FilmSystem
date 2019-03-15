package com.example.lenovo.drawertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class content extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        Bundle bundle=getIntent().getExtras();
        int imageid=bundle.getInt("content");

        ImageView Iv=(ImageView) findViewById(R.id.imageView3);
        Iv.setImageResource(imageid);

    }
}
