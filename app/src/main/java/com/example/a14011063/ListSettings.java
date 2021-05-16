package com.example.a14011063;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class ListSettings extends AppCompatActivity {


    RecyclerView.LayoutManager layoutManager;

    RecyclerView recyclerView;
    SettingAdapter adapter;
    ArrayList<Setting> settings = SettingList.getSettings();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_settings);

        Intent intent = getIntent();

        String duration = intent.getStringExtra("Exam Duration");

        String difficulty = intent.getStringExtra("Difficulty");

        String grade = intent.getStringExtra("Grade");

        Setting s =new Setting(duration,difficulty,grade);

        settings.add(s);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView2);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new SettingAdapter(settings,this);
        recyclerView.setAdapter(adapter);

    }
}