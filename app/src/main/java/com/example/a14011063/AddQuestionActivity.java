package com.example.a14011063;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class AddQuestionActivity extends AppCompatActivity {
    private String filename = "savedQuestions.txt";
    ArrayList<Question> questions = QuestionList.getQuestions();
    ArrayList<String> answers=new ArrayList<>();
    Uri URI = null;
    Uri path =null;
    private static final int PICK_FROM_GALLERY = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);

        EditText questionText =findViewById(R.id.questionEditText);
        EditText answerText1 =findViewById(R.id.editTextAnswer1);
        EditText answerText2 =findViewById(R.id.editTextAnswer2);
        EditText answerText3 =findViewById(R.id.editTextAnswer3);
        EditText answerText4 =findViewById(R.id.editTextAnswer4);
        EditText answerText5 =findViewById(R.id.editTextAnswer5);

        Button addButton = findViewById(R.id.buttonAdd);
        ImageButton attachButton =findViewById(R.id.buttonAttach);

        Button A = findViewById(R.id.aButton);
        Button B = findViewById(R.id.bButton);
        Button C = findViewById(R.id.button7);
        Button D = findViewById(R.id.button8);
        Button E = findViewById(R.id.button9);

        ArrayList<Integer> correctAns = new ArrayList<>();
        A.setOnClickListener(v -> {
            correctAns.add(0);
            A.setText("✓");
            B.setText("B");
            C.setText("C");
            D.setText("D");
            E.setText("E");
        });

        B.setOnClickListener(v -> {
            correctAns.clear();
            correctAns.add(1);
            B.setText("✓");
            A.setText("A");
            C.setText("C");
            D.setText("D");
            E.setText("E");
        });

        C.setOnClickListener(v -> {
            correctAns.clear();
            correctAns.add(2);
            C.setText("✓");
            A.setText("A");
            B.setText("B");
            D.setText("D");
            E.setText("E");
        });

        D.setOnClickListener(v -> {
            correctAns.clear();
            correctAns.add(3);
            D.setText("✓");
            A.setText("A");
            B.setText("B");
            C.setText("C");
            E.setText("E");
        });

        E.setOnClickListener(v -> {
            correctAns.clear();
            correctAns.add(4);
            E.setText("✓");
            A.setText("A");
            B.setText("B");
            C.setText("C");
            D.setText("D");
        });

        addButton.setOnClickListener(v -> {
            try
            {
                FileOutputStream fos = openFileOutput(filename, Context.MODE_PRIVATE);
                String quest = questionText.getText().toString();
                answers.add(answerText1.getText().toString());
                answers.add(answerText2.getText().toString());
                answers.add(answerText3.getText().toString());
                answers.add(answerText4.getText().toString());
                answers.add(answerText5.getText().toString());

                fos.write(quest.getBytes());
                if(correctAns.isEmpty()){
                    Toast.makeText(this,"Please select correct option",Toast.LENGTH_SHORT).show();
                }
                else{
                    if (URI != null) {
                        //intent.putExtra(Intent.EXTRA_STREAM, URI);
                        fos.write(URI.getLastPathSegment().getBytes());
                    }
                    path=URI;
                    Question q=new Question(quest,"5",answers, correctAns.get(0),path);
                    questions.add(q);
                    Toast.makeText(this,"Question added,Thanks for contributes You're the KING ;)",Toast.LENGTH_SHORT).show();
                    fos.flush();
                    fos.close();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        });

        attachButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFolder();
            }
        });

    }
    @SuppressLint("MissingSuperCall")
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        ImageView imageAttach = findViewById(R.id.imageViewAttach2);
        if (requestCode == PICK_FROM_GALLERY && resultCode == RESULT_OK) {
            URI = data.getData();
            path=URI;
            imageAttach.setImageURI(URI);
            //seeAttachButton.setVisibility(Button.VISIBLE);
        }
    }
    public void openFolder() {
        Intent intent = new Intent();
        intent.setType("*/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.putExtra("return-data", true);
        startActivityForResult(Intent.createChooser(intent, "Complete action using"), PICK_FROM_GALLERY);
    }

}