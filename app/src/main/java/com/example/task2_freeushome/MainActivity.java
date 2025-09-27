package com.example.task2_freeushome;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText num1, num2, num3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        num3 = findViewById(R.id.num3);
    }

    private double getValue(EditText editText) {
        String text = editText.getText().toString();
        if (text.isEmpty()) return 0;
        return Double.parseDouble(text);
    }

    public void solveEquation(View view) {
        double a = getValue(num1);
        double b = getValue(num2);
        double c = getValue(num3);

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("a", a);
        intent.putExtra("b", b);
        intent.putExtra("c", c);
        startActivity(intent);
    }

    public void creat_random(View view) {
        Random random = new Random();
        int a = random.nextInt(10); // בין 0 ל-9
        int b = random.nextInt(10);
        int c = random.nextInt(10);

        num1.setText(String.valueOf(a));
        num2.setText(String.valueOf(b));
        num3.setText(String.valueOf(c));
    }
}
