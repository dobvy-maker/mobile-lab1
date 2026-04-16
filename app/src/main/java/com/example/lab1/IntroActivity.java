package com.example.lab1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        EditText editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);
        TextView textView = findViewById(R.id.textViewResult);

        button.setOnClickListener(v -> {
            String input = editText.getText().toString().trim();

            if (!input.isEmpty()) {
                textView.setText("Witaj " + input);
            } else {
                textView.setText("Przedstaw się.");
            }
        });
    }
}