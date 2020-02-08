package com.example.explicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    TextView txtWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        txtWelcome = findViewById(R.id.txtName);

        String name = getIntent().getStringExtra("name");

        txtWelcome.setText(name + " Welcome 2 Activity 2 Nigga");
    }
}
