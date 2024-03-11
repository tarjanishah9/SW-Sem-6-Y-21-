package com.example.firstapplication1402;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class DialogActivity extends AppCompatActivity {

    EditText edDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        edDate=findViewById(R.id.edDate);
        edDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar=Calendar.getInstance();
                int cYear=calendar.get(Calendar.YEAR);
                int cMonth=calendar.get(Calendar.MONTH);
                int cDate=calendar.get(Calendar.DAY_OF_MONTH);
                int cHour=calendar.get(Calendar.HOUR_OF_DAY);
                int cMin=calendar.get(Calendar.MINUTE);
                Log.i("Today's Date",cDate+"-"+(cMonth+1)+"-"+cYear);
                TimePickerDialog timePickerDialog=new TimePickerDialog(DialogActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        String time="",hour="",min="";
                        if(i<=12) {
                            if(i<=9)
                                hour="0"+i;
                            time = "AM";
                        }
                        else {

                            i=i-12;
                            if(i<=9)
                                hour="0"+i;
                            else
                                hour=""+i;
                            time = "PM";
                        }
                        if(i1<=9)
                            min="0"+i1;
                        else
                            min=""+i1;

                        edDate.setText(hour+":"+min + " "+time);
                    }
                },cHour,cMin,false);
                timePickerDialog.show();

               /* DatePickerDialog dialog=new DatePickerDialog(DialogActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        String date="",month="";
                        if(i2<=9){
                            date="0"+i2;
                        }
                        else
                            date=""+i2;
                        i1++;
                        if(i1<=9){

                            month="0"+i1;
                        }
                        else
                            month=""+i1;

                        edDate.setText(date+"/"+month+"/"+i);
                    }
                },cYear,cMonth,cDate);
                dialog.show();*/
            }
        });

    }
}