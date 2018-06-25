package com.example.prasad.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity implements View.OnClickListener{

    private EditText email, passwrd;
    private Button login;
    private TextView newuser;

    Validation validation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        validation=new Validation();

        email=findViewById(R.id.email);
        passwrd=findViewById(R.id.passwrd);

        login=findViewById(R.id.login);
        login.setOnClickListener(this);

        newuser=findViewById(R.id.newuser);
        newuser.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v==newuser){
            Intent in=new Intent(Login.this,Registration.class);
            startActivity(in);
        }
        if(v==login)
        {
            if (submitForm()){
            Intent in=new Intent(Login.this,Profile.class);
            startActivity(in);
            }
        }
    }

    private boolean submitForm(){
        String semail=email.getText().toString();
        if(!validation.isEmailValid(semail)) {
            email.requestFocus();
            email.setError("Invalid Email");
            return false;
        }

        String spass=passwrd.getText().toString();
        if (!validation.isPasswordValid(spass)){
            passwrd.setError("Incorrect password");
            passwrd.requestFocus();
            return false;
        }

        return true;

    }
}
