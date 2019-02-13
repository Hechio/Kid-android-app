package com.ochiengs786gmail.kidwise;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.style.TtsSpan;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.CollationElementIterator;
import java.util.Random;
import java.util.Scanner;

import static com.ochiengs786gmail.kidwise.R.id.default_activity_button;

import static com.ochiengs786gmail.kidwise.R.layout.hangman_level;

/**
 * Created by Stevo The Great on 4/30/2018.
 */

public class hang_man extends AppCompatActivity {
    Menu dotMenu=null;
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(R.layout.hang_man);
    }

    public boolean dispatchKeyEvent(KeyEvent event){
        AudioManager audioManager = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
        int action = event.getAction();
        int Keycode = event.getKeyCode();
        switch (Keycode){

            case KeyEvent.KEYCODE_VOLUME_UP:
                if (action == KeyEvent.ACTION_DOWN){
                    audioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
                }
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                if (action == KeyEvent.ACTION_DOWN){
                    audioManager.adjustVolume(AudioManager.ADJUST_LOWER, AudioManager.FLAG_PLAY_SOUND);
                }
                return true;
            default:
                return super.dispatchKeyEvent(event);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hang_man);
        Button easy = (Button) findViewById(R.id.hang_level1);


        Button hard = (Button) findViewById(R.id.hang_level3);
        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.right);
                mediaPlayer.setVolume(1, 3);
                mediaPlayer.start();

                Intent intent_level1 = new Intent(hang_man.this, hangman_level.class);
                startActivity(intent_level1);

            }
        });

        Button medium = (Button) findViewById(R.id.hang_level2);
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.right);
                mediaPlayer.setVolume(1, 3);
                mediaPlayer.start();

                Intent intent_level1 = new Intent(hang_man.this, hangman_level.class);
                startActivity(intent_level1);

            }
        });
        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.right);
                mediaPlayer.setVolume(1, 3);
                mediaPlayer.start();

                Intent intent_level1 = new Intent(hang_man.this, hangman_level.class);
                startActivity(intent_level1);


            }
        });

        Toolbar toolbar_hang = (Toolbar) findViewById(R.id.toolbar_hang);
        toolbar_hang.setTitle("Hang Man");
        toolbar_hang.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        toolbar_hang.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.rules,menu);
        dotMenu=menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.rule1:
                Toast toast= Toast.makeText(this,"You have 10 seconds to guess a number",Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
            case R.id.rule2:
                Toast toast1= Toast.makeText(this,"You have 3 guesses",Toast.LENGTH_LONG);
                toast1.setGravity(Gravity.CENTER,0,0);
                toast1.show();
            case R.id.rule3:
                Toast toast2= Toast.makeText(this,"You will be hanged if time elapse or no guess left",Toast.LENGTH_LONG);
                toast2.setGravity(Gravity.CENTER,0,0);
                toast2.show();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}




