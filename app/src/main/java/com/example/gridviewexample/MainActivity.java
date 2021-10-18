package com.example.gridviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView simpleList;
    ArrayList birdList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleList = (GridView) findViewById(R.id.simpleGridView);
        birdList.add(new Item("Bird 1",R.drawable.c));
        birdList.add(new Item("Bird 2",R.drawable.code));
        birdList.add(new Item("Bird 3",R.drawable.programming));
        birdList.add(new Item("Bird 4",R.drawable.c));
        birdList.add(new Item("Bird 5",R.drawable.tick));
        birdList.add(new Item("Bird 6",R.drawable.programming));

        MyAdapter myAdapter=new MyAdapter(this,R.layout.grid_view_items,birdList);
        simpleList.setAdapter(myAdapter);

    }
}