package com.example.cusnavigationlayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

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
toolbar=null;
        toolbar=findViewById(R.id.toolbarid);
        setSupportActionBar(toolbar);  //start of drawerview
        drawerLayout=findViewById(R.id.drwerid);
        navigationView=findViewById(R.id.navid);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        toggle.syncState();
        //to whom the toggle will listen or abide by
        drawerLayout.addDrawerListener(toggle);

        //for selction of navigation item
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item){

                switch (item.getItemId())     //Menuitem id
                {
                    case R.id.busid:
                        Toast.makeText(getApplicationContext(), "bus panel is open", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);

                        break;

                    case R.id.flightid:
                        Toast.makeText(getApplicationContext(), "flight panel is open", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.trainid:

                        Toast.makeText(getApplicationContext(), "train panel is open", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;


                }




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
