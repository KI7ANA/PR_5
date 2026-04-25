package com.ncfu.pw_5;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_SETTINGS = 1;
    private TextView tvResult;
    private LinearLayout circleContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSettings = findViewById(R.id.btnSettings);
        Button btnAbout = findViewById(R.id.btnAbout);
        tvResult = findViewById(R.id.tvResult);
        circleContainer = findViewById(R.id.circleContainer);

        drawCircles(1);

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivityForResult(intent, REQUEST_CODE_SETTINGS);
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_SETTINGS) {
            if (resultCode == RESULT_OK && data != null) {
                int count = data.getIntExtra("CIRCLE_COUNT", 1);
                tvResult.setText("Количество кругов: " + count);
                drawCircles(count);
            }
        }
    }

    private void drawCircles(int count) {
        circleContainer.removeAllViews();

        for (int i = 0; i < count; i++) {
            View circle = new View(this);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(180, 180);
            params.setMargins(16, 16, 16, 16);
            circle.setLayoutParams(params);

            GradientDrawable shape = new GradientDrawable();
            shape.setShape(GradientDrawable.OVAL);

            if (i == 0) {
                shape.setColor(Color.RED);
            } else if (i == 1) {
                shape.setColor(Color.GREEN);
            } else {
                shape.setColor(Color.BLUE);
            }

            circle.setBackground(shape);
            circleContainer.addView(circle);
        }
    }
}