package com.example.hasan.loginregister;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class SectionD extends AppCompatActivity {

    TextView tv;
    private static ImageView imgview;
    private static Button buttonstm;
    private static Button buttonstm1;
    private static int current_image_index;
    int[] images={R.mipmap.image10, R.mipmap.image11, R.mipmap.image12,R.mipmap.tick};
    private static TextView tv1;
    String[] rollnum ={"RollNumber:    10","RollNumber:    11","RollNumber:   12",""};
    String PorA[]=new String[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_d);
        tv=(TextView) findViewById(R.id.textView3);
        tv.setText(getIntent().getStringExtra("DATE"));
        try {
            buttonClick();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void buttonClick() throws IOException {
        imgview = (ImageView) findViewById(R.id.ImageView);
        buttonstm = (Button) findViewById(R.id.Bpresent);
        buttonstm1 = (Button) findViewById(R.id.bAbsent);
        final String date = tv.getText().toString();
        tv1 = (TextView) findViewById(R.id.textView);

        buttonstm.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {

                        current_image_index++;
                        current_image_index = current_image_index % images.length;
                        imgview.setImageResource(images[current_image_index]);
                        current_image_index = current_image_index % rollnum.length;
                        String ans = rollnum[current_image_index];
                        tv1.setText(ans);
                        PorA[current_image_index] = "Present";
                        if (current_image_index == 3) {
                            Response.Listener<String> responseListener = new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    //tv1.setText(response);
                                    try {
                                        JSONObject jsonResponse = new JSONObject(response);
                                        boolean success = jsonResponse.getBoolean("success");
                                        if (success) {
                                            tv1.setText(response);
                                            Intent intent = new Intent(SectionD.this, PickingD.class);
                                            SectionD.this.startActivity(intent);
                                        } else {
                                            tv1.setText(response);
                                            AlertDialog.Builder builder = new AlertDialog.Builder(SectionD.this);
                                            builder.setMessage("Register Failed")
                                                    .setNegativeButton("Retry", null)
                                                    .create()
                                                    .show();
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                }
                            };

                            AttendanceD attendanceD = new AttendanceD(date, PorA[0], PorA[1], PorA[2], PorA[3], responseListener);
                            RequestQueue queue = Volley.newRequestQueue(SectionD.this);
                            queue.add(attendanceD);

                        }
                    }
                }
        );


        buttonstm1.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        current_image_index++;
                        current_image_index = current_image_index % images.length;
                        imgview.setImageResource(images[current_image_index]);
                        current_image_index = current_image_index % rollnum.length;
                        String ans = rollnum[current_image_index];
                        tv1.setText(ans);
                        PorA[current_image_index] = "Absent";
                        if (current_image_index == 3) {
                            Response.Listener<String> responseListener = new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    try {
                                        JSONObject jsonResponse = new JSONObject(response);
                                        boolean success = jsonResponse.getBoolean("success");
                                        if (success) {
                                            Intent intent = new Intent(SectionD.this, PickingD.class);
                                            SectionD.this.startActivity(intent);
                                        } else {
                                            AlertDialog.Builder builder = new AlertDialog.Builder(SectionD.this);
                                            builder.setMessage("Register Failed")
                                                    .setNegativeButton("Retry", null)
                                                    .create()
                                                    .show();
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                }
                            };

                            AttendanceD attendanceD = new AttendanceD(date, PorA[0], PorA[1], PorA[2], PorA[3], responseListener);
                            RequestQueue queue = Volley.newRequestQueue(SectionD.this);
                            queue.add(attendanceD);

                        }
                    }
                }
        );
    }

}