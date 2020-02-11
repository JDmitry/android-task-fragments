package com.epam.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final static String MESSAGE_KEY = "message";
    final static String SELECT_KEY = "choice";
    final static String TOAST_MESSAGE = "Choose a fragment";
    final static String FIRST_FRAGMENT = "first_fragment";
    final static String SECOND_FRAGMENT = "second_fragment";
    private String selection;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.message);
    }

    public void clickRadioButton(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.radio_one:
                if (checked) {
                    selection = FIRST_FRAGMENT;
                    break;
                }

            case R.id.radio_two:
                if (checked) {
                    selection = SECOND_FRAGMENT;
                    break;
                }
        }
    }

    public void onPressed(View view) {
        String message = editText.getText().toString();
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra(MESSAGE_KEY, message);
        intent.putExtra(SELECT_KEY, selection);

        if (selection != null) {
            startActivity(intent);
        } else {
            Toast toast = Toast.makeText(getApplicationContext(),TOAST_MESSAGE,Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP,0,220);
            toast.show();
        }
    }
}