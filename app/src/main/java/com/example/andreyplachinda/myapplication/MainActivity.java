package com.example.andreyplachinda.myapplication;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.awt.font.TextAttribute;

public class MainActivity extends AppCompatActivity {
    TextView screenView;
    double carrentValue = 0;
    double hiddenValue = 0;
    Operations operation;

    private enum Operations {PLUS, MINUS, DIVISION, MULTIPLY, PERCENT}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);

        screenView = findViewById(R.id.textView1);
        button0.setOnClickListener((v) -> numberClick(0));
        button1.setOnClickListener((v) -> numberClick(1));
        button2.setOnClickListener((v) -> numberClick(2));
        button3.setOnClickListener((v) -> numberClick(3));
        button4.setOnClickListener((v) -> numberClick(4));
        button5.setOnClickListener((v) -> numberClick(5));
        button6.setOnClickListener((v) -> numberClick(6));
        button7.setOnClickListener((v) -> numberClick(7));
        button8.setOnClickListener((v) -> numberClick(8));
        button9.setOnClickListener((v) -> numberClick(9));
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    private void numberClick(int number) {
        carrentValue = carrentValue * 10 + number;
        screenView.setText(String.valueOf(carrentValue));
    }


    public void onClickReset(View view) {
        screenView.setText("0");
        carrentValue = 0;
//        new AlertDialog.Builder(this)
//                .setTitle("info")
//                .setMessage("Reset is done")
//                .setPositiveButton("OK", null)
//                .show();
    }

    public void onClickPlus(View view) {
        if (hiddenValue != 0) {
            onClickReset(null);
            return;
        }
        hiddenValue = carrentValue;
        carrentValue = 0;
        screenView.setText("0");
        operation = Operations.PLUS;
    }

    public void onClickResult(View view) {
        if (operation == Operations.PLUS) {
            carrentValue = hiddenValue + carrentValue;
        } else if (operation == Operations.MINUS) {
            carrentValue = hiddenValue - carrentValue;
        } else if (operation == Operations.MULTIPLY) {
            carrentValue = hiddenValue * carrentValue;
        } else if (operation == Operations.DIVISION) {
            carrentValue = hiddenValue / carrentValue;
        } else if (operation == Operations.PERCENT) {
            carrentValue = (carrentValue * 100) / hiddenValue;
        }
        hiddenValue = 0;
        screenView.setText(String.valueOf(carrentValue));
    }

    public void onClickMinus(View view) {
        if (hiddenValue != 0) {
            onClickReset(null);
            return;
        }
        hiddenValue = carrentValue;
        carrentValue = 0;
        screenView.setText("0");
        operation = Operations.MINUS;
    }

    public void onClickPercent(View view) {
        if (hiddenValue != 0) {
            onClickReset(null);
            return;
        }
        hiddenValue = carrentValue;
        carrentValue = 0;
        screenView.setText("0");
        operation = Operations.PERCENT;
    }

    public void onClickMultiply(View view) {
        if (hiddenValue != 0) {
            onClickReset(null);
            return;
        }
        hiddenValue = carrentValue;
        carrentValue = 0;
        screenView.setText("0");
        operation = Operations.MULTIPLY;
    }

    public void onClickDivision(View view) {
        if (hiddenValue != 0) {
            onClickReset(null);
            return;
        }
        hiddenValue = carrentValue;
        carrentValue = 0;
        screenView.setText("0");
        operation = Operations.DIVISION;



//        if (carrentValue != 0) {
//            new AlertDialog.Builder(this)
//                    .setTitle("info")
//                    .setMessage("Division on 0!")
//                    .setPositiveButton("OK", null)
//                    .show();
//        } else {
//            if (hiddenValue != 0) {
//                onClickReset(null);
//                return;
//            }
//            hiddenValue = carrentValue;
//            carrentValue = 0;
//            screenView.setText("0");
//            operation = Operations.DIVISION;
        }
    }

