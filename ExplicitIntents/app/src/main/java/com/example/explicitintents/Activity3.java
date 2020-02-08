package com.example.explicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {

    TextView txtSurname;
    Button btnSumbmit,btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        txtSurname = findViewById(R.id.txtSurname);
        btnSumbmit = findViewById(R.id.btnSubmit);
        btnCancel = findViewById(R.id.btnCancel);

        btnSumbmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(txtSurname.getText().toString().isEmpty()){
                    Toast.makeText(Activity3.this,"Please fill the field",Toast.LENGTH_SHORT);

                }

                String surname = txtSurname.getText().toString().trim();

                Intent intent = new Intent();
                intent.putExtra("surname",surname);
                setResult(RESULT_OK,intent);
                Activity3.this.finish();

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                Activity3.this.finish();
            }
        });
    }
}
