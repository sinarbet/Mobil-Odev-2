package com.example.a14011063;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Button buttonUpdate = findViewById(R.id.buttonHeader);
        EditText question = findViewById(R.id.editTextDetailQuestion);
        EditText ans1 = findViewById(R.id.editTextDetailAnswer1);
        EditText ans2 = findViewById(R.id.editTextDetailAnswer2);
        EditText ans3 = findViewById(R.id.editTextDetailAnswer3);
        EditText ans4 = findViewById(R.id.editTextTextPersonName4);
        EditText ans5 = findViewById(R.id.editTextTextPersonName5);

        Intent intent = getIntent();

        String q = intent.getStringExtra("Question");
        String a1 = intent.getStringExtra("Answer1");
        String a2 = intent.getStringExtra("Answer2");
        String a3 = intent.getStringExtra("Answer3");
        String a4 = intent.getStringExtra("Answer4");
        String a5 = intent.getStringExtra("Answer5");

        question.setText(q);
        ans1.setText(a1);
        ans2.setText(a2);
        ans3.setText(a3);
        ans4.setText(a4);
        ans5.setText(a5);
    }
}