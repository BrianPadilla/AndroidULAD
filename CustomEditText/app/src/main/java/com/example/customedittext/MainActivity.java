package com.example.customedittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView txtFirstname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtFirstname = findViewById(R.id.txtfirstname);

        String names [] = {"Perro","Perrillo","Perrote","Perraso","Perroso","Perrito"};

        ArrayAdapter<String> adapter
                = new ArrayAdapter<>(this,R.layout.custom_design_autocomplete, names);

        txtFirstname.setThreshold(1);
        txtFirstname.setAdapter(adapter);

    }
}
