package com.example.parcial1greupo4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        //declaramos los edic tex que utilizaremos
        //codigo para ingresar datos de activity
        final EditText eNombre=(EditText) findViewById(R.id.tvNombre);
        final EditText eEdad=(EditText) findViewById(R.id.tvEdad);
        final EditText eId =(EditText)findViewById(R.id.tvID);
        Button bEnviar=(Button) findViewById(R.id.btEnviar);
        //Procedimiento para enviar datos a otra activity
        bEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = eNombre.getText().toString();
                String edad = eEdad.getText() .toString();
                String id= eId.getText().toString();
                Bundle pasarDatos = new Bundle();
                pasarDatos.putString("pNombre",nombre);
                pasarDatos.putString("pEdad",edad);
                pasarDatos.putString("pId",id);
                Intent siga = new Intent(Registro.this, Resultados.class);
                siga.putExtras(pasarDatos);
                startActivity(siga);
            }
        });
    }
}