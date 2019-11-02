package com.example.hasan.loginregister;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class PickingD extends AppCompatActivity {

         TextView tv;
        java.util.Calendar mCurrentDate;
        int day,month,year;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_picking_d);
            final Button Done=(Button) findViewById(R.id.bdone);

            tv=(TextView) findViewById(R.id.textView);

            mCurrentDate= java.util.Calendar.getInstance();

            day=mCurrentDate.get(Calendar.DAY_OF_MONTH);
            month=mCurrentDate.get(Calendar.MONTH);
            year=mCurrentDate.get(Calendar.YEAR);

            month=month+1;


            tv.setText(day+"/"+month+"/"+year);

            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DatePickerDialog datePickerDialog = new DatePickerDialog(PickingD.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int MonthOfYear, int dayOfMonth) {

                            MonthOfYear = MonthOfYear + 1;
                            tv.setText(dayOfMonth + "/" + MonthOfYear + "/" + year);
                        }

                    }, year, month, day);
                    datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                    datePickerDialog.show();
                }
            });



            Done.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v)
                {

                    String datevalue= tv.getText().toString();
                    Intent doneintent = new Intent(PickingD.this, Sections.class);
                    doneintent.putExtra("DATE",datevalue);
                    PickingD.this.startActivity(doneintent);



                }
            });


        }
}
