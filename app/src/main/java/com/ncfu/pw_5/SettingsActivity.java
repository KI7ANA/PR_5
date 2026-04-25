package com.ncfu.pw_5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    private RadioGroup radioGroupCount;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        radioGroupCount = findViewById(R.id.radioGroupCount);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroupCount.getCheckedRadioButtonId();
                int circleCount = 1;

                if (selectedId == R.id.radioTwo) {
                    circleCount = 2;
                } else if (selectedId == R.id.radioThree) {
                    circleCount = 3;
                }

                Intent resultIntent = new Intent();
                resultIntent.putExtra("CIRCLE_COUNT", circleCount);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}