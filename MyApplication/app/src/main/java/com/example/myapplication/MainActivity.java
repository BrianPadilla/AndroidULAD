package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText txtID;
    Button btnSubmit;
    TextView lblResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Mi Aplicacion");

        txtID = findViewById(R.id.txtID);
        btnSubmit = findViewById(R.id.btnSubmit);
        lblResults = findViewById(R.id.lblResults);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idnumber = txtID.getText().toString().trim();
                String birthday = idnumber.substring(0,6);
                String TheGender;
                String TheNationality;


                int gender = Integer.parseInt(Character.toString(idnumber.charAt(6)));
                int nationality = Integer.parseInt(Character.toString(idnumber.charAt(10)));

                lblResults.setVisibility(View.GONE);


                if(gender < 5){
                    TheGender = getString(R.string.vsfemale);
                }
                else{
                    TheGender = getString(R.string.vsmale);
                }

                if(nationality == 0){
                    TheNationality = getString(R.string.vscitizien);
                }

                else{
                    TheNationality = getString(R.string.vspermanent);
                }

                String results = getString(R.string.vsdatebirth)+birthday + getString(R.string.jump_line) +
                        getString(R.string.vsgender) + TheGender + getString(R.string.jump_line) +
                        getString(R.string.vsnationality) + TheNationality;

                lblResults.setText(results);
                lblResults.setVisibility(View.VISIBLE);
            }
        });

    }


}
