package com.example.lenovo.drawertest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle bundle=getIntent().getExtras();
        int imageid=bundle.getInt("image");
        String name=bundle.getString("name");
        String type=bundle.getString("type");
        String message=bundle.getString("message");
        String grade=bundle.getString("grade");
        String dir=bundle.getString("dir");
        ImageView Iv=(ImageView) findViewById(R.id.imageView);
        Iv.setImageResource(imageid);
        TextView tv=(TextView) findViewById(R.id.textView);
        tv.setText(name);
        TextView tv2=(TextView) findViewById(R.id.textView2);
        tv2.setText(dir);
        TextView tv3=(TextView) findViewById(R.id.textView5);
        tv3.setText(type);
        TextView tv4=(TextView) findViewById(R.id.textView4);
        tv4.setText(grade);
        TextView tv5=(TextView) findViewById(R.id.textView3);
        tv5.setText(message);

        Button button3=(Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent c=new Intent(details.this,Select.class);
                startActivity(c);
            }

        });


    }
}
