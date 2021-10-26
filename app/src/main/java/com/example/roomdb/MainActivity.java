package com.example.roomdb;

import static com.example.roomdb.Dataconst.DB_Name;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
// 5 initialise database object
    Mydatabase mydatabase;


    private EditText Name_ob,father_name, phone_no;
    private Button save_btn_ob, showbutton_ob;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //create database
        mydatabase=Room.databaseBuilder(this,Mydatabase.class,DB_Name).allowMainThreadQueries().build();

        Name_ob=findViewById(R.id.nameid);
        father_name=findViewById(R.id.FatherNameid);
        phone_no=findViewById(R.id.Phoneid);
        save_btn_ob=findViewById(R.id.savebtnid);
        showbutton_ob=findViewById(R.id.button_show_id);

        save_btn_ob.setOnClickListener((v)-> {
// check if the layout field is empty then show
         if(Name_ob.getText().toString().length()==0){
             Toast.makeText(MainActivity.this,"please enter user name",Toast.LENGTH_SHORT).show();
         }
         else if (father_name.getText().toString().length()==0){
             Toast.makeText(MainActivity.this,"please enter father name",Toast.LENGTH_SHORT).show();
         }
         else if(phone_no.getText().toString().length()==0){
             Toast.makeText(MainActivity.this,"please enter user phone number",Toast.LENGTH_SHORT).show();
         }

         else {
             //initialise and Mydatabase access inner class method
             DetailinfDao detailinfoDao =mydatabase.detailinfoDao();
             Mydetailinfo mydetailinfo=new Mydetailinfo();
             //model class object memory alc
             //initialise setter method
             mydetailinfo.setName(Name_ob.getText().toString());
             mydetailinfo.setFatherName(father_name.getText().toString());
             mydetailinfo.setPhoneNumber(phone_no.getText().toString());

             //save data now by passing the object as human to insert method
             detailinfoDao.insertUserDetail(mydetailinfo);
              Toast.makeText(MainActivity.this,"saved succesfully",Toast.LENGTH_SHORT).show();
         }

        });


        //show data onclick
        showbutton_ob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this,NextActivity.class));

            }
        });


    }
}