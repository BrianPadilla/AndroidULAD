package com.example.cricketchirps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

        EditText txtNumSon;
        Button btnCalcular;
        TextView lblResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNumSon = findViewById(R.id.txtNumSon);
        btnCalcular = findViewById(R.id.btnCalcular);
        lblResultado = findViewById(R.id.lblResultado);

        //(Ex. 48 chirps in 25 seconds / 3  + 4 = 20 degrees C)
        //(Ex. 30 chirps in 14 seconds + 40 = 70 degrees F)





        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int numchirps = Integer.parseInt(txtNumSon.getText().toString());

                int resultadoC = (numchirps / 3) + 4;
                int resultadoF =  numchirps + 40;

                String Resultado = "El Resultado en Farenheit es: "+resultadoF+"°"+"\n"+
                        "El Resultado en Celcius es: "+resultadoC+"°";

                lblResultado.setText(Resultado);
            }
        });



    }
}
