package com.example.a14011063;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class DisplayExam extends AppCompatActivity {
    RecyclerView.LayoutManager layoutManager;

    RecyclerView recyclerView;
    ExamAdapter adapter;
    ArrayList<Question> examQuestions = QuestionList.getQuestions();
    int y=examQuestions.size();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_exam);

        Intent intent = getIntent();
        String diff = intent.getStringExtra("Difficulty");

        int i=0;
        while(i< examQuestions.size()){
            examQuestions.get(i).choiceNum=diff;
            i++;
        }
        recyclerView = (RecyclerView) findViewById(R.id.rvExam);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ExamAdapter(examQuestions, this);
        recyclerView.setAdapter(adapter);

    }
}