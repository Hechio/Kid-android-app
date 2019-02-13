package com.ochiengs786gmail.kidwise;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import data.DatabaseHelper;
import model.notes_in;

/**
 * Created by Stevo The Great on 5/1/2018.
 */

public class diary extends AppCompatActivity {
    private ListView notes_view;
    private CustomAdapter adapter;
    private DatabaseHelper helper;
    private ArrayList<notes_in>notes=new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary_layout);

        helper=new DatabaseHelper(getApplicationContext());
        getAllNotes();
        notes_view= (ListView) findViewById(R.id.notes_view);
        adapter= new CustomAdapter(this,R.layout.custom_layout,notes);
        notes_view.setAdapter(adapter);


        Toolbar toolbar_who = (Toolbar) findViewById(R.id.toolbar_diary);
        final FloatingActionButton write_diar =(FloatingActionButton)  findViewById(R.id.float_bar1);
        toolbar_who.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar_who.setTitle("Diary");
        toolbar_who.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        write_diar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_change = new Intent(diary.this, write_diary.class);
                startActivity(intent_change);
            }
        });





}
        private ArrayList<notes_in>getAllNotes(){
        ArrayList<notes_in>arrayFromDb=helper.getNotesList();
        for (int i=0;i<arrayFromDb.size();i++){
            notes_in kid_notes = new notes_in();
            kid_notes.setKd_id(arrayFromDb.get(i).getKd_id());
            kid_notes.setNotes(arrayFromDb.get(i).getNotes());

            notes.add(kid_notes);
        }
        return notes;
        }
}
