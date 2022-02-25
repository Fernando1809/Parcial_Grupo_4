package com.example.parcial1greupo4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Music extends AppCompatActivity {
    Button play_pause, btn_repetir;
    MediaPlayer mp;
    ImageView iv;

    int repetir = 2, posicion = 0;

    MediaPlayer vectormp [] = new MediaPlayer[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        //programar boton siguiente

        Button sigue=(Button)findViewById(R.id.btnRvideo);
        sigue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sigue= new Intent(Music.this,Video.class);
                startActivity(sigue);
            }
        });

        play_pause = (Button)findViewById(R.id.btn_play);
        btn_repetir = (Button)findViewById(R.id.btn_repetir);
        iv = (ImageView)findViewById(R.id.imageView);

        vectormp[0] = MediaPlayer.create(this,R.raw.race);
        vectormp[1] = MediaPlayer.create(this,R.raw.sound);
        vectormp[2] = MediaPlayer.create(this,R.raw.tea);

    }
    public void PLayPause(View view){
        if(vectormp[posicion].isPlaying()){
            vectormp[posicion].pause();
            play_pause.setBackgroundResource(R.drawable.reproducir);
            Toast.makeText(this,"Pausa", Toast.LENGTH_SHORT).show();
        }else {
            vectormp[posicion].start();
            play_pause.setBackgroundResource(R.drawable.pausa);
            Toast.makeText(this,"Play",Toast.LENGTH_SHORT).show();
        }
    }
    public void Stop(View view){
        if(vectormp[posicion] != null){
            vectormp[posicion].stop();
            vectormp[0] = MediaPlayer.create(this,R.raw.race);
            vectormp[1] = MediaPlayer.create(this,R.raw.sound);
            vectormp[2] = MediaPlayer.create(this,R.raw.tea);
            posicion = 0;
            play_pause.setBackgroundResource(R.drawable.reproducir);
            iv.setImageResource(R.drawable.portada1);
            Toast.makeText(this,"Stop",Toast.LENGTH_SHORT).show();
        }
    }
    public void Repetir(View view){
        if(repetir == 1) {
            btn_repetir.setBackgroundResource(R.drawable.no_repetir);
            Toast.makeText(this, "No repetir",Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping((false));
            repetir = 2;
        }
        else{
            btn_repetir.setBackgroundResource(R.drawable.repetir);
            Toast.makeText(this, "Repetir",Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping((true));
            repetir = 1;
        }
    }
    public void Siguiente(View view){
        if(posicion < vectormp.length -1){
            if(vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                posicion++;
                vectormp[posicion].start();
                if(posicion == 0){
                    iv.setImageResource(R.drawable.portada1);
                }
                else if (posicion == 1){
                    iv.setImageResource(R.drawable.portada2);
                }
                else if (posicion == 2){
                    iv.setImageResource(R.drawable.portada3);
                }
            }
            else{
                posicion++;
                if(posicion == 0){
                    iv.setImageResource(R.drawable.portada1);
                }else if (posicion == 1){
                    iv.setImageResource(R.drawable.portada2);
                }else if (posicion == 2){
                    iv.setImageResource(R.drawable.portada3);
                }
            }
        }
        else {
            Toast.makeText(this,"No hay más canciones",Toast.LENGTH_SHORT).show();
        }
    }
    public void Anterior(View view){
        if(posicion >= 1) {
            if(vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                vectormp[0] = MediaPlayer.create(this,R.raw.race);
                vectormp[1] = MediaPlayer.create(this,R.raw.sound);
                vectormp[2] = MediaPlayer.create(this,R.raw.tea);
                posicion--;
                if(posicion == 0){
                    iv.setImageResource(R.drawable.portada1);
                }else if (posicion == 1){
                    iv.setImageResource(R.drawable.portada2);
                }else if (posicion == 2){
                    iv.setImageResource(R.drawable.portada3);
                }
                vectormp[posicion].start();
            }else {
                posicion--;
                if(posicion == 0){
                    iv.setImageResource(R.drawable.portada1);
                }else if (posicion == 1){
                    iv.setImageResource(R.drawable.portada2);
                }else if (posicion == 2){
                    iv.setImageResource(R.drawable.portada3);
                }
            }
        }
        else{
            Toast.makeText(this,"No hay más canciones",Toast.LENGTH_SHORT).show();
        }

    }
}

