package com.ochiengs786gmail.kidwise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;


/**
 * Created by Stevo The Great on 4/27/2018.
 */

public class puzzle_who extends AppCompatActivity {

    private Button prev_btn,next_btn;
    private TextSwitcher who_switcher;
    private static final String[] WHO_PUZ = {"I am a table but you cannot eat on me, who am I?",
            "I enter from the West but leave through East, who am I?", "I can make thoughts visible, who am I?","When you cut me, i make you cry,who am I" };
    private static final String[] answers = {"Vegetable", "Sun", "Pen","Onions"};
    private int mPosition = 0;
    TextView who_feed;
    EditText who_answer;
    Button who_submit;
    String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puzzles_layout);
         who_feed = (TextView) findViewById(R.id.who_feedback);
         who_answer = (EditText) findViewById(R.id.who_answer);
         who_submit = (Button) findViewById(R.id.btn_who_puz);
        prev_btn = (Button) findViewById(R.id.Who_prev);
        next_btn = (Button) findViewById(R.id.Who_next);

        who_switcher = (TextSwitcher) findViewById(R.id.puz_txtswi);
        who_switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView txtViw = new TextView(getApplicationContext());
                txtViw.setTextSize(20);

                txtViw.setText(WHO_PUZ[mPosition = 0]);
                prev_btn.setVisibility(View.INVISIBLE);
                return txtViw;
            }
        });

        who_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer = who_answer.getText().toString().trim();

                if (answer.equals(answers[mPosition])){
                    who_feed.setText("Congratulations! Press next to proceed.");
                }
                else {

                    who_feed.setText("Oops! The correct answer is " +answers[mPosition]);
                }

            }
        });
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 who_answer.setText("");
                who_feed.setText("");
                if (mPosition < WHO_PUZ.length - 1) {
                    prev_btn.setVisibility(View.VISIBLE);
                    mPosition++;
                    who_switcher.setText(WHO_PUZ[mPosition]);
                } else if (mPosition == WHO_PUZ.length - 1) {
                    next_btn.setVisibility(View.INVISIBLE);
                    prev_btn.setVisibility(View.VISIBLE);

                } else {
                    who_switcher.setText(WHO_PUZ[mPosition = 2]);
                }
            }
        });

        prev_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                who_answer.setText("");
                who_feed.setText("");
                if ((mPosition <= WHO_PUZ.length - 1) && (mPosition != 0)) {
                    mPosition = mPosition - 1;
                    who_switcher.setText(WHO_PUZ[mPosition]);
                    next_btn.setVisibility(View.VISIBLE);
                } else if (mPosition <= 0) {

                    prev_btn.setVisibility(View.INVISIBLE);
                    next_btn.setVisibility(View.VISIBLE);
                } else {
                    prev_btn.setVisibility(View.INVISIBLE);
                }
            }
        });


        Toolbar toolbar_who = (Toolbar) findViewById(R.id.toolbar_who);
        toolbar_who.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar_who.setTitle("Who Am I");
        toolbar_who.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}

