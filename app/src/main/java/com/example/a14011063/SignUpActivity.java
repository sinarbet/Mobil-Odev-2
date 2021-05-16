package com.example.a14011063;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import android.content.SharedPreferences;

public class SignUpActivity extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";
    SharedPreferences sharedpreferences;
    Uri URI = null;
    Uri path =null;
    private static final int PICK_FROM_GALLERY = 101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ArrayList<User> users = UserList.getList();

        EditText uName = findViewById(R.id.editTextTextPersonName);
        EditText uSurname = findViewById(R.id.editTextTextPersonName2);
        EditText uPhoneNum = findViewById(R.id.editTextPhone);
        EditText uMail = findViewById(R.id.editTextTextEmailAddress2);
        EditText uPasswd = findViewById(R.id.editTextTextPassword2);
        Button buttonSignUp= findViewById(R.id.buttonSignUp);
        ImageButton addPhotoButton =findViewById(R.id.imageButton);
        ImageView photoView = findViewById(R.id.imageView);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        Intent intent = getIntent();

        addPhotoButton.setOnClickListener(v -> {
            openFolder();
        });

        buttonSignUp.setOnClickListener(v -> {
            String name = uName.getText().toString();
            String surname = uSurname.getText().toString();
            String phoneNum = uPhoneNum.getText().toString();
            String mail = uMail.getText().toString();
            String password = uPasswd.getText().toString();
            String password2 = uPasswd.getText().toString();

            int i=0;
            if(name.isEmpty() || surname.isEmpty() || phoneNum.isEmpty() || mail.isEmpty() || password.isEmpty() || password2.isEmpty()){
                Toast.makeText(this,"Please fill all empty info",Toast.LENGTH_SHORT).show();
            }
            else if(password.compareTo(password2) != 0){
                Toast.makeText(this,"Passwords are incompatible",Toast.LENGTH_SHORT).show();
            }
            else if(phoneNum.length()<15){
                Toast.makeText(this,"Phone number is missing",Toast.LENGTH_SHORT).show();
            }
            else{

                User user = new User(name,surname,phoneNum,mail,password,password2,path,0);
                users.add(user);
                System.out.println("New User: " +users.get(3).userName);

                Toast.makeText(this,"Successfully create account",Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(this, MainActivity.class);
                startActivity(intent2);
            }
        });
    }
    @SuppressLint("MissingSuperCall")
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        ImageView photoView = findViewById(R.id.imageView);
        if (requestCode == PICK_FROM_GALLERY && resultCode == RESULT_OK) {
            URI = data.getData();
            if (URI != null) {
                photoView.setImageURI(URI);
                path = URI;

            }
        }
    }
    public void openFolder() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.putExtra("return-data", true);
        startActivityForResult(Intent.createChooser(intent, "Complete action using"), PICK_FROM_GALLERY);
    }
}