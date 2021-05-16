package com.example.a14011063;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent intent = getIntent();

        String mail = intent.getStringExtra("username");

        TextView textView = findViewById(R.id.textView);
        ImageView userImage = findViewById(R.id.userImage);
        textView.setText("Welcome," +mail);

        Button buttonAddQuestion = findViewById(R.id.button2);
        Button buttonListQuestions = findViewById(R.id.button3);
        Button buttonCreateExam = findViewById(R.id.button4);
        Button buttonSettings = findViewById(R.id.button5);

        SharedPreferences sharedpreferences = getSharedPreferences("MySettings", MODE_PRIVATE);

        buttonAddQuestion.setOnClickListener(v -> {
            Intent intent2 = new Intent(this, AddQuestionActivity.class);
            startActivity(intent2);
        });

        buttonListQuestions.setOnClickListener(v -> {
            Intent intent2 = new Intent(this, ListQuestionsActivity.class);
            startActivity(intent2);
        });

        buttonCreateExam.setOnClickListener(v -> {
            String duration = sharedpreferences.getString("Exam Duration","");
            String difficulty = sharedpreferences.getString("Difficulty", "");
            String grade = sharedpreferences.getString("Grade", "");

            Intent intent2 = new Intent(this, ListSettings.class);
            intent2.putExtra("Exam Duration",duration);
            intent2.putExtra("Difficulty",difficulty);
            intent2.putExtra("Grade",grade);
            startActivity(intent2);
        });
        buttonSettings.setOnClickListener(v -> {
            Intent intent2 = new Intent(this, SettingsActivity.class);
            startActivity(intent2);
        });
    }
}