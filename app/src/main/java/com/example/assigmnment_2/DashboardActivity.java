package com.example.assigmnment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);



    }

    public void Android(View view) {
        Intent intentAndroid = new Intent(new Intent(DashboardActivity.this,AndroidActivity.class));
        startActivity(intentAndroid);
    }

    public void Gui(View view) {
        Intent intentGui = new Intent(new Intent(DashboardActivity.this,GuiComponentsActivity.class));
        startActivity(intentGui);
    }

    public void Quiz(View view) {
        Intent intentQuiz = new Intent(new Intent(DashboardActivity.this,QuizLoadupActivity.class));
        startActivity(intentQuiz);
    }

    public void Paper1(View view) {
        Intent intentPaper1 = new Intent(new Intent(DashboardActivity.this,Paper1Activity.class));
        startActivity(intentPaper1);
    }

    public void Paper2(View view) {
        Intent intentPaper2 = new Intent(new Intent(DashboardActivity.this,Paper2Activity.class));
        startActivity(intentPaper2);
    }

    public void Feature(View view) {
        Intent intentFeature = new Intent(new Intent(DashboardActivity.this,ExtraFeatureActivity.class));
        startActivity(intentFeature);
    }
}