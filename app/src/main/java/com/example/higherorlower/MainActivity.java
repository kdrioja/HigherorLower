package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int guess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set up random number
        /*
        Random r = new Random();
        int low = 10;
        int high = 100;
        int result = r.nextInt(high-low) + low;
         */
        Random random = new Random();
        guess = random.nextInt(20 - 1) + 1;
    }

    public void onGuessClick(View view) {
        Log.i("Info", "Button was pressed.");

        EditText guessEditText = findViewById(R.id.guessEditText);
        int currentGuess = Integer.parseInt(guessEditText.getText().toString());
        String message;

        if (currentGuess < guess) {
            message = "Higher!";
        }
        else if (currentGuess > guess) {
            message = "Lower!";
        }
        else {
            message = "Correct!";
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        Log.i("Target", Integer.toString(guess));
        Log.i("Guess", Integer.toString(currentGuess));
    }
}