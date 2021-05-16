package com.example.a14011063;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SettingAdapter extends RecyclerView.Adapter<SettingAdapter.MyViewHolder>{
    ArrayList<Setting> settings;
    LayoutInflater inflater;
    Context context;
    public SettingAdapter(ArrayList<Setting> settings, Context context) {
        this.settings = settings;
        this.inflater = LayoutInflater.from(context);
        this.context=context;
    }

    @NonNull
    @Override
    public SettingAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_list_setting, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SettingAdapter.MyViewHolder holder, int position) {
        Setting selected=settings.get(position);


        holder.examDuration.setText("Exam Duration: "+selected.duration+"min");
        holder.examDifficulty.setText("Difficulty: "+selected.difficulty);
        holder.questionGrade.setText("Question Grade: "+selected.grade);

        holder.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(context, SettingsActivity.class);
            context.startActivity(intent);
        });

        holder.buttonUse.setOnClickListener(v -> {
            //if(selected.difficulty.equals("2") || selected.equals("3") || selected.equals("4") || selected.equals("5")) {
            Intent intent2 = new Intent(context, DisplayExam.class);
            intent2.putExtra("Difficulty", selected.difficulty);
            System.out.println(selected.difficulty);
            context.startActivity(intent2);
            //}
            /*else{
                Toast.makeText(context,"Firstly you save the setting from setting page.",Toast.LENGTH_SHORT).show();
            }*/
        });

    }

    @Override
    public int getItemCount() {
        return settings.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView examDuration;
        TextView examDifficulty;
        TextView questionGrade;
        CardView cardView;
        Button buttonUse;

        public MyViewHolder(View itemView) {
            super(itemView);
            examDuration = (TextView) itemView.findViewById(R.id.textViewDuration);
            examDifficulty = (TextView) itemView.findViewById(R.id.textViewDifficulty);
            questionGrade = (TextView) itemView.findViewById(R.id.textViewGrade);
            cardView = (CardView) itemView.findViewById(R.id.cardSetting);
            buttonUse =(Button) itemView.findViewById(R.id.buttonUse);
        }

    }
}
