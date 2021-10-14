package com.example.glide_pro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    ImageView imageView  ;
    //object of imageview so that we can pass the object as a complte human to the library method
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView=findViewById(R.id.imageViewid);
        //help the object to find the organs of it on xml or assigning

        Glide.with(this).load(R.drawable.bronxpizza).into(imageView);
        //now the object has linked or gained a picture as its organ



    }
}