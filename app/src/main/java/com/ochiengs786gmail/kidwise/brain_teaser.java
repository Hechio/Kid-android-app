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

import static android.R.attr.id;

/**
 * Created by Stevo The Great on 5/1/2018.
 */

public class brain_teaser extends AppCompatActivity {
    private Button submit,next,previous;
    private String answer;
    private EditText brain_edit;
    private TextView brain_text;
    private TextSwitcher brain_switcher;
    private static final String[]  brain_teasers= {"If Red House is in West,Blue House in the East and Black House in the North, where is White House?",
    "John the butcher has a friend who weighs 60kgs, what does John weigh? "};
    private static final String[] teasers_answer={"America","Meat"};
    private int mposition=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.brain_teaser_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_brain);
        toolbar.setTitle("Brain Teasers");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

       toolbar.setNavigationOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               finish();
           }
       });

       submit=(Button)findViewById(R.id.btn_brain);
       next=(Button)findViewById(R.id.brain_next);
       previous=(Button)findViewById(R.id.brain_prev);
       brain_edit=(EditText)findViewById(R.id.brain_edit_text);
       brain_text=(TextView)findViewById(R.id.brain_feedback);
       brain_switcher=(TextSwitcher)findViewById(R.id.brain_switcher);

       brain_switcher.setFactory(new ViewSwitcher.ViewFactory() {
           @Override
           public View makeView() {
               TextView textView = new TextView(getApplicationContext());
               textView.setTextSize(20);
               textView.setText(brain_teasers[mposition]);
               previous.setEnabled(false);
               previous.setTextColor(Color.GRAY);
               previous.setBackgroundResource(R.drawable.btn_disabled);
               return textView;
           }
       });
       next.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(mposition<brain_teasers.length-1){
                   mposition++;
                   brain_switcher.setText(brain_teasers[mposition]);
                   previous.setEnabled(true);
                   previous.setTextColor(Color.BLACK);
                   previous.setBackgroundResource(R.drawable.button_games);
               }
               else {
                   next.setBackgroundResource(R.drawable.btn_disabled);
                   next.setTextColor(Color.GRAY);
                   previous.setEnabled(true);
               }
               brain_edit.setText(" ");
               brain_text.setText(" ");
           }
       });
       previous.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(mposition<=brain_teasers.length-1 && mposition!=0){
                   mposition--;
                   brain_switcher.setText(brain_teasers[mposition]);
                   next.setEnabled(true);
                   next.setTextColor(Color.BLACK);
                   next.setBackgroundResource(R.drawable.button_games);
               }

               else {
                   previous.setEnabled(false);
                   previous.setBackgroundResource(R.drawable.btn_disabled);
                   previous.setTextColor(Color.GRAY);
                   next.setEnabled(true);
                   next.setTextColor(Color.BLACK);
                   next.setBackgroundResource(R.drawable.button_games);
               }
               brain_edit.setText(" ");
               brain_text.setText(" ");
           }

       });
       submit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
            answer=brain_edit.getText().toString().trim();
            if(answer.equals(teasers_answer[mposition])){
                brain_text.setText("Congratulations! Press next to continue");
            }
            else {
                brain_text.setText("Oops! Try again.");
            }
           }
       });
    }
}
