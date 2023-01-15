package com.example.assigmnment_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class QuizActivity extends AppCompatActivity {

    public static final String EXTRA_TEXT = "com.example.intent.EXTRA_TEXT";

    ProgressBar progressBar;
    CountDownTimer countDownTimer;
    int timerValue = 20;
    Button button;
    ArrayList<Question> listOfQ;
    Question question;
    int index = 0;
    TextView card_question, optiona,optionb,optionc,optiond;
    CardView cardqA,cardqB,cardqC,cardqD;
    int correctCount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        init();
        listOfQ = new ArrayList<>();
        listOfQ.add(new Question("Which company developed android?","Apple","Google","Android Inc." ,"Nokia", "Android Inc."));
        listOfQ.add(new Question("Which company bought android?","Apple", "No company","Nokia","Google", "Google"));
        listOfQ.add(new Question( "Android is based on which kernel?", "Linux kernel", "Windows kernel", "MAC kernel" , "Hybrid Kernel", "Linux kernel"));
        listOfQ.add(new Question("What is android?", "Desktop Operating System", "Programming Language", "Mobile Operating System", "Database", "Mobile Operating System"));
        listOfQ.add(new Question("ADB stands for", "Android Debug Bridge", "Application Debug Bridge", "Android data bridge", "Application data bridge", "Android Debug Bridge"));
        listOfQ.add(new Question("What is mean by ANR?", "Application not Recognized", "Android not recognized", "Application Not Responding", "none of these", "Application Not Responding"));

        Collections.shuffle(listOfQ);
        question = listOfQ.get(index);

        Hooks();
        setAllData();

        cardqA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disableButton();
                button.setClickable(true);
                if (question.getqA().equals(question.getAns())){
                    if(index<listOfQ.size() - 1){
                        Correct(cardqA);
                    }else {
                        GameWon();
                    }
                }

                else{
                    Wrong(cardqA);

                }

            }
        });

        cardqB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disableButton();
                button.setClickable(true);
                if (question.getqB().equals(question.getAns())){
                    if(index<listOfQ.size() - 1){
                        Correct(cardqB);
                    }else {
                        GameWon();
                    }
                }
                else{
                    Wrong(cardqB);

                }
            }
        });

        cardqC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disableButton();
                button.setClickable(true);
                if (question.getqC().equals(question.getAns())){
                    if(index<listOfQ.size() - 1){
                        Correct(cardqC);
                    }else {
                        GameWon();
                    }
                }

                else{
                    Wrong(cardqC);
                }
            }
        });

        cardqD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                disableButton();
                button.setClickable(true);

                if (question.getqD().equals(question.getAns())){

                    if(index<listOfQ.size() - 1){
                        Correct(cardqD);
                    }else {
                        GameWon();
                    }
                }
                else{
                    Wrong(cardqD);
                }
            }
        });
    }

    public void Back(View view) {
        Intent intentBackButton = new Intent(QuizActivity.this, DashboardActivity.class);
        startActivity(intentBackButton);
    }

    private void disableButton() {
        cardqA.setClickable(false);
        cardqB.setClickable(false);
        cardqC.setClickable(false);
        cardqD.setClickable(false);
    }

    private void enableButton() {
        cardqA.setClickable(true);
        cardqB.setClickable(true);
        cardqC.setClickable(true);
        cardqD.setClickable(true);
    }



    private void Wrong(CardView card) {
//        card.setCardBackgroundColor(getResources().getColor(R.color.red));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                correctCount--;
                if(index<listOfQ.size()-1){
                    index++;
                    question = listOfQ.get(index);

                    setAllData();
                    enableButton();
//                    resetColor();
                }else {
                    GameWon();
                }
            }
        });
    }

    private void GameWon() {
        Intent intent = new Intent(QuizActivity.this, WonActivity.class);
        String text = String.valueOf(correctCount);
        intent.putExtra(EXTRA_TEXT, text);
        startActivity(intent);
    }

    private void Correct(CardView card) {
//         card.setCardBackgroundColor(getResources().getColor(R.color.green));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                correctCount++;
                index++;
                question = listOfQ.get(index);
//                resetColor();
                setAllData();
                enableButton();

            }
        });


    }

    private void setAllData() {
        card_question.setText(question.getQuestion());
        optiona.setText(question.getqA());
        optionb.setText(question.getqB());
        optionc.setText(question.getqC());
        optiond.setText(question.getqD());

        cardqA = findViewById(R.id.cardA);
        cardqB = findViewById(R.id.cardB);
        cardqC = findViewById(R.id.cardC);
        cardqD = findViewById(R.id.cardD);
    }

    private void Hooks() {
        card_question = findViewById(R.id.question_card);
        optiona = findViewById(R.id.question_option1);
        optionb = findViewById(R.id.question_option2);
        optionc = findViewById(R.id.question_option3);
        optiond = findViewById(R.id.question_option4);

        button = findViewById(R.id.next_btn);


    }



    private void init() {
        progressBar = findViewById(R.id.progress_timer);
        button = findViewById(R.id.next_btn);


        countDownTimer = new CountDownTimer(20000,1000) {
            @Override
            public void onTick(long l) {
                timerValue = timerValue -1;
                progressBar.setProgress(timerValue);
            }

            @Override
            public void onFinish() {
                Dialog dialog = new Dialog(QuizActivity.this);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(R.layout.dialog_screen);
                disableButton();
                dialog.show();



                dialog.findViewById(R.id.btn_try_again).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(QuizActivity.this,QuizLoadupActivity.class);
                    }
                });

            }
        }.start();
    }
}