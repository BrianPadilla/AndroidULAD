package com.example.lectorhuellabasico;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.KeyguardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.hardware.biometrics.BiometricPrompt;

public class MainActivity extends AppCompatActivity {

    private CancellationSignal cancellationSignal;
    ImageView imvHuella;
    Integer banderafailed = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        revisarBioMetric();

        imvHuella = findViewById(R.id.imvHuella);

        imvHuella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AuthenticationUser(v);


            }
        });


    }



    
    private void creaToast(String mensaje){
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                creaToast("verifcacion por PIN exitosa");
                banderafailed = 0;
            }
        }
    }

    private Boolean revisarBioMetric(){
        KeyguardManager keyguardManager = (KeyguardManager) getSystemService(KEYGUARD_SERVICE);

        PackageManager packageManager = this.getPackageManager();

        if(!keyguardManager.isKeyguardSecure()){
            creaToast("No tienes activa ninguna configuracion de bloqueo de pantalla");
            return false;
        }

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.USE_FINGERPRINT)
        != PackageManager.PERMISSION_GRANTED){
            creaToast("No has Habilitado el Permiso de Usar la Huella");
            return false;
        }

        if(packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT)){
            return true;
        }

        return true;

    }


private BiometricPrompt.AuthenticationCallback getAuthenticationCallBack(){
        return new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode,
                                              CharSequence errString) {
                creaToast("Verificacion Fallida: " + errString);
                super.onAuthenticationError(errorCode, errString);

                banderafailed = 0;


            }


            @Override
            public void onAuthenticationHelp(int helpCode,
                                             CharSequence helpString) {
                banderafailed = 0;
                super.onAuthenticationHelp(helpCode, helpString);
            }

            @Override
            public void onAuthenticationFailed() {
                if(banderafailed == 2) {
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                        KeyguardManager km = (KeyguardManager) getSystemService(KEYGUARD_SERVICE);


                        if (km.isKeyguardSecure()) {
                            Intent authIntent = km.createConfirmDeviceCredentialIntent("Exceso de Intentos",
                                    "Ingresa tu contraseña o PIN");
                            startActivityForResult(authIntent, 0);
                        }
                    }
                }
                    banderafailed++;
                super.onAuthenticationFailed();



            }

            @Override
            public void onAuthenticationSucceeded(
                    BiometricPrompt.AuthenticationResult result) {
                creaToast("Verificacion Exitosa");
                super.onAuthenticationSucceeded(result);
            }
        };
}

private CancellationSignal getCancellationSignal(){
        cancellationSignal = new CancellationSignal();
        cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() {
            @Override
            public void onCancel() {
                creaToast("Cancelado");
                banderafailed = 0;
            }
        });

        return cancellationSignal;
}



public void AuthenticationUser(View v){
        BiometricPrompt biometricPrompt =  new BiometricPrompt.Builder(this)
                .setTitle("Bienvenido a Mi lector de huellas")
                .setSubtitle("Es necesario colocar la huella para continuar")
                .setDescription("esta aplicacion guarda tu huella en Internet para que el mundo la robe")
                .setNegativeButton("Aceptar y Enviar", this.getMainExecutor(),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                creaToast("Datos Enviados de Todos Modos");
                            }
                        })
                .build();

        biometricPrompt.authenticate(getCancellationSignal(),getMainExecutor(),getAuthenticationCallBack());


    }
}








