package com.example.a14011063;

import java.util.ArrayList;

public class ExamQuestion {
    String question;
    ArrayList<String> answers;
    int choiceNum;
    String correctAnswer;
    String grade;

    public ExamQuestion(String question,int choiceNum,ArrayList<String> answers,String correctAnswer){
        this.question=question;
        this.choiceNum=choiceNum;
        this.answers=answers;
        this.correctAnswer=correctAnswer;
    }
}
