package com.example.intentschallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class CrearContactoActivity extends AppCompatActivity {

    EditText txtNombre, txtTelefono,txtWeb,txtMapa;
    ImageView imvGM,imvMM,imvBM;
    Intent intent;
    String nombre,telefono,web,mapa;
    Integer bandera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_contacto);

        txtNombre = findViewById(R.id.txtNombre);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtWeb = findViewById(R.id.txtWeb);
        txtMapa =  findViewById(R.id.txtMapa);
        imvGM = findViewById(R.id.imvGM);
        imvMM = findViewById(R.id.imvMM);
        imvBM = findViewById(R.id.imvBM);

        intent = new Intent();

        imvGM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bandera = 1;

                nombre = txtNombre.getText().toString().trim();
                telefono = txtTelefono.getText().toString();
                web = txtWeb.getText().toString().trim();
                mapa = txtMapa.getText().toString().trim();


                intent.putExtra("Nombre",nombre);
                intent.putExtra("Telefono",telefono);
                intent.putExtra("Web",web);
                intent.putExtra("Mapa",mapa);
                intent.putExtra("BanderaMood",bandera);

                setResult(RESULT_OK,intent);
                CrearContactoActivity.this.finish();


            }
        });

        imvMM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bandera = 2;

                nombre = txtNombre.getText().toString().trim();
                telefono = txtTelefono.getText().toString();
                web = txtWeb.getText().toString().trim();
                mapa = txtMapa.getText().toString().trim();


                intent.putExtra("Nombre",nombre);
                intent.putExtra("Telefono",telefono);
                intent.putExtra("Web",web);
                intent.putExtra("Mapa",mapa);
                intent.putExtra("BanderaMood",bandera);

                setResult(RESULT_OK,intent);
                CrearContactoActivity.this.finish();
            }
        });

        imvBM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bandera = 3;

                nombre = txtNombre.getText().toString().trim();
                telefono = txtTelefono.getText().toString();
                web = txtWeb.getText().toString().trim();
                mapa = txtMapa.getText().toString().trim();


                intent.putExtra("Nombre",nombre);
                intent.putExtra("Telefono",telefono);
                intent.putExtra("Web",web);
                intent.putExtra("Mapa",mapa);
                intent.putExtra("BanderaMood",bandera);

                setResult(RESULT_OK,intent);
                CrearContactoActivity.this.finish();
            }

        });




    }
}
