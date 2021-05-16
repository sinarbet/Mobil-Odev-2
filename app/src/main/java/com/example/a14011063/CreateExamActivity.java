package com.example.a14011063;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class CreateExamActivity extends AppCompatActivity {
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_exam_home);

        Button goExam = findViewById(R.id.buttonGoExam);
        Button chooseSetting = findViewById(R.id.buttonChooseSettings);

        SharedPreferences sharedpreferences = getSharedPreferences("MySettings", MODE_PRIVATE);

        goExam.setOnClickListener(v -> {

            Intent intent = new Intent(this, DisplayExam.class);
            startActivity(intent);

            // ***** SINAVI PDF OLARAK PAYLAŞ *****

        });

        chooseSetting.setOnClickListener(v -> {

            String duration = sharedpreferences.getString("Exam Duration","");
            String difficulty = sharedpreferences.getString("Difficulty", "");
            String grade = sharedpreferences.getString("Grade", "");

            Intent intent = new Intent(this, ListSettings.class);
            intent.putExtra("Exam Duration",duration);
            intent.putExtra("Difficulty",difficulty);
            intent.putExtra("Grade",grade);
            startActivity(intent);

        });


    }
}