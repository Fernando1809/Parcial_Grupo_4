package com.example.parcial1greupo4.Controles;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
public class PagerController extends FragmentPagerAdapter {
    // Se crea esta variable para controlar el número de tabs
    int numoftabs;
    // Creamos el constructor de la clase
    public PagerController(@NonNull FragmentManager fm, int behavior)
    {
        super(fm, behavior);
        this.numoftabs = behavior;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        // aquí se determina cual fragment cargar
        switch (position){
            case 0:
                return new Menu();
            case 1:
                return new Bebidas();
            case 2:
                return new Postres();
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        // Este método retorna el número de tabs
        return numoftabs;
    }
}