package com.example.hasan.loginregister;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hasan on 10/1/2017.
 */

public class RegisterRequest extends StringRequest {
private static final String REGISTER_REQUEST_URL="http://app-1506792717.000webhostapp.com/Register.php";
    private Map<String, String> params;
    public RegisterRequest(String name, String username, String Cname, String password, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params= new HashMap<>();
        params.put("name",name);
        params.put("username",username);
        params.put("Cname",Cname);
        params.put("password",password);

    }
    public Map<String, String> getParams(){
        return params;
    }
}
