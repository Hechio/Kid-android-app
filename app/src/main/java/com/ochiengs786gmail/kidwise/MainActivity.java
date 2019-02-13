package com.ochiengs786gmail.kidwise;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import android.support.annotation.NonNull;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;

import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public Toolbar toolbar;
    public Button button;
    public EditText editText;
    public TextView textView;
    public PopupMenu popupMenu1;


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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        button = (Button) findViewById(R.id.bnt10);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.right);
                mediaPlayer.setVolume(1,3);
                mediaPlayer.start();

                int i;
                editText = (EditText) findViewById(R.id.career_entry);
                textView = (TextView) findViewById(R.id.reply);
                String s = editText.getText().toString();
                if (s.equals("Thief") || (s.equals("Smuggler")) || (s.equals("Terrorist")) || (s.equals("Drug Dealer"))){
                    textView.setText("That is illegal, you will be jailed");
                    return;

                }

               else if (s.startsWith("a") || (s.startsWith("e")) || (s.startsWith("i")) || (s.startsWith("o")) || (s.startsWith("u")) ||
                        s.startsWith("A") || (s.startsWith("E")) || (s.startsWith("I")) || (s.startsWith("O")) || (s.startsWith("U"))) {
                    textView.setText("That is cool! work hard to be an " + editText.getText().toString() + "!");
                } else if (s.isEmpty()) {
                    textView.setText("Please enter your career");

                }




                else {

                    textView.setText("That is cool! work hard to be a " + editText.getText().toString() + "!");
                }
                editText.setText("");
            }
        });


        final Button button1 = (Button) findViewById(R.id.games);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.right);
                mediaPlayer.setVolume(1,3);
                mediaPlayer.start();

                popupMenu1 = new PopupMenu(MainActivity.this, button1);
                popupMenu1.getMenuInflater().inflate(R.menu.games, popupMenu1.getMenu());
                popupMenu1.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        item.getItemId();
                        switch (item.getItemId()) {
                            case R.id.hang_man:
                                Intent intent_game = new Intent(MainActivity.this, hang_man.class);
                                startActivity(intent_game);
                                return true;
                            case R.id.num_guess:
                                Intent intent_game1 = new Intent(MainActivity.this, number_guess.class);
                                startActivity(intent_game1);
                                return true;

                            default:
                                return true;
                        }
                    }

                });
                popupMenu1.show();
            }
        });
        final Button button2 = (Button) findViewById(R.id.puzzle);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.right);
                mediaPlayer.setVolume(1,3);
                mediaPlayer.start();

                PopupMenu popupMenu2 = new PopupMenu(MainActivity.this, button2);
                popupMenu2.getMenuInflater().inflate(R.menu.puzzles_menu, popupMenu2.getMenu());
                popupMenu2.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item1) {
                        item1.getItemId();
                        switch (item1.getItemId()) {
                            case R.id.whoam:
                                Intent intent1 = new Intent(MainActivity.this, puzzle_who.class);
                                startActivity(intent1);
                                return true;
                            case R.id.whatis:
                                Intent intent2 = new Intent(MainActivity.this, what_is.class);
                                startActivity(intent2);
                                return true;
                            case R.id.brain:
                                Intent intent3 = new Intent(MainActivity.this, brain_teaser.class);
                                startActivity(intent3);
                                return true;
                            default:
                                return true;
                        }

                    }

                });
                popupMenu2.show();
            }


        });

        final Button button3 = (Button) findViewById(R.id.journal);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.right);
                mediaPlayer.setVolume(1,3);
                mediaPlayer.start();
                Intent intent_diary = new Intent(MainActivity.this, diary.class);
                startActivity(intent_diary);
            }


        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);
    }

        @Override
        public boolean onNavigationItemSelected (@NonNull MenuItem item){
             item.getItemId();
            switch (item.getItemId()){
                case R.id.idItem_who:
                // activity transition
                    MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.right);
                    mediaPlayer.setVolume(1,3);
                    mediaPlayer.start();

                    Intent intent1 = new Intent(MainActivity.this, puzzle_who.class);
                    startActivity(intent1);
                    return true;
                case R.id.idItem_what:
                    // activity change
                     mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.right);
                    mediaPlayer.setVolume(1,3);
                    mediaPlayer.start();

                    Intent intent_what = new Intent(MainActivity.this, what_is.class);
                    startActivity(intent_what);
                    return true;
                case R.id.idItem_brain:
                    // activity change
                    mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.right);
                    mediaPlayer.setVolume(1,3);
                    mediaPlayer.start();

                    Intent intent_brain = new Intent(MainActivity.this, brain_teaser.class);
                    startActivity(intent_brain);
                    return true;
                case R.id.idItem_hang:
                   // activity change
                    mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.right);
                    mediaPlayer.setVolume(1,3);
                    mediaPlayer.start();

                    Intent intent_change = new Intent(MainActivity.this, hang_man.class);
                    startActivity(intent_change);
                    return true;
                case R.id.idItem_numb:
                    // activity change
                    mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.right);
                    mediaPlayer.setVolume(1,3);
                    mediaPlayer.start();

                    Intent intent_numb = new Intent(MainActivity.this, number_guess.class);
                    startActivity(intent_numb);
                    return true;
                case R.id.idItem3:
                        //activity change
                    mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.right);
                    mediaPlayer.setVolume(1,3);
                    mediaPlayer.start();

                    Intent intent_diary = new Intent(MainActivity.this, diary.class);
                    startActivity(intent_diary);
                    return true;
                case R.id.idItem4:
                            //activity change
                    mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.right);
                    mediaPlayer.setVolume(1,3);
                    mediaPlayer.start();

                    Intent intent_animal = new Intent(MainActivity.this, shapes.class);
                    startActivity(intent_animal);
                    return true;
                case R.id.idItem5:
                                //change to tongue twister
                    mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.right);
                    mediaPlayer.setVolume(1,3);
                    mediaPlayer.start();
                    Intent intent_twister = new Intent(MainActivity.this, tongue_twister.class);
                    startActivity(intent_twister);
                    return true;
                case R.id.idItem6:
                                    //change to colors
                    mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.right);
                    mediaPlayer.setVolume(1,3);
                    mediaPlayer.start();
                    Intent intent_color = new Intent(MainActivity.this, color_kid.class);
                    startActivity(intent_color);
                    return true;


            }
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }


    }


