package com.example.assigmnment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WonActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_won);

        TextView textView = findViewById(R.id.result);
        Intent intent = getIntent();
        String text = intent.getStringExtra(QuizActivity.EXTRA_TEXT);
        textView.setText(text + "/6");

        Button button = findViewById(R.id.submit);
        EditText editFile = findViewById(R.id.File);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileOutputStream fileOutput;

                String file= editFile.getText().toString();

                try{
                    fileOutput = openFileOutput(file, Context.MODE_PRIVATE);
                    fileOutput.write(text.getBytes());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(WonActivity.this, "Submitted to File", Toast.LENGTH_SHORT).show();
            }
        });


    }
}