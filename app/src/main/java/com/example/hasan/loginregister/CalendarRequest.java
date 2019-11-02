package com.example.hasan.loginregister;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hasan on 10/20/2017.
 */

public class CalendarRequest extends StringRequest {
    private static final String CALENDAR_REQUEST_URL="http://app-1506792717.000webhostapp.com/Attendance.php";
    private Map<String, String> params;
    public CalendarRequest(String date,String Garbage,String RollNo1,String RollNo2,String RollNo3, Response.Listener<String> listener) {
        super(Method.POST, CALENDAR_REQUEST_URL, listener, null);
        params= new HashMap<>();
        params.put("Date",date);
        params.put("Garbage",Garbage);
        params.put("RollNo1",RollNo1);
        params.put("RollNo2",RollNo2);
        params.put("RollNo3",RollNo3);

    }
    public Map<String, String> getParams(){
        return params;
    }
    }

