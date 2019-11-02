package com.example.hasan.loginregister;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hasan on 10/24/2017.
 */

public class AttendanceB extends StringRequest {
    private static final String CALENDAR_REQUEST_URL="http://app-1506792717.000webhostapp.com/AttendanceB.php";
    private Map<String, String> params;
    public AttendanceB(String date,String Garbage,String RollNo4,String RollNo5,String RollNo6, Response.Listener<String> listener) {
        super(Method.POST, CALENDAR_REQUEST_URL, listener, null);
        params= new HashMap<>();
        params.put("Date",date);
        params.put("Garbage",Garbage);
        params.put("RollNo4",RollNo4);
        params.put("RollNo5",RollNo5);
        params.put("RollNo6",RollNo6);

    }
    public Map<String, String> getParams(){
        return params;
    }
}

