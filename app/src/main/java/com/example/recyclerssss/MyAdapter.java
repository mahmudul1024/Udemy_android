package com.example.recyclerssss;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//recieving the array from Mainactivity to the inside of MyAdapter for Viewholder
public class MyAdapter   extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    //catching the array by diffrent arrayname ,like a variable
    private List<Models> movielist;

    // Initialize the dataset of the Adapter.
    // @param dataSet String[] containing the data to populate views to be used by RecyclerV

    public MyAdapter(List<Models> movielist){
        this.movielist=movielist;
    }
    // Create new views (invoked by the layout manager)

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        // Create a new view, which defines the UI of the list item

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.simple_layout, parent, false);

        return new ViewHolder(view);

    }
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
       Models movie=movielist.get(position);
         //thats why an empty constructor was introduced on Models,which will create obj
        //and store position

        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.date.setText(movie.getDate());



    }

    @Override
    public int getItemCount(){
        return movielist.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {





//create widgets
       public TextView title,genre,date;

        public ViewHolder(@NonNull View itemView){
            super(itemView);  //parent constructor has been called

            //initialising objects
            title= itemView.findViewById(R.id.textView1id);
            genre=itemView.findViewById(R.id.textView2id);
            date=itemView.findViewById(R.id.textview3id);





        }
















    }
}