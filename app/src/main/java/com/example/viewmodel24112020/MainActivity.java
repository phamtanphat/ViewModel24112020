package com.example.viewmodel24112020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    MyLifeCycleActivity myLifeCycleActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Lifecycle aware component

        myLifeCycleActivity = new MyLifeCycleActivity();
        getLifecycle().addObserver(myLifeCycleActivity);


    }
}