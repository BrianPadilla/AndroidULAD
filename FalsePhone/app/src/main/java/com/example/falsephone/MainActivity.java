package com.example.falsephone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMessage = findViewById(R.id.txtMessage);
        if(getIntent().getData() != null){
            txtMessage.setText(getIntent().getDataString());
        }
    }
}
