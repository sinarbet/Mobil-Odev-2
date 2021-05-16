package com.example.a14011063;

import android.net.Uri;

import java.util.ArrayList;

public class Question {

    String question;
    ArrayList<String> answers;
    String choiceNum;
    int correctAnswer;
    Uri attachPath;

    public Question(String question,String choiceNum,ArrayList<String> answers,int correctAnswer,Uri attachPath){
        this.question=question;
        this.choiceNum=choiceNum;
        this.answers=answers;
        this.correctAnswer=correctAnswer;
        this.attachPath=attachPath;
    }
}
