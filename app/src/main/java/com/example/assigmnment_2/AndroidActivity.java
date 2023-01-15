package com.example.assigmnment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class AndroidActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android);

        VideoView videoView = findViewById(R.id.androidVid);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.androidvideo;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        videoView.start();

        MediaController mediaController = new MediaController(this);
        videoView. setMediaController (mediaController);
        mediaController.setAnchorView(videoView);
    }
}