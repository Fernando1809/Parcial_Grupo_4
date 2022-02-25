package com.example.parcial1greupo4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resultados extends AppCompatActivity {

    Integer estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        TextView Nombre = (TextView)findViewById(R.id.tvNombreReci);
        TextView Edad = (TextView)findViewById(R.id.tvEdadReci);
        TextView Id= (TextView)findViewById(R.id.tvIDreci);
        TextView Estado = (TextView)findViewById(R.id.tvResultado);
        Button bsige = (Button)findViewById(R.id.bsigue);

        Bundle datosRecibidos = this.getIntent().getExtras();
        String nombre = datosRecibidos.getString("pNombre");
        String edad = datosRecibidos.getString("pEdad");
        String id=datosRecibidos.getString("pId");

        Nombre.setText("Tu nombre es: "+nombre);
        Edad.setText("Tu edad es: "+edad);
        Id.setText("Tu ID es: "+id);
//Aquí usa un si o no para determinar si es mayor de edad en pocas palabras lo que hace
// declarar que si es mayor de edad este saldrá en la pantalla eres mayor de edad de
//lo contrario dirá eres menor de edad.
        estado = Integer.parseInt(edad);
        if(estado < 18){
            Estado.setText("Eres menor de edad");
        }else{
            Estado.setText("Eres mayor de edad");
        }
        bsige.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sigue = new
                        Intent(Resultados.this,Control_taps.class);
                startActivity(sigue);
            }
        });
    }
}