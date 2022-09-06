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

    public void setNumber(View view){
        Button btn = (Button) view;
        String numToSet = btn.getText().toString();
        tv_screen.setText(tv_screen.getText() + numToSet);
    }

    public void setOperator(View view){
        Button btn = (Button) view;
        String op = btn.getText().toString();
        tv_screen.setText(tv_screen.getText() + " " + op + " ");
    }


    public void calculate (View view) {
        String expression = tv_screen.getText().toString();

        String[] splitedExpression = expression.split(" ");

        int num1 = Integer.parseInt(splitedExpression[0]);
        String operator = splitedExpression[1];
        int num2 = Integer.parseInt(splitedExpression[2]);

        switch (operator) {
            case "+":
                tv_screen.setText(String.valueOf(num1 + num2));
                break;
            case "-":
                tv_screen.setText(String.valueOf(num1 - num2));
                break;
            case "*":
                tv_screen.setText(String.valueOf(num1 * num2));
                break;
            case "/":
                tv_screen.setText(String.valueOf(num1 / num2));
                break;
            default:
                break;
        }
    }

}