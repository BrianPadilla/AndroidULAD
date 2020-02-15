package com.example.textfilesandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    EditText txtName,txtSurname;
    TextView lblResults;
    Button btnAdd,btnSave;
    ArrayList<Person> persons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = findViewById(R.id.txtName);
        txtSurname = findViewById(R.id.txtSurname);
        lblResults = findViewById(R.id.lblResults);
        btnAdd = findViewById(R.id.btnAdd);
        btnSave = findViewById(R.id.btnSave);
        persons = new ArrayList<>();

        loadData();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = txtName.getText().toString();
                String surname = txtSurname.getText().toString();

                Person person =  new Person(name,surname);
                persons.add(person);

                setTextToTextView();

            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try
                {

                    FileOutputStream file = openFileOutput("data.txt", MODE_PRIVATE);
                    OutputStreamWriter appfile = new OutputStreamWriter(file);

                    for (int i = 0; i<persons.size(); i++)
                    {
                        appfile.write(persons.get(i).getName() + "," + persons.get(i).getSurname() + "\n");
                    }

                    appfile.flush();
                    appfile.close();

                    Toast.makeText(MainActivity.this, "Successfully Saved", Toast.LENGTH_SHORT).show();

                }

                catch (IOException e){

                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                }

            }
        });


    }

    private void setTextToTextView() {

        String text = "";

        for (int i = 0; i<persons.size(); i++){
            text = text + persons.get(i).getName() + " " + persons.get(i).getSurname() + "\n";
        }

        lblResults.setText(text);
    }

    public void loadData(){

        persons.clear();

        File file = getApplicationContext().getFileStreamPath("data.txt");
        String linefromfile;

        if(file.exists()){
            try
            {
                BufferedReader reader =  new BufferedReader(new InputStreamReader(openFileInput("data.txt")));

                while((linefromfile = reader.readLine()) != null){

                    StringTokenizer tokenizer = new StringTokenizer(linefromfile, ",");
                    Person person = new Person(tokenizer.nextToken(),tokenizer.nextToken());
                    persons.add(person);
                }

                reader.close();

                setTextToTextView();
            }

            catch (IOException e)
            {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }

    }
}
