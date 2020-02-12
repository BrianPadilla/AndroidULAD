package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    Button btnAdd;

    ArrayList<Person> people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                people.add(new Person("Mario","Neta","plane"));
                adapter.notifyDataSetChanged();
            }
        });

        recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        people = new ArrayList<Person>();

        people.add(new Person("Brian","Padilla","bus"));
        people.add(new Person("Chuck","Norris","bus"));
        people.add(new Person("Armando Esteban","Quito","plane"));
        people.add(new Person("Penelope","Sones","plane"));
        people.add(new Person("Devora","Fierro","plane"));
        people.add(new Person("Brian","Padilla","bus"));
        people.add(new Person("Chuck","Norris","bus"));
        people.add(new Person("Armando Esteban","Quito","plane"));
        people.add(new Person("Penelope","Sones","plane"));
        people.add(new Person("Devora","Fierro","plane"));
        people.add(new Person("Brian","Padilla","bus"));
        people.add(new Person("Chuck","Norris","bus"));
        people.add(new Person("Armando Esteban","Quito","plane"));
        people.add(new Person("Penelope","Sones","plane"));
        people.add(new Person("Devora","Fierro","plane"));
        people.add(new Person("Brian","Padilla","bus"));
        people.add(new Person("Chuck","Norris","bus"));
        people.add(new Person("Armando Esteban","Quito","plane"));
        people.add(new Person("Penelope","Sones","plane"));
        people.add(new Person("Devora","Fierro","plane"));

        adapter = new PersonAdapter(this,people);

        recyclerView.setAdapter(adapter);


    }

    @Override
    public void OnItemClicked(int index) {
        Toast.makeText(this, "Surname: " + people.get(index).getSurname(),Toast.LENGTH_SHORT).show();
    }
}
