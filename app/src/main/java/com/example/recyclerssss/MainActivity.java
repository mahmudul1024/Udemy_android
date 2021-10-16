package com.example.recyclerssss;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter myAdapter;
//this arraylist will go to Models
    List<Models>arraylist =new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recid);
        myAdapter=new MyAdapter (arraylist) ;      //sending the array

        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this);
        //apply getContex()
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myAdapter);


        InsertData();

    }

    private void InsertData(){
        Models movie=new Models("Fast and furius","Action","2022");
        arraylist.add(movie);  //added a movie object to arraylist which will be later sent to the MyAdapter

        movie=new Models("Fast and furius 9","Action","2022");
        arraylist.add(movie);
        movie=new Models("Fast and furius 9","Action","2022");
        arraylist.add(movie);movie=new Models("Fast and furius 9","Action","2022");
        arraylist.add(movie);movie=new Models("Fast and furius 9","Action","2022");
        arraylist.add(movie);movie=new Models("Fast and furius 9","Action","2022");
        arraylist.add(movie);movie=new Models("Fast and furius 9","Action","2022");
        arraylist.add(movie);movie=new Models("Fast and furius 9","Action","2022");
        arraylist.add(movie);movie=new Models("Fast and furius 9","Action","2022");
        arraylist.add(movie);movie=new Models("Fast and furius 9","Action","2022");
        arraylist.add(movie);movie=new Models("Fast and furius 9","Action","2022");
        arraylist.add(movie);movie=new Models("Fast and furius 9","Action","2022");
        arraylist.add(movie);
    }


}