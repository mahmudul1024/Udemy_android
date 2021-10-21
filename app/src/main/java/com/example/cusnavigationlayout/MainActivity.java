package com.example.cusnavigationlayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;  //be carefull which type of object is declaring
    //because there might have same class but two diffrent origin ..app.widget or app.widget.app



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.toolbarid);
        setSupportActionBar(toolbar);  //start of drawerview
        drawerLayout=findViewById(R.id.drwerid);
        navigationView=findViewById(R.id.navid);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);

        //to whom the toggle will listen or abide by
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();




// we want a busfragment to be displayed on the front page from the begining
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayoutid,new busfragment()).commit();
//if we worked on menu and given selected color and not selected color then this has to be added
        navigationView.setCheckedItem(R.id.busid); //remains selected

        //for selction of navigation item
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            Fragment tempfragment;

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item){


                switch (item.getItemId())     //Menuitem id
                {
                    case R.id.busid:

                       tempfragment=new busfragment();
                        break;

                    case R.id.flightid:

                        tempfragment=new flightfragment();
                        break;

                    case R.id.trainid:
                        tempfragment=new trainfragment();
                        break;

                }

                getSupportFragmentManager().beginTransaction().replace(R.id.framelayoutid,tempfragment).commit();
                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });



    }
}

//add dependency
//  design layout
//inside navigationview insert menu and header layout ,which has been designed seperately
//in the main activity initiate all the class object ,then find them ,then insert proper
// method for them
//dont forget to add layout gravity= start on the navlayout
//dont forget to add open drawer =start on drawer layout

// Extension of previous programm++++++++++++

//for using fragment framelayout is needed on mainlayout
//through Fragment manger we pick a Fragment and put it on the menu position
//start fragment transition then replace for every new fragment