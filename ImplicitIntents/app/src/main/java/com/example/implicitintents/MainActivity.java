package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnmap,btnweb,btncall,btncallfriend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btncall = findViewById(R.id.btnCall);
        btncallfriend = findViewById(R.id.btnCallFriend);
        btnweb = findViewById(R.id.btnWeb);
        btnmap = findViewById(R.id.btnMap);

        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_DIAL);
                startActivity(intent);

            }
        });

        btncallfriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 3111173778"));
                startActivity(intent);

            }
        });

        btnweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://cavestory.org"));
                startActivity(intent);

            }
        });

        btnmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?=12 Adolfo Lopez Mateos ,Tepic"));
                startActivity(intent);

            }
        });
    }
}
