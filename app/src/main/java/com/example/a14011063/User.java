package com.example.a14011063;

import android.net.Uri;

import java.util.ArrayList;

public class User {

    String userName;
    String userSurname;
    String userPhoneNumber;
    String userEmail;
    String userPassword;
    String userPassword2;
    Uri userImagePath;
    int userCounter;

    public User(String name,String surname,String phoneNumber,String email,String password,String password2,Uri path,int counter){
        userName=name;
        userSurname=surname;
        userPhoneNumber=phoneNumber;
        userEmail = email;
        userPassword = password;
        userPassword2 = password2;
        userImagePath = path;
        userCounter = counter;
    }
}
