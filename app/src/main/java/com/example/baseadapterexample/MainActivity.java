package com.example.baseadapterexample;


import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends Activity {

    GridView simpleGrid;
    int animals[] = {R.drawable.animal13, R.drawable.animal14, R.drawable.animal15, R.drawable.animal16, R.drawable.animal17, R.drawable.animal18, R.drawable.animal15, R.drawable.animal16, R.drawable.animal17
            ,R.drawable.animal14, R.drawable.animal15, R.drawable.animal16, R.drawable.animal17, R.drawable.animal18, R.drawable.animal15, R.drawable.animal16, R.drawable.animal17
            ,R.drawable.animal14, R.drawable.animal15, R.drawable.animal16, R.drawable.animal17, R.drawable.animal18, R.drawable.animal15, R.drawable.animal16, R.drawable.animal17
            ,R.drawable.animal14, R.drawable.animal15, R.drawable.animal16, R.drawable.animal17, R.drawable.animal18, R.drawable.animal15, R.drawable.animal16, R.drawable.animal17};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleGrid = (GridView) findViewById(R.id.simpleGridView);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), animals);
        simpleGrid.setAdapter(customAdapter);
    }
}