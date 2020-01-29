package com.epam.fragments;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {
    final static String KEY = "key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);



        Intent intent = getIntent();
        String ch = intent.getStringExtra(MainActivity.CHOICE);
        String message = intent.getStringExtra(MainActivity.TEXT);


        switch (ch) {
            case "first_fragment":
                if (savedInstanceState == null) {
                    Bundle bundle = new Bundle();
                    bundle.putString(KEY,message);
                    FirstFragment firstFragment = new FirstFragment();
                    firstFragment.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, firstFragment).commit();
                }
                break;
            case "second_fragment":
                if (savedInstanceState == null) {
                    Bundle bundle = new Bundle();
                    bundle.putString(KEY,message);
                    SecondFragment secondFragment = new SecondFragment();
                    secondFragment.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, secondFragment).commit();

                }
                break;
        }
    }
}