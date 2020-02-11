package com.epam.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {
    final static String MESSAGE = "message";
    private String selectoin;
    private String message;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        selectoin = intent.getStringExtra(MainActivity.SELECT_KEY);
        message = intent.getStringExtra(MainActivity.MESSAGE_KEY);

        switch (selectoin) {
            case MainActivity.FIRST_FRAGMENT:
                if (savedInstanceState == null) {
                    selectFragment(new FirstFragment());
                }
                break;

            case MainActivity.SECOND_FRAGMENT:
                if (savedInstanceState == null) {
                    selectFragment(new SecondFragment());
                }
                break;
        }
    }

    public void selectFragment(Fragment fragment) {
        bundle = new Bundle();
        bundle.putString(MESSAGE, message);
        fragment.setArguments(bundle);
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.container, fragment);
        transaction.commit();
    }
}