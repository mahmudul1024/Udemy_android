package com.example.cardviwapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Myadapter extends RecyclerView.Adapter<Myadapter.MyviewHolder> {

//step 1 variable and constructor

  private   List<Models_Data>applist;    //arraylist will be entered
  private   Context context;             //context will be  added

    public Myadapter(List<Models_Data> applist, Context context){
        this.applist=applist;
        this.context=context;
    }
  //  step 2  Implementing methods of Myviewholder for Views
    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){

        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_app, parent, false);

        return new MyviewHolder(view);




    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position){
        Models_Data models_data= applist.get(position); //element position on array

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        holder.txtob1.setText(models_data.getName()); //after getting the position now set text there
        holder.txtob2.setText(models_data.getNoofdownloads()+ "Users");
        //set or load the image using Glide library
        // For a simple view:

        Glide.with(context).load(models_data.getThumnail()).into(holder.imgob);


    }

    @Override
    public int getItemCount(){
        return applist.size();
    }


    //Step 3 Myviewholder class
    public class MyviewHolder extends RecyclerView.ViewHolder {
       //creating reference from single view
      public   TextView txtob1, txtob2;
      public   ImageView imgob;


//matching constructor of Myviewholder
        public MyviewHolder(@NonNull View itemView){
            super(itemView);
            //help those objects to find the item view in single layer
            txtob1=itemView.findViewById(R.id.textView1id);
            txtob2=itemView.findViewById(R.id.textView2id);
            imgob=itemView.findViewById(R.id.imageViewid);



        }
    }



}
