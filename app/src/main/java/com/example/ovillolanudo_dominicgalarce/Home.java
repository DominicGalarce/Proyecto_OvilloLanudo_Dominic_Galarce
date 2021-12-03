package com.example.ovillolanudo_dominicgalarce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class Home extends AppCompatActivity {
    VideoView videoview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        VideoView videoView = findViewById(R.id.videoView);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.chayanne;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
    }

    public void informacion(View view){
        Intent i = new Intent(getBaseContext(), Informacion.class);
        startActivity(i);
    }

    public void insumos(View view){
        Intent i = new Intent(getBaseContext(), Insumos.class);
        startActivity(i);
    }

    public void agendar(View view){
        Intent i = new Intent(getBaseContext(), Agendar.class);
        startActivity(i);
    }
}