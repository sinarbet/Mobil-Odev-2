package com.example.a14011063;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.content.SharedPreferences;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    public static final String MyPREFERENCES = "MySettings";
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        EditText textExamDuration = findViewById(R.id.editTextExamDuration);
        EditText textDifficulty = findViewById(R.id.editTextDifficulty);
        EditText textGrade = findViewById(R.id.editTextQuestionGrade);
        Button buttonSave = findViewById(R.id.buttonSave);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        buttonSave.setOnClickListener(v -> {
            String examDuration = textExamDuration.getText().toString();
            String difficulty = textDifficulty.getText().toString();
            String grade = textGrade.getText().toString();

            Toast.makeText(this,"Successfully saved",Toast.LENGTH_SHORT).show();

            SharedPreferences.Editor editor = sharedpreferences.edit();

            editor.putString("Exam Duration", examDuration);
            editor.putString("Difficulty", difficulty);
            editor.putString("Grade", grade);
            editor.commit();

            textDifficulty.setText("");
            textExamDuration.setText("");
            textGrade.setText("");

        });
    }
}