package com.example.prasad.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Profile extends AppCompatActivity implements View.OnClickListener{

    private TextView name,email,mob;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        name=findViewById(R.id.tv_name);
        email=findViewById(R.id.tv_email);
        mob=findViewById(R.id.tv_phone);
        logout=findViewById(R.id.logout);
        logout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==logout){
            Intent in=new Intent(Profile.this,Login.class);
            startActivity(in);
        }
    }
}
