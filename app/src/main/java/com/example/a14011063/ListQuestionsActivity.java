package com.example.a14011063;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class ListQuestionsActivity extends AppCompatActivity {

    RecyclerView.LayoutManager layoutManager;

    RecyclerView recyclerView;
    QuestionsAdapter adapter;
    ArrayList<Question> questions = QuestionList.getQuestions();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_questions);

       if(questions.size() == 0){
           Toast.makeText(this,"Please firstly add some question",Toast.LENGTH_SHORT).show();
       }
       else{
           recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
           layoutManager = new LinearLayoutManager(this);
           recyclerView.setLayoutManager(layoutManager);

           adapter = new QuestionsAdapter(questions, this);
           recyclerView.setAdapter(adapter);
       }
    }
}