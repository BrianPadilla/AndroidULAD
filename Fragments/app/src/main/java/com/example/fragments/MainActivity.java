package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFragments.ItemSelected {

    TextView lblDescription;
    String[] descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblDescription = findViewById(R.id.lblDescription);

        descriptions = getResources().getStringArray(R.array.descriptions);
        /*descriptions.add("Descripcion para el Item 1");
        descriptions.add("Descripcion para el Item 2");
        descriptions.add("Descripcion para el Item 3");*/

        //the phone is in portrait mode
        if(findViewById(R.id.layout_portrait) != null){

            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.detailfrag))
                    .show(manager.findFragmentById(R.id.listfrag))
                    .commit();

        }


        //the phone is in land mode
        if(findViewById(R.id.layout_land) != null){

            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detailfrag))
                    .show(manager.findFragmentById(R.id.listfrag))
                    .commit();

        }
    }

    @Override
    public void onItemSelected(int index) {
        lblDescription.setText(descriptions[index]);

        //the phone is in portrait mode
        if(findViewById(R.id.layout_portrait) != null){

            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detailfrag))
                    .hide(manager.findFragmentById(R.id.listfrag))
                    .addToBackStack(null)
                    .commit();

        }
    }
}
