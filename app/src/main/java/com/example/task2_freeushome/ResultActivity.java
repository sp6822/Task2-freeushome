package com.example.task2_freeushome;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultView = findViewById(R.id.resultView);

        // קבלת הנתונים
        double a = getIntent().getDoubleExtra("a", 0);
        double b = getIntent().getDoubleExtra("b", 0);
        double c = getIntent().getDoubleExtra("c", 0);

        // חישוב דלתא
        double d = b * b - 4 * a * c;
        String result;

        if (a == 0) {
            // אם a=0 → לא משוואה ריבועית
            if (b == 0) {
                result = (c == 0) ? "יש אינסוף פתרונות" : "אין פתרון";
            } else {
                double x = -c / b;
                result = "משוואה קווית:\nפתרון יחיד: x = " + x;
            }
        } else if (d < 0) {
            result = "אין פתרונות ממשיים";
        } else if (d == 0) {
            double x = -b / (2 * a);
            result = "פתרון יחיד: x = " + x;
        } else {
            double x1 = (-b + Math.sqrt(d)) / (2 * a);
            double x2 = (-b - Math.sqrt(d)) / (2 * a);
            result = "שני פתרונות:\nx1 = " + x1 + "\nx2 = " + x2;
        }

        resultView.setText(result);
    }

    // כפתור חזרה
    public void goBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
