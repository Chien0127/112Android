package com.example.datetimepickerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import  java.util.Calender;

public class MainActivity extends AppCompatActivity
        implements DatePickerDialog.OnDateSetListener{

    private TextView txvOutput;
    private Calender dt = Calender.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txvOutput = (TextView) findViewById(R.id.txvOutput);

        Button btnDate = (Button) findViewById(R.id.btnDate);

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 DatePickerDialog dlg = new DatePickerDialog(MainActivity.this,
                        MainActivity.this,
                        dt.get(Calender.YEAR),
                        dt.get(Calender.MONTH),
                        dt.get(Calender.DAY_OF_MONTH));
                dlg.getDatePicker().setMinDate(dt.getTimeInMillis()-1000);
                dlg.show();
            }
        });

        Button btnTime = (Button) findViewById(R.id.btnTime);
        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 TimePickerDialog dlg= new TimePickerDialog(MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                txvOutput.setText("時間 : " + hourOfDay + ":" + minute );
                            }
                        },
                        dt.get(Calender.HOUR),
                        dt.get(Calender.MINUTE), false);
                         dlg.show();
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

    }
}