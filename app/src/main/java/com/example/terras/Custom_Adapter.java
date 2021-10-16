package com.example.terras;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class Custom_Adapter extends ArrayAdapter<String> {


//By default, the array adapter creates a view by calling Object#toString()
// on each data object in the collection you provide,
// and places the result in a TextView. You may also customize what type of
// view is used for the data object in the collection.
// To customize what type of view is used for the data object,
// override getView(int, android.view.View, android.view.ViewGroup) and inflate
// a view resource.

    //Public constructors is a must and COntext is included there so
    //we have to make a variable or object for Context also which will be
    //passed through constructor

    private final Activity context;

    private final String[] maintitle;  //string will be transferred here one by one according to their position
    private final String[] description;   //string will be transferred here one by one according to their position
    private final Integer[] imagetit;     //string will be transferred here one by one according to their position

// Constructor and initialisation of context inside constructor


    public Custom_Adapter(@NonNull  Activity context1, String[] maintitle, String[] description, Integer[] imagetit)
    {
        // now the question arrise which constructor should be called ,because there is an inbuilt constructor
        //for ArrayAdapter which is parent class of Custom_Adapter
        //we want to call their constructor as well as initialise our private variables
        //https://www.youtube.com/watch?v=VIaTJFCXE1Q
       super(context1,R.layout.item_custom_layout,maintitle);
        // super will differentiate same variable ,method or constructor
        //between base and derieved ,so super takes always to the base
        this.context=context1;
        this.maintitle=maintitle;
        this.description=description;
        this.imagetit=imagetit;
    }

    //Get a View that displays the data at the specified position in the data set.
    // You can either create a View manually or inflate it from an XML layout file.
    // When the View is inflated, the parent View (GridView, ListView...) will apply
    // default layout parameters unless you use
    // LayoutInflater.inflate(int, android.view.ViewGroup, boolean) to specify a root view and to
    // prevent attachment to the root.


    public  View getView(int position, View convertView, ViewGroup parent)
    {
       LayoutInflater inflater=context.getLayoutInflater(); //through context we bring out the resource of inbuilt layoutinflatter
       View rowView=inflater.inflate(R.layout.item_custom_layout,null,true);
       //after that we inflated the inflate area through the object then stored on View obj

TextView titletext=rowView.findViewById(R.id.txthor1);
TextView descrip=rowView.findViewById(R.id.txthor2);
ImageView imageView=rowView.findViewById(R.id.imageView2);

titletext.setText(maintitle[position]);
descrip.setText(description[position]);
imageView.setImageResource(imagetit[position]);

return  rowView;




    }


}










// Final variable ----to create constant variable
//Final method--- to prevent override
//Final class--- to prevent inheritance



//When a variable is declared with final keyword,
// its value can’t be modified, essentially, a constant.


//Initializing a final variable :
//We must initialize a final variable, otherwise compiler will throw compile-time error.
// A final variable can only be initialized once, either via an initializer or an assignment
// statement. There are three ways to initialize a final variable :
//
//    You can initialize a final variable when it is declared.This approach is the most
//    common. A final variable is called blank final variable,if it is not initialized while
//    declaration. Below are the two ways to initialize a blank final variable.
//    A blank final variable can be initialized inside instance-initializer block or inside
//    constructor. If you have more than one constructor in your class then it must be
//    initialized in all of them, otherwise compile time error will be thrown.
//A blank final static variable can be initialized inside static block.

//https://www.geeksforgeeks.org/final-keyword-java/

//Reference final variable :
//When a final variable is a reference to an object,
// then this final variable is called reference final variable.
// For example, a final StringBuffer variable looks like
//
//final StringBuffer sb;


 //   As you know that a final variable cannot be re-assign.
//   But in case of a reference final variable, internal state
//   of the object pointed by that reference variable can be changed.
//   Note that this is not re-assigning. This property of final is called
//   non-transitivity.


//The non-transitivity property also applies to arrays, because arrays are
// objects in java. Arrays with final keyword are also called final arrays.







//When a final variable is created inside a method/constructor/block,
// it is called local final variable, and it must initialize
// once where it is created. See below program for local final variable


//When a class is declared with final keyword, it is called a final class.
// A final class cannot be extended(inherited). There are two uses of a final class :


//One is definitely to prevent inheritance, as final classes cannot be extended. For example,
//
// all Wrapper Classes like Integer,Float etc.
// are final classes. We can not extend them.

//The other use of final with classes is to create an immutable class like
// the predefined String class.You can not make a class immutable without making it final.


  //  When a method is declared with final keyword, it is called a final method.
//  A final method cannot be overridden. The Object class does this—a number of its
//  methods are final.
//We must declare methods with final keyword for which we required to follow the same
// implementation throughout all the derived classes. The following fragment illustrates
// final keyword with a method: