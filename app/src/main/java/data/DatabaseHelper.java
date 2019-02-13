package data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import model.notes_in;

public class DatabaseHelper extends SQLiteOpenHelper {
    private Context currentContext;
    public DatabaseHelper(Context context){
        super(context,Constants.DATABASE_NAME,null,Constants.DATABASE_VERSION);
        this.currentContext=context;
    }
    //arraylist to retrieve all notes in the database
    private ArrayList<notes_in>getAllnotes=new ArrayList<>();
    //array to retrieve all notes from the database
    private String[] allNotes={Constants.KD_KEY,Constants.KD_NOTES};

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_notes_table="CREATE TABLE " +Constants.NOTES_TABLE+ "("+Constants.KD_KEY+" INTEGER PRIMARY KEY AUTOINCREMENT," +Constants.KD_NOTES+" TEXT NOT NULL"+");";
        sqLiteDatabase.execSQL(create_notes_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+Constants.NOTES_TABLE);
        onCreate(sqLiteDatabase);

    }
    public long addNote(String notes){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(Constants.KD_NOTES,notes);
        long insertID=db.insert(Constants.NOTES_TABLE,null,values);
        db.close();
        return insertID;
    }
    public ArrayList<notes_in>getNotesList() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Constants.NOTES_TABLE, allNotes, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {

                notes_in Note_in = new notes_in();
                Note_in.setKd_id(cursor.getLong(cursor.getColumnIndex(Constants.KD_KEY)));
                Note_in.setNotes(cursor.getString(cursor.getColumnIndex(Constants.KD_NOTES)));
                getAllnotes.add(Note_in);
            }
            while (cursor.moveToNext());
        }
            cursor.close();
            db.close();
            return getAllnotes;

    }
    public void deleteDb(){
    SQLiteDatabase db = this.getWritableDatabase();
    long cursor =db.delete(Constants.NOTES_TABLE,null,null);
    db.close();
    }
}
