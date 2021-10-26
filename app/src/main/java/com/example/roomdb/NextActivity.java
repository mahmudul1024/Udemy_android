package com.example.roomdb;


import static com.example.roomdb.Dataconst.DB_Name;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class NextActivity extends AppCompatActivity {
 //this activity is for getting the query
    Mydatabase mydatabase_next;         //database object
    DetailinfDao detailinfDao_next;        //Dao object
    List<Mydetailinfo> mydetailinfo_next;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        mydatabase_next=Room.databaseBuilder(this,Mydatabase.class,DB_Name).allowMainThreadQueries().build();
        //inner class method accesed
        detailinfDao_next=mydatabase_next.detailinfoDao();
        //query result will store on list and type of modelclass object
        mydetailinfo_next=detailinfDao_next.fetchAllData();


// find the layout and initialise Layoutmanager
            recyclerView=findViewById(R.id.recview_id);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        //now Adapter

        if(mydetailinfo_next.size()>0)
        {
            RecycleAdapter dataAdapter=new RecycleAdapter(NextActivity.this,mydetailinfo_next);
            recyclerView.setAdapter(dataAdapter);

        }


    }
}