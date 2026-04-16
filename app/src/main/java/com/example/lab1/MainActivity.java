package com.example.lab1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.editGuess);
        Button button = findViewById(R.id.buttonGuess);
        TextView textView = findViewById(R.id.textResult);


        int[] randomNumber = {(int)(Math.random() * 10) + 1};
        int[] attempts = {0};

        button.setOnClickListener(v -> {
            String input = editText.getText().toString();

            if (input.isEmpty()) {
                textView.setText("Please enter an integer number.");
                return;
            }

            int guess;

            try {
                guess = Integer.parseInt(input);
            } catch (Exception e) {
                textView.setText("Please enter an integer number.");
                return;
            }

            if (guess < 1 || guess > 10) {
                textView.setText("Number must be in range 1..10.");
                return;
            }

            attempts[0]++;
            if (guess < randomNumber[0]) {
                textView.setText("Value too small");
            } else if (guess > randomNumber[0]) {
                textView.setText("Value too large");
            } else {
                if (attempts[0] == 2) {
                    textView.setText("Correct — achieved on the 2nd attempt");
                } else {
                    textView.setText("Correct, but not on the 2nd attempt. Try again.");
                    randomNumber[0] = (int)(Math.random() * 10) + 1;
                    attempts[0] = 0;
                }
            }
        });
    }
}