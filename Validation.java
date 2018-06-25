package com.example.prasad.myapp;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    public boolean isNameValid(String name){
       if (name!=null && name.length()!=0 && name.matches("[a-zA-Z ]+")){
           return true;
       }
       return false;

    }

    public boolean isEmailValid(String email){

        String Expn =

                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"

                        +"((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"

                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."

                        +"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"

                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"

                        +"([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";
        Pattern pattern=Pattern.compile(Expn);
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

    public boolean isMobileValid(String mob){
        if (mob.length()!=10)
            return false;
        return true;

    }

    public boolean isPasswordValid(String pass){
        if (pass.length()< 6)
            return false;
        return true;
    }
}
