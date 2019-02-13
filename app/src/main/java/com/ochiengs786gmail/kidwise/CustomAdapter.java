package com.ochiengs786gmail.kidwise;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import model.notes_in;

@SuppressWarnings("ConstantConditions")
public class CustomAdapter extends ArrayAdapter {
    private Activity context;
    private ArrayList<notes_in>allnoted;

    public CustomAdapter(Activity context,int resource, ArrayList<notes_in>objects){
        super(context,R.layout.custom_layout,objects);
        this.context = context;
        this.allnoted = objects;
    }

    @Override
    public int getCount() {
        return allnoted.size();
    }


   @Nullable
   @Override
    public notes_in getItem(int position) {
        return null;
    }

    @Override
    public int getPosition(@Nullable Object item) {
        return super.getPosition(item);
    }


    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder   viewHolder= null;


        if((convertView==null)||(convertView.getTag())==null){
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView=inflater.inflate(R.layout.custom_layout,null);
            viewHolder=new ViewHolder();
            viewHolder.vNotes= (TextView)convertView.findViewById(R.id.custom_notes);

            convertView.setTag(viewHolder);
        }else { viewHolder=(ViewHolder) convertView.getTag();}

        viewHolder.vNotes_in=getItem(position);
        viewHolder.vNotes.setText(allnoted.get(position).getNotes());
        return convertView;
    }
    public class ViewHolder{
        notes_in vNotes_in;
        TextView vNotes;
    }


}

