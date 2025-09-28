package com.example.task2_freeushome;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

    private Double getValue(EditText editText) {
        String text = editText.getText().toString().trim();

        if (text.isEmpty() || text.equals("-") || text.equals(".") || text.equals("0")) {
            Toast.makeText(this, "קלט לא תקין! הכנס מספר חוקי", Toast.LENGTH_SHORT).show();
            return null;
        }

        try {
            return Double.parseDouble(text);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "קלט לא תקין! הכנס מספר חוקי", Toast.LENGTH_SHORT).show();
            return null;
        }
    }

    public void solveEquation(View view) {
        Double a = getValue(num1);
        Double b = getValue(num2);
        Double c = getValue(num3);

        if (a == null || b == null || c == null) {
            return;
        }

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("a", a);
        intent.putExtra("b", b);
        intent.putExtra("c", c);

    }

    public void creat_random(View view) {
        Random random = new Random();
        int a = random.nextInt(10);
        int b = random.nextInt(10);
        int c = random.nextInt(10);

        num1.setText(String.valueOf(a));
        num2.setText(String.valueOf(b));
        num3.setText(String.valueOf(c));
    }
}
