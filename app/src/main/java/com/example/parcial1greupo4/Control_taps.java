package com.example.parcial1greupo4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.parcial1greupo4.Controles.PagerController;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class Control_taps extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    TabItem tab1,tab2,tab3;

    PagerController pagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_taps);
        // En el archivo R. están los objetos para el enlace
        tabLayout = findViewById(R.id.Tablayout);
        viewPager = findViewById(R.id.viewpager);
        tab1 = findViewById(R.id.tabMenu);
        tab2 = findViewById(R.id.tabBebidas);
        tab3 = findViewById(R.id.tabPostres);
        pagerAdapter = new PagerController(getSupportFragmentManager(),
                tabLayout.getTabCount());

        // los fragment se mostratán en este vista viewPager
        viewPager.setAdapter(pagerAdapter);


        // Evento clic para los tabs
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // Obtenemos la posición del tab a mostrar
                viewPager.setCurrentItem(tab.getPosition());
                // Determinar cual fragment se presenta
                if(tab.getPosition()==0){
                    pagerAdapter.notifyDataSetChanged();
                }
                if(tab.getPosition()==1){
                    pagerAdapter.notifyDataSetChanged();
                }
                if(tab.getPosition()==2){
                    pagerAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        Button Acele =(Button)findViewById(R.id.btnsensor);
        Acele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Acele=new Intent(Control_taps.this, Proximidad.class);
                startActivity(Acele);
            }
        });


// Aquí ViewPager en la activity sabe cual frafment mostrar
        viewPager.addOnPageChangeListener(new
                TabLayout.TabLayoutOnPageChangeListener( tabLayout));



    }

}