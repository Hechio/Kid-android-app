package com.ochiengs786gmail.kidwise;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toolbar;

/**
 * Created by Stevo The Great on 5/1/2018.
 */

public class shapes extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shapes);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_shapes);
        toolbar.setTitle("Shapes");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
