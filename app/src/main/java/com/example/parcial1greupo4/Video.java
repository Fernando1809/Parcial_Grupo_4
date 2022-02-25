package com.example.parcial1greupo4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class Video extends AppCompatActivity {

//CREAMOS UNA VARIABLE DE TIPO ENTERO
    private final int PICKER=1;
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        //relacionamos las variables con los botones
        setContentView(R.layout.activity_video);
        videoView = (VideoView)findViewById(R.id.videoView);
        String path = "android.resource://"+ getPackageName() + "/" + R.raw.video;
        videoView.setVideoURI(Uri.parse(path));
        videoView.start();

        Button Inicio =(Button) findViewById(R.id.btVolver);
        Inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Inicio = new Intent(Video.this, MainActivity.class);
                startActivity(Inicio);
            }
        });

    }
}