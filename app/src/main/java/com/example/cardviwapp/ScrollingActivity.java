package com.example.cardviwapp;

import static com.google.android.material.internal.ViewUtils.dpToPx;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.TypedValue;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.cardviwapp.databinding.ActivityScrollingBinding;

import java.util.ArrayList;
import java.util.List;

public class ScrollingActivity extends AppCompatActivity {

    private ActivityScrollingBinding binding;

    //step 1 create relevant objects
    RecyclerView recyclerView;
    private Myadapter myadapter;
    private List<Models_Data> appslist;


    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        binding=ActivityScrollingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar=binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout=binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        FloatingActionButton fab=binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // recyclerview widget

        recyclerView=findViewById(R.id.recid);
        appslist=new ArrayList<>();
        myadapter=new Myadapter(appslist, this); //sending the array with resourse

        //inside recyclerview gridview will be shown with 2 columns
        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);  //layout set inside Recy


        //extra design : Item decoration
        recyclerView.addItemDecoration(new GridSpacingItemdecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myadapter); //


        //preparing the cards
        InsertDataintoCards();


    }

    private void InsertDataintoCards()
    {
        //adds the cards data and show them
        int[] appscovers=new int[]{
                R.drawable.c,R.drawable.code,R.drawable.cplus,
                R.drawable.programming,R.drawable.programmingggg,
                R.drawable.tick
        };

        Models_Data a=new Models_Data("Master Android App",80000,appscovers[0]);
        appslist.add(a);
        a=new Models_Data("Master Android Flutter ", 9000,appscovers[1]);
        appslist.add(a);
        a=new Models_Data("Master Android Kotlin ", 9000,appscovers[2]);
        appslist.add(a);
        a=new Models_Data("Master Android C++ ", 9000,appscovers[3]);
        appslist.add(a);
        a=new Models_Data("Master Android C ", 9000,appscovers[4]);
        appslist.add(a);
        a=new Models_Data("Master Android Csharp ", 9000,appscovers[5]);
        appslist.add(a);


        //notify the change
        myadapter.notifyDataSetChanged();

    }

    private int dpToPx(int dp)
    {
        Resources r=getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp,r.getDisplayMetrics()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id=item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private class GridSpacingItemdecoration extends RecyclerView.ItemDecoration {

        private int spancount;
        private int spacing;
        private boolean includedege;

        public GridSpacingItemdecoration(int spancount, int spacing, boolean includedege){
            this.spancount=spancount;
            this.spacing=spacing;
            this.includedege=includedege;
        }

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state){

            int position=parent.getChildAdapterPosition(view);
            int column=position % spancount;

            if (includedege) {
                outRect.left=spacing - column * spacing / spancount;
                outRect.right = (column + 1) * spacing / spancount;
                if (position < spancount) {
                    outRect.top=spacing;
                }
                outRect.bottom=spacing;
            } else {
                outRect.left=column * spacing / spancount;
                outRect.right=spacing - (column + 1) * spacing / spancount;

                if (position >= spancount) {
                    outRect.top=spacing;
                }

            }
        }
    }
}