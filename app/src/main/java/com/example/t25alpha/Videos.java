package com.example.t25alpha;

import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class Videos extends AppCompatActivity {
    VideoView video1, video2, video3, video4, video5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);
        video1 = (VideoView) findViewById(R.id.videoView1);
        video2 = (VideoView) findViewById(R.id.videoView2);
        video3 = (VideoView) findViewById(R.id.videoView3);
        video4 = (VideoView) findViewById(R.id.videoView4);
        video5 = (VideoView) findViewById(R.id.videoView5);

        video1();
        video2();
        video3();
        video4();
        video5();

    }

    protected void onStop() {
        super.onStop();

        // Media playback takes a lot of resources, so everything should be
        // stopped and released at this time.
        releasePlayer();
    }
    private void releasePlayer() {
        video1.stopPlayback();
        video2.stopPlayback();
        video3.stopPlayback();
        video4.stopPlayback();
        video5.stopPlayback();

    }

    protected void onPause() {
        super.onPause();

        // In Android versions less than N (7.0, API 24), onPause() is the
        // end of the visual lifecycle of the app.  Pausing the video here
        // prevents the sound from continuing to play even after the app
        // disappears.
        //
        // This is not a problem for more recent versions of Android because
        // onStop() is now the end of the visual lifecycle, and that is where
        // most of the app teardown should take place.
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            video1.pause();
            video2.pause();
            video3.pause();
            video4.pause();
            video5.pause();

        }}

    public void video1(){
        String path = ("android.resource://" + getPackageName() +
                "/" + R.raw.potmano);
        Uri uri = Uri.parse(path);
        video1.setVideoURI(uri);
        MediaController media = new MediaController(this);
        video1.setMediaController(media);
        media.setAnchorView(video1);
    }

    public void video2(){
        String path = ("android.resource://" + getPackageName() +
                "/" + R.raw.extension);
        Uri uri = Uri.parse(path);
        video2.setVideoURI(uri);
        MediaController media = new MediaController(this);
        video2.setMediaController(media);
        media.setAnchorView(video2);
    }

    public void video3(){
        String path = ("android.resource://" + getPackageName() +
                "/" + R.raw.lateral);
        Uri uri = Uri.parse(path);
        video3.setVideoURI(uri);
        MediaController media = new MediaController(this);
        video3.setMediaController(media);
        media.setAnchorView(video3);
    }

    public void video4(){
        String path = ("android.resource://" + getPackageName() +
                "/" + R.raw.flexotension);
        Uri uri = Uri.parse(path);
        video4.setVideoURI(uri);
        MediaController media = new MediaController(this);
        video4.setMediaController(media);
        media.setAnchorView(video4);
    }

    public void video5(){
        String path = ("android.resource://" + getPackageName() +
                "/" + R.raw.pronosupinacion);
        Uri uri = Uri.parse(path);
        video5.setVideoURI(uri);
        MediaController media = new MediaController(this);
        video5.setMediaController(media);
        media.setAnchorView(video5);
    }

        /*video1.requestFocus();
        video1.start();*/

}