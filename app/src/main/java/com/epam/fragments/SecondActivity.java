package com.epam.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {
    final static String MESSAGE = "message";
    private String choice;
    private String message;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        choice = intent.getStringExtra(MainActivity.CHOICE);
        message = intent.getStringExtra(MainActivity.KEY_MESSAGE);

        switch (choice) {
            case "first_fragment":
                if (savedInstanceState == null) {
                    bundle = new Bundle();
                    bundle.putString(MESSAGE, message);
                    FirstFragment firstFragment = new FirstFragment();
                    firstFragment.setArguments(bundle);
                    fragmentManager = getSupportFragmentManager();
                    transaction = fragmentManager.beginTransaction();
                    transaction.add(R.id.container, firstFragment);
                    transaction.commit();
                }
                break;

            case "second_fragment":
                if (savedInstanceState == null) {
                    bundle = new Bundle();
                    bundle.putString(MESSAGE, message);
                    SecondFragment secondFragment = new SecondFragment();
                    secondFragment.setArguments(bundle);
                    fragmentManager = getSupportFragmentManager();
                    transaction = fragmentManager.beginTransaction();
                    transaction.add(R.id.container, secondFragment);
                    transaction.commit();
                }
                break;
        }
    }
}