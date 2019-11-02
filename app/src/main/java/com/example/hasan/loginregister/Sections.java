package com.example.hasan.loginregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Sections extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sections);

        tv=(TextView) findViewById(R.id.textView4);
        tv.setText(getIntent().getStringExtra("DATE"));
        final Button SectionA=(Button) findViewById(R.id.bSecA);
        final Button SectionB=(Button) findViewById(R.id.bSecB);
        final Button SectionC=(Button) findViewById(R.id.bSecC);
        final Button SectionD=(Button) findViewById(R.id.bSecD);

        SectionA.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                String datevalue= tv.getText().toString();
                Intent Aintent = new Intent(Sections.this, SectionA.class);
                Aintent.putExtra("DATE",datevalue);
                Sections.this.startActivity(Aintent);
            }
        });
        SectionB.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                String datevalue= tv.getText().toString();
                Intent Bintent = new Intent(Sections.this, SectionB.class);
                Bintent.putExtra("DATE",datevalue);
                Sections.this.startActivity(Bintent);
            }
        });

        SectionC.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                String datevalue= tv.getText().toString();
                Intent Cintent = new Intent(Sections.this, SectionC.class);
                Cintent.putExtra("DATE",datevalue);
                Sections.this.startActivity(Cintent);
            }
        });
        SectionD.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                String datevalue= tv.getText().toString();
                Intent Dintent = new Intent(Sections.this, SectionD.class);
                Dintent.putExtra("DATE",datevalue);
                Sections.this.startActivity(Dintent);
            }
        });

    }
}
