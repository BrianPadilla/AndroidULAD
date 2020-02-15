package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView lblWelcome;
    EditText txtName;
    Button btnSubmit;

    public static final String MY_PREFS_FILENAME = "com.example.sharedpreferences.name";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblWelcome = findViewById(R.id.lblWelcome);
        txtName = findViewById(R.id.txtName);
        btnSubmit = findViewById(R.id.btnSubmit);

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_FILENAME,MODE_PRIVATE);
        String user = prefs.getString("user","");

        lblWelcome.setText("Welcome to My App "+ user+" :)");

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtName.getText().toString().trim();

                lblWelcome.setText("Welcome to My App "+name+" :)");

                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_FILENAME,MODE_PRIVATE).edit();
                editor.putString("user",name);
                editor.commit();
            }
        });

    }


}
