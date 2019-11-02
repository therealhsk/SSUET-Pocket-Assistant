package com.example.hasan.loginregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.hasan.loginregister.R.id.tvWelcomemsg;

public class UserAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        final TextView welcomeMessage= (TextView) findViewById(tvWelcomemsg);
        final Button Continue=(Button) findViewById(R.id.etContinue);

        Intent intent=getIntent();
        String name=intent.getStringExtra("name");

        String message="Welcome to Attendance Register"+" "+name;
        welcomeMessage.setText(message);

        Continue.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                Intent Continueintent = new Intent(UserAreaActivity.this, PickingD.class);
                UserAreaActivity.this.startActivity(Continueintent);
            }
        });

    }
}
