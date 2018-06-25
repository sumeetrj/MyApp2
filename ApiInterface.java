package com.example.prasad.myapp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("/myprojects/project1/Webservices/registration.php")
    Call<SignUpRes> doRegistration(@Field("Name")String sname,
                                   @Field("Email") String semail,
                                   @Field("Mobile") String smobile,
                                   @Field("Password") String spswd);


    @FormUrlEncoded
    @POST("/myprojects/project1/Webservices/login.php")
    Call<SignUpRes> doLogin(@Field("email")String semail, @Field("password")String spswd);
}
