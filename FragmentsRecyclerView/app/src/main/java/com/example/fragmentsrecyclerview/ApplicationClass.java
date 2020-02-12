package com.example.fragmentsrecyclerview;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application {

    public static ArrayList<Person> people;

    @Override
    public void onCreate() {
        super.onCreate();

        people = new ArrayList<Person>();
        people.add(new Person("Devora Fierro","3112334455"));
        people.add(new Person("Mario Neta","3322554477"));
        people.add(new Person("Elver Galarga","3111778899"));

    }
}
