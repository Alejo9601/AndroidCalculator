package com.example.my_first_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_screen = (TextView) findViewById(R.id.tv_screen);
    }

    public void setTextOnScreen(View view){
        Button btn = (Button) view;
        String numToSet = btn.getText().toString();
        tv_screen.setText(tv_screen.getText() + numToSet);
    }

}