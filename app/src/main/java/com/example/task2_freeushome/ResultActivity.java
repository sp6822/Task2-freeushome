package com.example.task2_freeushome;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    TextView resultView;
    ImageView imgParabola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultView = findViewById(R.id.resultView);
        imgParabola = findViewById(R.id.imgParabola);

        double a = getIntent().getDoubleExtra("a", 0);
        double b = getIntent().getDoubleExtra("b", 0);
        double c = getIntent().getDoubleExtra("c", 0);


        double d = b * b - 4 * a * c;
        String result;

        if (d < 0) {
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

        if (a > 0) {
            if (d > 0) {
                imgParabola.setImageResource(R.drawable.twopointssmile);
            } else if (d == 0) {
                imgParabola.setImageResource(R.drawable.onesmile);
            } else {
                imgParabola.setImageResource(R.drawable.nocuttingsmile);
            }
        } else {
            if (d > 0) {
                imgParabola.setImageResource(R.drawable.twocuttingsad);
            } else if (d == 0) {
                imgParabola.setImageResource(R.drawable.onecuttingsad);
            } else {
                imgParabola.setImageResource(R.drawable.nocuttingsad);
            }
        }
    }

    public void goBack(View view) {
        finish();
    }
}

