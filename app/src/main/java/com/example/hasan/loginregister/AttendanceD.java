package com.example.hasan.loginregister;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hasan on 10/24/2017.
 */

public class AttendanceD extends StringRequest {
    private static final String CALENDAR_REQUEST_URL="http://app-1506792717.000webhostapp.com/AttendanceD.php";
    private Map<String, String> params;
    public AttendanceD(String date,String Garbage,String RollNo10,String RollNo11,String RollNo12, Response.Listener<String> listener) {
        super(Method.POST, CALENDAR_REQUEST_URL, listener, null);
        params= new HashMap<>();
        params.put("Date",date);
        params.put("Garbage",Garbage);
        params.put("RollNo10",RollNo10);
        params.put("RollNo11",RollNo11);
        params.put("RollNo12",RollNo12);

    }
    public Map<String, String> getParams(){
        return params;
    }
}

