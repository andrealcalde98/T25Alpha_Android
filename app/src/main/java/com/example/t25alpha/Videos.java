package com.example.t25alpha;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Videos extends AppCompatActivity {
    VideoView video1, video2, video3, video4, video5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);
        video1 = (VideoView) findViewById(R.id.videoView1);
       /* video2 = (VideoView) findViewById(R.id.videoView2);
        video3 = (VideoView) findViewById(R.id.videoView3);
        video4 = (VideoView) findViewById(R.id.videoView4);
        video5 = (VideoView) findViewById(R.id.videoView5);*/

        Uri uri = Uri.parse("http://techslides.com/demos/sample-videos/small.mp4");
        video1.setMediaController(new MediaController(this));
        video1.setVideoURI(uri);
        video1.requestFocus();
        video1.start();
    }
}
