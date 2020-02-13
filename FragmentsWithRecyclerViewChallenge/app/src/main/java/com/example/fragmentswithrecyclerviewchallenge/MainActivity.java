package com.example.fragmentswithrecyclerviewchallenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ListFragment;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CarroAdapter.ItemClicked {

    TextView lblModelo,lblPropietario,lblFijo,lblTelefono,lblCardModelo;
    Button btnCarroInfo,btnPropInfo;
    ImageView imvCarroInfo;
    ListaFragment listaFrag;
    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblFijo = findViewById(R.id.lblFijo);
        lblModelo = findViewById(R.id.lblModelo);
        lblPropietario = findViewById(R.id.lblPropietario);
        lblTelefono = findViewById(R.id.lblTelefono);
        btnCarroInfo = findViewById(R.id.btnCarroInfo);
        btnPropInfo = findViewById(R.id.btnPropietarioInfo);
        imvCarroInfo = findViewById(R.id.imvCarroInfo);
        lblCardModelo = findViewById(R.id.lblCardModelo);

        fragmentManager = this.getSupportFragmentManager();
        listaFrag = (ListaFragment) fragmentManager.findFragmentById(R.id.listFrag);



        btnCarroInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragmentManager.beginTransaction()
                        .hide(fragmentManager.findFragmentById(R.id.infoPropFrag))
                        .show(fragmentManager.findFragmentById(R.id.infoCarroFrag))
                        .commit();

            }
        });

        btnPropInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragmentManager.beginTransaction()
                        .hide(fragmentManager.findFragmentById(R.id.infoCarroFrag))
                        .show(fragmentManager.findFragmentById(R.id.infoPropFrag))
                        .commit();

            }
        });


        onItemClicked(0);




    }

    @Override
    public void onItemClicked(int index) {



        lblModelo.setText(ArrayListCarros.carro.get(index).getModelo());
        lblFijo.setText("Informacion del Propietario");
        lblPropietario.setText(ArrayListCarros.carro.get(index).getDueño());
        lblTelefono.setText(ArrayListCarros.carro.get(index).getTelefono());
        imvCarroInfo.setImageResource(ArrayListCarros.carro.get(index).getImagen());






    }
}
