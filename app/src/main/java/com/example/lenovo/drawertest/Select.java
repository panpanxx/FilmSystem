package com.example.lenovo.drawertest;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class Select extends AppCompatActivity implements View.OnClickListener ,
        DatePickerDialog.OnDateSetListener,
        TimePickerDialog.OnTimeSetListener{
    Calendar c =Calendar.getInstance();
    TextView txDate;
    TextView txTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        txDate=(TextView)findViewById(R.id.tx1);
        txTime=(TextView) findViewById(R.id.tx2);
        txTime.setOnClickListener(this);
        txDate.setOnClickListener(this);

    }
    public void onClick(View v) {
        if(v==txDate){
            new DatePickerDialog(this,this,
                    c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)).show();
        }
        else if(v==txTime) {
            new TimePickerDialog(this,this,
                    c.get(Calendar.HOUR_OF_DAY),c.get(Calendar.MINUTE),true).show();
        }
    }

    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        txDate.setText("日期："+ year + "/" +(month+1) + "/" + dayOfMonth);
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        txTime.setText("时间："+ hourOfDay + ":" +minute );

    }

}
