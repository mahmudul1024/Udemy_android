package com.example.terras;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
        ListView listView;  //obj of Listview which can access to the builtin methods
    //of Listview

    //creating data
    String[] title={ "Master Android App","Master C programming","Master C++",
                      "Master OSX","Master linux", "Master Flutter","Master in all"};


    String[] description ={"Learn Android app ","Learn C programming","Learn C++","Learn C++"
    ,"Learn C++","Learn C++","Learn all"};

    //Images as an integer array

    Integer[] imagearray={R.drawable.bronx4,R.drawable.bronx6,R.drawable.bronx8,R.drawable.bronxburg,
            R.drawable.bronxburg,R.drawable.bronxpizza,R.drawable.bronx6};


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Custom_Adapter custom_adapter=new Custom_Adapter(this,title,description,imagearray);

      listView =findViewById(R.id.listid);
      listView.setAdapter(custom_adapter);


    }



}
