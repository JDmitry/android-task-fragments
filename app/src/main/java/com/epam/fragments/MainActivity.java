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
    final static String KEY_MESSAGE = "message";
    final static String CHOICE = "choice";
    final static String TOAST_MESSAGE = "Chooce a fragment";
    private String choice;
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
                    choice = "first_fragment";
                    break;
                }

            case R.id.radio_two:
                if (checked) {
                    choice = "second_fragment";
                    break;
                }
        }
    }

    public void onPressed(View view) {
        String message = editText.getText().toString();

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra(KEY_MESSAGE, message);
        intent.putExtra(CHOICE, choice);

        if(choice != null) {
            startActivity(intent);
        }else {
            Toast toast = Toast.makeText(getApplicationContext(),TOAST_MESSAGE,Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP,0,220);
            toast.show();
        }
    }


}