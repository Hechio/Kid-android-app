package com.ochiengs786gmail.kidwise;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.List;

import data.DatabaseHelper;


/**
 * Created by Stevo The Great on 6/14/2018.
 */

public class write_diary extends AppCompatActivity {
    private DatabaseHelper my_helper;
    private EditText note_text;
   private ImageButton save_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_diary);
        my_helper = new DatabaseHelper(getApplicationContext());
        note_text= (EditText) findViewById(R.id.note);
        save_btn= (ImageButton) findViewById(R.id.diary_save);

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String note = note_text.getText().toString();
                long id=my_helper.addNote(note);
                Intent intentd = new Intent(write_diary.this,diary.class);
                startActivity(intentd);


            }
        });

    }

}
