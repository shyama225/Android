package com.example.simplecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private double firstNumber = 0;
    private String currentOperator = "";
    private boolean isNewOp = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // Use your actual layout file name

        display = findViewById(R.id.display);
    }

    public void numberClick(View view) {
        Button button = (Button) view;
        String number = button.getText().toString();

        if (isNewOp) {
            display.setText("");
            isNewOp = false;
        }

        display.append(number);
    }
    public void dotClick(View view) {
        String currentText = display.getText().toString();

        // Avoid adding multiple dots
        if (!currentText.contains(".")) {
            display.append(".");
        }
    }
    public void operatorClick(View view) {
        Button button = (Button) view;
        String operator = button.getText().toString();

        firstNumber = Double.parseDouble(display.getText().toString());
        currentOperator = operator;
        isNewOp = true;
    }

    public void equalsClick(View view) {
        double secondNumber = Double.parseDouble(display.getText().toString());
        double result = 0;

//        switch (currentOperator) {
//            case "÷":
//                if (secondNumber != 0)
//                    result = firstNumber / secondNumber;
//                else {
//                    display.setText("Error");
//                    return;
//                }
//                break;
//
//            case "×":
//                result = firstNumber * secondNumber;
//                break;
//
//
//            case "−":
//                result = firstNumber - secondNumber;
//                break;
//            case "+":
//                result = firstNumber + secondNumber;
//                break;
//
//
//        }
        switch (currentOperator) {
            case "/":
                if (secondNumber != 0)
                    result = firstNumber / secondNumber;
                else {
                    display.setText("Error");
                    return;
                }
                break;

            case "*":
            case "x":  // in case your button says "x"
                result = firstNumber * secondNumber;
                break;

            case "-":
                result = firstNumber - secondNumber;
                break;

            case "+":
                result = firstNumber + secondNumber;
                break;
        }


        display.setText(String.valueOf(result));
        isNewOp = true;
    }

    public void clearClick(View view) {
        display.setText("0");
        firstNumber = 0;
        currentOperator = "";
        isNewOp = true;
    }

}
