package com.example.contadorbotonvolumen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView lblContador;
    int cont = 0;
    int cont2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblContador = findViewById(R.id.lblContador);



    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        int action = event.getAction();
        int keyCode = event.getKeyCode();
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
                if (action == KeyEvent.ACTION_DOWN) {
                    Log.d("contador",cont2+"");
                    cont++;
                    cont2 = cont;
                    //si queres ajustar el volumen
                    //audioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
                    lblContador.setText("Volumen: "+cont2);
                }
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                if (action == KeyEvent.ACTION_DOWN) {
                    Log.d("contadorD",cont2+"");
                    cont2 = cont;
                    cont--;
//audioManager.adjustVolume(AudioManager.ADJUST_LOWER, AudioManager.FLAG_PLAY_SOUND);

                    lblContador.setText("Volumen: "+cont2);
                }
                return true;
            default:
                return super.dispatchKeyEvent(event);
        }
    }

}


