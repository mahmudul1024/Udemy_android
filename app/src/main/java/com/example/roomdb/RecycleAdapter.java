package com.example.roomdb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewholder> {

// for showing the list ,it will be received here as list,so a list var is needed
    List<Mydetailinfo>mydetailinfoList;
    Context mcontext;

    public RecycleAdapter(NextActivity nextActivity, List<Mydetailinfo> mydetailinfo_next){
     this.mydetailinfoList=mydetailinfo_next;
     this.mcontext=nextActivity;

    }


    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.single_row_item,parent,false);
        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position){
 //binding
        holder.txname.setText(mydetailinfoList.get(position).getName());
        holder.name2.setText(mydetailinfoList.get(position).getFatherName());
        holder.phon.setText(mydetailinfoList.get(position).getPhoneNumber());

    }

    @Override
    public int getItemCount(){
        return mydetailinfoList.size();
    }

    //viewholder is inner class of adapter class and has an empty constructor
 public class MyViewholder extends RecyclerView.ViewHolder{

        //referance of single View item
        TextView txname,name2,phon;


     //empty or default constructor

        public MyViewholder(@NonNull View itemView){
            super(itemView);

            txname=itemView.findViewById(R.id.nameshow_id);
            name2=itemView.findViewById(R.id.fathe_show_id);
            phon=itemView.findViewById(R.id.Phoneid);
        }
    }

}
