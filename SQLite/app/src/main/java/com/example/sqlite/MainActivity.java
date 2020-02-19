package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {

    EditText txtName,txtCell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = findViewById(R.id.txtName);
        txtCell = findViewById(R.id.txtCell);
    }

    public void btnSubmit(View v){

        String name = txtName.getText().toString().trim();
        String cell = txtCell.getText().toString().trim();

        try{
            ContactsDB db = new ContactsDB(this);
            db.open();
            db.createEntry(name,cell);
            db.close();
            Toast.makeText(this, "Successfully saved", Toast.LENGTH_SHORT).show();
            txtName.setText("");
            txtCell.setText("");

        }

        catch (Exception e)
        {

            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }



    }

    public void btnShowData(View v){

        startActivity(new Intent(this,Data.class));

    }

    public void btnEditData(View v){

        try{
            ContactsDB db = new ContactsDB(this);
            db.open();
            db.updateEntry("1","Pedro Salsas","3111111111");
            db.close();
            Toast.makeText(this, "Successfully Updated", Toast.LENGTH_SHORT).show();
        }

        catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    public void btnDeleteData(View v){

        try {
            ContactsDB db = new ContactsDB(this);
            db.open();
            db.deleteEntry("1");
            db.close();
            Toast.makeText(this, "Successfully Deleted", Toast.LENGTH_SHORT).show();
        }

        catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}
