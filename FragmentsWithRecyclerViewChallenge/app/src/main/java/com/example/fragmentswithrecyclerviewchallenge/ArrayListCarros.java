package com.example.fragmentswithrecyclerviewchallenge;

import android.app.Application;
import android.widget.ImageView;

import java.util.ArrayList;

public class ArrayListCarros extends Application{

    public static ArrayList<Carro> carro;
    ImageView imagen;


    @Override
    public void onCreate() {

        super.onCreate();



        carro = new ArrayList<Carro>();
        carro.add(new Carro("Devora Fierro","2006","3112334455"));
        carro.add(new Carro("Mario Neta","2007","3322554477"));
        carro.add(new Carro("Elver Galarga","2008","3111778899"));

    }
    
}
