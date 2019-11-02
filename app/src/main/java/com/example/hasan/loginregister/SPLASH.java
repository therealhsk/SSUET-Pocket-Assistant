package com.example.hasan.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.os.HandlerThread;
import android.support.v7.app.AppCompatActivity;


public class SPLASH extends AppCompatActivity {
    private static int SPLASH_TIME_OUT=4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new android.os.Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent homeIntent=new Intent(SPLASH.this, LoginActivity.class);
                startActivity(homeIntent);
                finish();

            }
        }, SPLASH_TIME_OUT);
    }
}
