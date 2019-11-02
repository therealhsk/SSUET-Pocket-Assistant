package com.example.hasan.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
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

public class SectionA extends AppCompatActivity   {


    TextView tv;

    private static ImageView imgview;
    private static TextView tv1;
    private static int current_image_index;

    int[] images = {R.mipmap.image1, R.mipmap.image2, R.mipmap.image3, R.mipmap.tick};
    String[] rollnum = {"RollNumber:    1", "RollNumber:    2", "RollNumber:   3", ""};
    String[] PorA = new String[5];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section);

        tv = (TextView) findViewById(R.id.textView3);
        tv.setText(getIntent().getStringExtra("DATE"));

        try {
            buttonClick();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
/*
    public ArrayList<String> fetchRollNumber()
    {
        ArrayList<String> listItems = new ArrayList<String>();

        try {
            URL RollNo = new URL("http://app-1506792717.000webhostapp.com/AttendanceA.php");
            URLConnection tc = RollNo.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    tc.getInputStream()));

            String line;
            while ((line = in.readLine()) != null) {
\                JSONArray ja = new JSONArray(line);

                for (int i = 0; i < ja.length(); i++) {
                    JSONObject jo = (JSONObject) ja.get(i);
                    listItems.add(jo.getString("text"));
                }


            }
        } catch (IOException | JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listItems;
    }

*/


    public void buttonClick() throws IOException {
        imgview = (ImageView) findViewById(R.id.ImageView);
        Button buttonstm = (Button) findViewById(R.id.Bpresent);
        Button buttonstm1 = (Button) findViewById(R.id.bAbsent);
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
                                            Intent intent = new Intent(SectionA.this, PickingD.class);
                                            SectionA.this.startActivity(intent);
                                        } else {
                                            tv1.setText(response);
                                            AlertDialog.Builder builder = new AlertDialog.Builder(SectionA.this);
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

                            CalendarRequest calendarRequest = new CalendarRequest(date, PorA[0], PorA[1], PorA[2], PorA[3], responseListener);
                            RequestQueue queue = Volley.newRequestQueue(SectionA.this);
                            queue.add(calendarRequest);

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
                                            Intent intent = new Intent(SectionA.this, PickingD.class);
                                            SectionA.this.startActivity(intent);
                                        } else {
                                            AlertDialog.Builder builder = new AlertDialog.Builder(SectionA.this);
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

                            CalendarRequest calendarRequest = new CalendarRequest(date, PorA[0], PorA[1], PorA[2], PorA[3], responseListener);
                            RequestQueue queue = Volley.newRequestQueue(SectionA.this);
                            queue.add(calendarRequest);

                        }
                    }
                }
        );
    }

}