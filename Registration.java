package com.example.prasad.myapp;

import java.io.*;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Registration extends AppCompatActivity implements View.OnClickListener {

    private EditText name, email, mobile, passwrd;
    private Button regist;
    private TextView already;

    Validation validation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        mobile = findViewById(R.id.mobile);
        passwrd = findViewById(R.id.passwrd);


        validation = new Validation();

        regist = findViewById(R.id.regist);
        regist.setOnClickListener(this);

        already = findViewById(R.id.already);
        already.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v == already) {
            Intent in = new Intent(Registration.this, Login.class);
            startActivity(in);
        }
        if (v == regist) {
            if (submitForm()) {
                signUp();

            }
        }


    }


    private boolean submitForm() {
        String sname = name.getText().toString();
        if (!validation.isNameValid(sname)) {
            name.setError("Enter valid Name");
            name.requestFocus();
            return false;
        }
        String semail = email.getText().toString();
        if (!validation.isEmailValid(semail)) {
            email.setError("Enter valid Email");
            email.requestFocus();
            return false;
        }

        String smob = mobile.getText().toString();
        if (!validation.isMobileValid(smob)) {
            mobile.setError("Enter valid Mobile Number");
            mobile.requestFocus();
            return false;

        }

        String spass = passwrd.getText().toString();
        if (!validation.isPasswordValid(spass)) {
            passwrd.setError("Password should have more that six characters");
            passwrd.requestFocus();
            return false;
        }
        return true;
    }


    private void signUp() {
        String sname=name.getText().toString();
        String semail=email.getText().toString();
        String smobile=mobile.getText().toString();
        String spswd=passwrd.getText().toString();

        ApiInterface apiService =ApiClient.getClient().create(ApiInterface.class);


        /*Call<SignUpRes> call= apiService.doRegistration(sname,semail,smobile,spswd);
        call.enqueue(new Callback<SignUpRes>() {
            @Override
            public void onResponse(Call<SignUpRes> call, Response<SignUpRes> response) {
                if (response.isSuccessful()){
                    SignUpRes sign= response.body();
                    String message=sign.getMessage();
                    Toast.makeText(Registration.this, message, Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(Registration.this, Login.class);
                    startActivity(in);
                }
                else{

                }
            }

            @Override
            public void onFailure(Call<SignUpRes> call, Throwable t) {
                Toast.makeText(Registration.this, "Something went wrong!", Toast.LENGTH_SHORT).show();

            }
        });*/

        Call<SignUpRes> signUpResCall=apiService.doLogin(semail,spswd);
        signUpResCall.enqueue(new Callback<SignUpRes>() {
            @Override
            public void onResponse(Call<SignUpRes> call, Response<SignUpRes> response) {
                Toast.makeText(Registration.this, "success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<SignUpRes> call, Throwable t) {
                Toast.makeText(Registration.this, "fail", Toast.LENGTH_SHORT).show();

            }
        });
    }

}

