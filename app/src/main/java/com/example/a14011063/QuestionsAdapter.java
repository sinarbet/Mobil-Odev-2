package com.example.a14011063;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionsAdapter.MyViewHolder>{

    ArrayList<Question> questions;
    LayoutInflater inflater;
    Context context;

    public QuestionsAdapter(ArrayList<Question> questions, Context context) {
        this.questions = questions;
        this.inflater = LayoutInflater.from(context);
        this.context=context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.question_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Question selectedPerson=questions.get(position);

        holder.question.setText(position+1 +"-)"+selectedPerson.question);
        holder.answers.setText("A-)"+selectedPerson.answers.get(0)+"\nB-)"+selectedPerson.answers.get(1)+"\nC-)"+selectedPerson.answers.get(2)+"\nD-)"+selectedPerson.answers.get(3)+"\nE-)"+selectedPerson.answers.get(4)+"\nCorrect Answer:"+selectedPerson.correctAnswer);
        holder.satirCard.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("Question",selectedPerson.question);
            intent.putExtra("Answer1",selectedPerson.answers.get(0));
            intent.putExtra("Answer2",selectedPerson.answers.get(1));
            intent.putExtra("Answer3",selectedPerson.answers.get(2));
            intent.putExtra("Answer4",selectedPerson.answers.get(3));
            intent.putExtra("Answer5",selectedPerson.answers.get(4));
            context.startActivity(intent);
        });

        holder.ButtonDelete.setOnClickListener(v -> {
            questions.remove(selectedPerson);
            Intent intent = new Intent(context, ListQuestionsActivity.class);
            context.startActivity(intent);

        });
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView question;
        TextView answers;
        ImageView ButtonDelete;
        CardView satirCard;
        ImageView attach;

        public MyViewHolder(View itemView) {
            super(itemView);
            question = (TextView) itemView.findViewById(R.id.textQuestion);
            answers = (TextView) itemView.findViewById(R.id.textAnswers);
            satirCard = (CardView) itemView.findViewById(R.id.satir_card);
            ButtonDelete = (ImageView) itemView.findViewById(R.id.ButtonDelete);
            attach =(ImageView) itemView.findViewById(R.id.imageView2);
        }


    }
}

