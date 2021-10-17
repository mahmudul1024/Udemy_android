package com.example.baseadapterexample;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends Activity {

    GridView simpleGrid;
    //sending all the images to the custom adapter
    int animals[] = {R.drawable.animal13, R.drawable.animal14, R.drawable.animal15, R.drawable.animal16, R.drawable.animal17, R.drawable.animal18, R.drawable.animal15, R.drawable.animal16, R.drawable.animal17
            ,R.drawable.animal14, R.drawable.animal15, R.drawable.animal16, R.drawable.animal17, R.drawable.animal18, R.drawable.animal15, R.drawable.animal16, R.drawable.animal17
            ,R.drawable.animal14, R.drawable.animal15, R.drawable.animal16, R.drawable.animal17, R.drawable.animal18, R.drawable.animal15, R.drawable.animal16, R.drawable.animal17
            ,R.drawable.animal14, R.drawable.animal15, R.drawable.animal16, R.drawable.animal17, R.drawable.animal18, R.drawable.animal15, R.drawable.animal16, R.drawable.animal17};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        simpleGrid = (GridView) findViewById(R.id.simpleGridView);
        //creating the object of customAdapter and sending array and context as parameters
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), animals);
       //adapter is set on gridview
        simpleGrid.setAdapter(customAdapter);



        // implement setOnItemClickListener event on GridView
        simpleGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // set an Intent to Another Activity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("image", animals[position]); // put image data in Intent
                startActivity(intent); // start Intent
            }
        });









    }
}