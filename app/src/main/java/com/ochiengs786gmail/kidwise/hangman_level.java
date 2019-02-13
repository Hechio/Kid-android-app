package com.ochiengs786gmail.kidwise;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;
import java.util.Scanner;



/**
 * Created by Stevo The Great on 5/20/2018.
 */

public class hangman_level extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hangman_level);
       /* TextView textView_guess = (TextView) findViewById(guess);
        textView_guess.setText("Please guess any color starting with capital letter.");*/
        Button hang_submit = (Button) findViewById(R.id.hang1_submit);
        hang_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] color = {"Black","White","Red","Pink","Blue"};

                EditText answer_hang = (EditText) findViewById(R.id.hang_answer);
                TextView feed_back = (TextView) findViewById(R.id.feedback);
                Random rand = new Random();
                int index= rand.nextInt(color.length);
                String color_guessed;
                int remaining_guesses=3;
                int flag=0;

                while (remaining_guesses>0 && flag<1) {

                    color_guessed = answer_hang.getText().toString();
                    if (color_guessed.equals(color[index])) {

                        feed_back.setText("Congratulations! You guessed the color.");
                        flag++;

                    }
                    else {
                        remaining_guesses--;
                        feed_back.setText("You did not guess the color. Try again, You have "+remaining_guesses+ " left");
                    }
                    return;

                }
                if (remaining_guesses==0) {
                    feed_back.setText("You are Hanged! The color was "+color[index]);
                } 

            }
        });

        Toolbar toolbar_hang_level = (Toolbar) findViewById(R.id.toolbar_hangman_level);
        toolbar_hang_level.setTitle("Hang Man");
        toolbar_hang_level.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        toolbar_hang_level.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
    }


