package com.example.hasan.loginregister;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hasan on 10/24/2017.
 */

public class AttendanceC extends StringRequest {
    private static final String CALENDAR_REQUEST_URL="http://app-1506792717.000webhostapp.com/AttendanceC.php";
    private Map<String, String> params;
    public AttendanceC(String date,String Garbage,String RollNo7,String RollNo8,String RollNo9, Response.Listener<String> listener) {
        super(Method.POST, CALENDAR_REQUEST_URL, listener, null);
        params= new HashMap<>();
        params.put("Date",date);
        params.put("Garbage",Garbage);
        params.put("RollNo7",RollNo7);
        params.put("RollNo8",RollNo8);
        params.put("RollNo9",RollNo9);

    }
    public Map<String, String> getParams(){
        return params;
    }
}

