package com.example.terras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        ListView listView;  //obj of Listview which can access to the builtin methods
    //of Listview



    //Data to be displayed
    String [] Mobiletypes={"samsung 123", "Iphone x","Iphone pro","Galaxy N",
            "Zte axon",
            "Huwei lite","Nokia pro","Google pixel","Nexus 12","Iphone xever","Iphone max"};
 // data need to pass by an adapter, we will use readymade Adapter as Arrayadapter

     //Oncreate method is overriden ,so here we created a view as same as our xml
    // by the object
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //You can populate an AdapterView such as ListView or GridView by binding the A
        // dapterView instance to an Adapter, which retrieves
        // data from an external source and creates a View that represents each data entry.

        listView=findViewById(R.id.listviewid);
        //if you have an array of strings you want to display in a ListView, initialize a new ArrayAdapter using
        // a constructor to specify the layout for each string and the string array:

     //   initialize a new ArrayAdapter using a constructor
        //it is a builtin adapter so we dont need to build one extra by ourselves
        ArrayAdapter adapter=new ArrayAdapter<String>(
            this, android.R.layout.simple_list_item_1,Mobiletypes);

        //Arrayadapter will connects the layout to the data
        listView.setAdapter(adapter);



      //  Handling click events
      //  You can respond to click events on each item in an AdapterView
      //  by implementing the AdapterView.OnItemClickListener interface. For example:
        // Create a message handling object as an anonymous class.

        // simply copy paste
        AdapterView.OnItemClickListener messageClickedHandler = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {

                Context context = getApplicationContext();
                CharSequence text = "item has been clicked!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();



            }
        };

        listView.setOnItemClickListener(messageClickedHandler);


//copy paste untill here


    }



}


//Android provides several subclasses of Adapter that are useful
// for retrieving different kinds of data and
// building views for an AdapterView. The two most common adapters are:
//ArrayAdapter
//Use this adapter when your data source is an array. By default, ArrayAdapter creates a view for each array item
// by calling toString() on each item and placing the contents in a TextView.
//SimpleCursorAdapter
//    Use this adapter when your data comes from a Cursor.
//    When using SimpleCursorAdapter,
//    you must specify a layout to use for each row in the Cursor
// and which columns in the Cursor should be inserted into which views of the layout.
//For example, if you want to create a list of people's names
// and phone numbers, you can perform a query that returns a Cursor containing a row for each person and columns for the names and numbers. You then create a string array specifying which columns from the Cursor you want in the layout for each result and an integer
// array specifying the corresponding views that each column should be placed:

// Summery ..we created listview from xml layout ,then created object ,initialised
//by refering layout
//used builtin Adapter ...Thats it!!!!!!!!!!!!!!!!