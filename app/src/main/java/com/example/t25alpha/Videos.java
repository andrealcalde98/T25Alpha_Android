package com.example.t25alpha;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class Videos extends AppCompatActivity {
    VideoView video1, video2, video3, video4, video5;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);
        video1 = (VideoView) findViewById(R.id.videoView1);
        video3 = (VideoView) findViewById(R.id.videoView3);
        video4 = (VideoView) findViewById(R.id.videoView4);
        video5 = (VideoView) findViewById(R.id.videoView5);

        String path = ("android.resource://" + getPackageName() +
                "/" + R.id.);
        Uri uri = Uri.parse(video);
        video1.setVideoURI(path);
        MediaController media = new MediaController(this);
        video1.setMediaController(media);
        media.setAnchorView(video1);


    }




        /*video1.requestFocus();
        video1.start();*/


    }
}