package com.example.a14011063;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    //public ArrayList<User> users = new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<User> users = UserList.getList();

        User user1 = new User("Betül","Şinar","05541234567","betulsnr","1111","1111",null,0);

        users.add(user1);

        Button loginButton = findViewById(R.id.loginButton);
        Button signUpButton = findViewById(R.id.signupButton);
        EditText emailAdress = findViewById(R.id.editTextTextEmailAddress);
        EditText password = findViewById(R.id.editTextTextPassword);

        loginButton.setOnClickListener(v -> {

            String email= emailAdress.getText().toString();
            String pass = password.getText().toString();

            if(email.isEmpty()){
                Toast.makeText(this,"Email can not be empty",Toast.LENGTH_SHORT).show();
            }
            if(pass.isEmpty()){
                Toast.makeText(this,"Password can not be empty",Toast.LENGTH_SHORT).show();
            }

            int i=0;
            boolean flag=false;
            while(i<users.size() && flag==false){
                if(users.get(i).userEmail.equals(email)){
                    Log.i("TAG", "Burdayım:");
                    int id =i;
                    if(users.get(i).userPassword.equals(pass) && users.get(i).userCounter!=3){

                        Uri path=users.get(i).userImagePath;
                        //String path2 = path.toString();
                        flag=true;
                        users.get(i).userCounter=0;
                        Toast.makeText(this, "Successfully login :)", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(this, MenuActivity.class);
                        intent.putExtra("username",email);
                        intent.putExtra("userpass",pass);
                        //intent.putExtra("userpath",path2);
                        startActivity(intent);
                    }
                    if(users.get(i).userPassword.equals(pass)==false){
                        flag=true;
                        if(users.get(i).userCounter==2){
                            Log.i("TAG", "Counter Sıfırlandı:" + users.get(i).userCounter);
                            users.get(i).userCounter=0;
                            Toast.makeText(this, "Oh no no noooğ, You are redicted to the Sign up page", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(this, SignUpActivity.class);
                            //intent.putExtra("users",users);
                            startActivity(intent);

                        }
                        else{
                            users.get(i).userCounter++;
                            Log.i("TAG", "Counter:" + users.get(i).userCounter);
                            Toast.makeText(this, users.get(i).userCounter+". wrong password entry", Toast.LENGTH_SHORT).show();
                        }
                    }
                }else{
                    i++;
                    Log.i("TAG", "İ:" + i);
                }
            }
            if(i==users.size()){
                Toast.makeText(this,"User not found..",Toast.LENGTH_LONG).show();
            }
      });

        signUpButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, SignUpActivity.class);
            startActivity(intent);
        });
    }
}