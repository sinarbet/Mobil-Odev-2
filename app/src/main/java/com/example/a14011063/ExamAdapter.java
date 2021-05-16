package com.example.a14011063;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class ExamAdapter extends RecyclerView.Adapter<ExamAdapter.MyViewHolder> {

    ArrayList<Question> examQuestions;
    LayoutInflater inflater;
    Context context;

    public ExamAdapter(ArrayList<Question> examQuestions,Context context){
        this.examQuestions=examQuestions;
        this.inflater=LayoutInflater.from(context);
        this.context=context;
    }
    @NonNull
    @Override
    public ExamAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_exam, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExamAdapter.MyViewHolder holder, int position) {
        Question selected=examQuestions.get(position);
        Random rand = new Random();
        int question_num =Integer.parseInt(selected.choiceNum);
        holder.exam_question.setText(position+1+"-)"+selected.question);
        int i=0;
        holder.exam_answers.setText("Answers:");

        ArrayList<Integer> values = new ArrayList<>();
        values.add(selected.correctAnswer);

        while(values.size() != question_num){
            int int_random = rand.nextInt(5);
            if(int_random==selected.correctAnswer || values.contains(int_random)){
                int_random = rand.nextInt(5);
            }
            else {
                values.add(int_random);
            }
        }
        Collections.shuffle(values);

        while(i<question_num) {
            holder.exam_answers.setText(holder.exam_answers.getText()+"\n"+selected.answers.get(values.get(i)));
            i++;
        }
        //holder.answers.setText("Correct Answer:"+selectedPerson.correctAnswer);

        holder.exam_grade.setText(selected.choiceNum + " Point");

        //String a= selected.attachPath.toString();

        holder.examAttach.setImageURI(selected.attachPath);

        holder.ButtonDeleteExam.setOnClickListener(v -> {
            //questions.remove(position);
        });

    }

    @Override
    public int getItemCount() {
        return examQuestions.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView exam_question;
        TextView exam_answers;
        TextView exam_grade;
        ImageView ButtonDeleteExam;
        CardView satirCardExam;
        ImageView examAttach;


        public MyViewHolder(View itemView) {
            super(itemView);
            exam_question = (TextView) itemView.findViewById(R.id.textExamQuestion);
            exam_answers = (TextView) itemView.findViewById(R.id.textExamAnswers);
            exam_grade = (TextView) itemView.findViewById(R.id.Grade);
            satirCardExam = (CardView) itemView.findViewById(R.id.satir_card_exam);
            ButtonDeleteExam = (ImageView) itemView.findViewById(R.id.ButtonDelete);
            examAttach = (ImageView) itemView.findViewById(R.id.imageViewAttach);
        }
    }
}
