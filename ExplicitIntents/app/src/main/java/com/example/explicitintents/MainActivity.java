package com.example.explicitintents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtName;
    Button btnAct2,btnAct3;
    TextView lblResults;
    final int Activity3 = 3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = findViewById(R.id.txtName);
        btnAct2 = findViewById(R.id.btnAct2);
        btnAct3 = findViewById(R.id.btnAct3);
        lblResults = findViewById(R.id.lblResults);

        btnAct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(txtName.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,
                            "Please Enter All Fields Nigga",Toast.LENGTH_SHORT).show();
                }

                else {
                    String name = txtName.getText().toString().trim();
                    Intent intent = new Intent
                            (MainActivity.this,com.example.explicitintents.Activity2.class);

                    intent.putExtra("name",name);
                    startActivity(intent);
                }

            }
        });

        btnAct3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,com.example.explicitintents.Activity3.class);

                startActivityForResult(intent,Activity3);

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == Activity3){
            if (resultCode == RESULT_OK){
                lblResults.setText(data.getStringExtra("surname"));
            }

            if (requestCode == RESULT_CANCELED){
                lblResults.setText("no data received");
            }
        }
    }
}
