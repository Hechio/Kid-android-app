package com.ochiengs786gmail.kidwise;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

/**
 * Created by Stevo The Great on 5/1/2018.
 */

public class what_is extends AppCompatActivity {

    private Button prev_btn,next_btn;
    private TextSwitcher what_switcher;
    private static final String[] WHAT_PUZ = {"What is round,flat and have two eyes but cannot see?",
            "What has a neck but no head, has arms but no hands ?", "What is full all-day but empty at night and is be used to walk?","What is it that you look at it but you see yourself?" };
    private static final String[] answers = {"Button", "Shirt", "Shoes","Mirror"};
    String[] hint = {"Starts with B and ends with n","Starts with S and ends with t","Starts with S and comes in pairs.","Can be broken."};
    private int mPosition = 0;
    TextView what_feed;
    EditText what_answer;
    Button what_submit;
    String answer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.whatis_layout);

        what_feed = (TextView) findViewById(R.id.what_feedback);
        what_answer = (EditText) findViewById(R.id.what_answer);
        what_submit = (Button) findViewById(R.id.btn_what_puz);
        prev_btn = (Button) findViewById(R.id.What_prev);
        next_btn = (Button) findViewById(R.id.What_next);

        what_switcher = (TextSwitcher) findViewById(R.id.what_switcher);
        what_switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView txtViw = new TextView(getApplicationContext());
                txtViw.setTextSize(20);

                txtViw.setText(WHAT_PUZ[mPosition]);
                prev_btn.setEnabled(false);
                prev_btn.setTextColor(Color.GRAY);
                prev_btn.setBackgroundResource(R.drawable.btn_disabled);
                return txtViw;
            }
        });


        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mPosition < WHAT_PUZ.length - 1) {
                    mPosition++;
                    what_switcher.setText(WHAT_PUZ[mPosition]);
                    prev_btn.setEnabled(true);
                    prev_btn.setTextColor(Color.BLACK);
                    prev_btn.setBackgroundResource(R.drawable.button_games);


                } else if (mPosition == WHAT_PUZ.length - 1) {
                    next_btn.setEnabled(false);
                    next_btn.setTextColor(Color.GRAY);
                    next_btn.setBackgroundResource(R.drawable.btn_disabled);
                    prev_btn.setEnabled(true);

                }
                what_answer.setText("");
                what_feed.setText("");

            }
        });

        prev_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ((mPosition <= WHAT_PUZ.length - 1) && (mPosition != 0)) {
                    mPosition = mPosition - 1;
                    what_switcher.setText(WHAT_PUZ[mPosition]);
                    next_btn.setEnabled(true);
                    next_btn.setBackgroundResource(R.drawable.button_games);
                    next_btn.setTextColor(Color.BLACK);

                } else if (mPosition <= 0) {

                    prev_btn.setEnabled(false);
                    prev_btn.setTextColor(Color.GRAY);
                    prev_btn.setBackgroundResource(R.drawable.btn_disabled);
                    next_btn.setEnabled(true);
                    next_btn.setEnabled(true);
                    next_btn.setBackgroundResource(R.drawable.button_games);
                }
                what_answer.setText("");
                what_feed.setText("");


            }
        });

        what_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer = what_answer.getText().toString().trim();

                if (answer.equals(answers[mPosition])){
                    what_feed.setText("Congratulations! Press next to proceed.");
                }
                else {

                    what_feed.setText("Oops! The correct answer is " +answers[mPosition]);
                }


            }
        });


        Toolbar toolbar_what = (Toolbar) findViewById(R.id.toolbar_what);
        toolbar_what.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar_what.setTitle("Who Am I");
        toolbar_what.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
