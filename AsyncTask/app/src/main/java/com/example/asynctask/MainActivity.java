package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView lblResults;
    EditText txtNumber;
    Button btnSubmit;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblResults = findViewById(R.id.lblResult);
        txtNumber = findViewById(R.id.txtNumber);
        btnSubmit = findViewById(R.id.btnSubmit);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nrOfTimes = Integer.parseInt(txtNumber.getText().toString().trim());

                new ProcessDiceInBackground().execute(nrOfTimes);


            }
        });
    }

    public class ProcessDiceInBackground extends AsyncTask<Integer,Integer,String>{



        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setMax(Integer.parseInt(txtNumber.getText().toString().trim()));
            progressBar.setVisibility(View.VISIBLE);


        }

        @Override
        protected String doInBackground(Integer... integers) {

            int ones = 0,twos = 0,threes = 0,fours = 0,fives = 0,sixes = 0, randomNumber;


            Random random =  new Random();

            String results;

            double currentprogress= 0,previousprogress = 0;

            for(int i = 0; i<integers[0]; i++){


                        currentprogress = (double) i / integers[0];

                        if(currentprogress - previousprogress >= 0.2){
                           publishProgress(i);
                           previousprogress = currentprogress;
                        }

                        randomNumber = random.nextInt(6) + 1;

                switch (randomNumber){
                    case 1: ones++;
                        break;

                    case 2 : twos++;
                        break;

                    case 3: threes++;
                        break;

                    case 4: fours++;
                        break;

                    case 5: fives++;
                        break;

                    default: sixes++;
                }
            }

            results = "Results: \n1:  "+ones+ "\n2:  "+twos+
                    "\n3:  "+threes+"\n4:  "+fours+"\n5:  "+fives+
                    "\n6:  "+sixes;

            return results;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            progressBar.setProgress(values[0]);


        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressBar.setVisibility(View.GONE);
            progressBar.setProgress(0);

            lblResults.setText(s);
        }



    }
}
