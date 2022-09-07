package com.example.my_first_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private TextView tv_screen;
    private String op;
    private float num1;
    private float num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_screen = (TextView) findViewById(R.id.tv_screen);
        num1 = 0;
        num2 = 0;
        op = "";
    }

    public void setNum1 (float num) {
        this.num1 = num;
    }

    public void setNum2 (float num) {
        this.num2 = num;
    }

    public float getNum1() {
        return this.num1;
    }

    public float getNum2() {
        return this.num2;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getOp() {
        return this.op;
    }

    public void setNumberOnScreen(View view){
        Button btn = (Button) view;
        String numToSet = btn.getText().toString();

        tv_screen.setText(tv_screen.getText() + numToSet); //setting number on screen

        if(getOp().equals("")) {
            if(getNum1() != 0) numToSet = NumberFormat.getInstance().format(getNum1()) + numToSet; //num1 has some value in it
            setNum1(Float.parseFloat(numToSet));
        } else {
            if(getNum2() != 0) numToSet = NumberFormat.getInstance().format(getNum2()) + numToSet; //num2 has some value in it
            setNum2(Float.parseFloat(numToSet));
        }

    }

    public void setOperatorOnScreen(View view){
        Button btn = (Button) view;
        String op = btn.getText().toString();

        if(getNum2() != 0) {
            calculate();
        }

        if(!getOp().equals("")) {
            replaceOp(op);
        } else {
            tv_screen.setText(tv_screen.getText() + " " + op + " ");
        }
        setOp(op); //setting global operator
    }

    private void onAfterOp(float newNumber) {
        setNum1(newNumber);
        setNum2(0);
        setOp("");
    }

    private void replaceOp (String op) {
        String expression = tv_screen.getText().toString();
        String[] arrayEx = expression.split(" ");
        arrayEx[1] = op;
        tv_screen.setText(arrayEx[0] + " " + arrayEx[1] + " ");
    }

    private void calculate() {
        float newNumber;
        switch (getOp()) {
            case "+":
                newNumber = getNum1() + getNum2();
                tv_screen.setText(NumberFormat.getInstance().format(newNumber));
                onAfterOp(newNumber);
                break;
            case "-":
                newNumber = getNum1() - getNum2();
                tv_screen.setText(NumberFormat.getInstance().format(newNumber));
                onAfterOp(newNumber);
                break;
            case "*":
                newNumber = getNum1() * getNum2();
                tv_screen.setText(NumberFormat.getInstance().format(newNumber));
                onAfterOp(newNumber);
                break;
            case "/":
                newNumber = getNum1() / getNum2();
                tv_screen.setText(NumberFormat.getInstance().format(newNumber));
                onAfterOp(newNumber);
                break;
            default:
                break;
        }
    }

    public void handleEqualsButton(View view) {
       calculate();
    }

}