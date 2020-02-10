package com.example.intentschallenge;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imvMood,imvCall,imvWeb,imvMap;
    Button btnNuevoContacto;
    final int CrearContactoActivity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imvMood = findViewById(R.id.imvMood);
        imvCall = findViewById(R.id.imvCall);
        imvWeb = findViewById(R.id.imvWeb);
        imvMap = findViewById(R.id.imvMap);
        btnNuevoContacto = findViewById(R.id.btnNuevoContacto);



        btnNuevoContacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,com.example.intentschallenge.CrearContactoActivity.class);
                startActivityForResult(intent,CrearContactoActivity);


            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        final String DatoTelefono,DatoWeb,DatoMapa;

        DatoTelefono = data.getStringExtra("Telefono");
        DatoWeb = data.getStringExtra("Web");
        DatoMapa = data.getStringExtra("Mapa");

        if(requestCode == CrearContactoActivity){



            Log.d("Estatus",resultCode+"");
            Log.d("Telefono",data.getStringExtra("Telefono"));
            Log.d("Web",data.getStringExtra("Web"));
            Log.d("Mapa",data.getStringExtra("Mapa"));
            Integer bandera;

            bandera = data.getIntExtra("BanderaMood",0);


            if(resultCode == RESULT_OK){

                imvCall.setVisibility(View.VISIBLE);
                imvWeb.setVisibility(View.VISIBLE);
                imvMap.setVisibility(View.VISIBLE);

                if(bandera == 1){
                    imvMood.setVisibility(View.VISIBLE);
                }

                if(bandera == 2){
                    imvMood.setVisibility(View.VISIBLE);
                    imvMood.setImageResource(R.drawable.moodmedium);
                }

                if(bandera == 3){
                    imvMood.setVisibility(View.VISIBLE);
                    imvMood.setImageResource(R.drawable.moodbd);
                }

                imvCall.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                    Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("tel:"+DatoTelefono));
                    startActivity(intent);


                    }
                });

                imvWeb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(DatoWeb));
                        startActivity(intent);
                    }
                });

                imvMap.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q="+DatoMapa));
                        startActivity(intent);
                    }
                });
            }
        }
    }
}
