package com.example.assigmnment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Paper1Activity extends AppCompatActivity {

    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paper1);

        pdfView = findViewById(R.id.pdfView);

        pdfView.fromAsset("12-14.pdf").load();
    }
}