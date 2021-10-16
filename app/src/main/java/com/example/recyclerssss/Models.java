package com.example.recyclerssss;

public class Models {



    //this class  will be used to store and get ,set data

    private String Title, Genre ,Date;

    // when an object will be created it will take all the private organs
    //so need a constructor to being a perfect human


    public Models(String title, String genre, String date){
        Title=title;
        Genre=genre;
        Date=date;
    }

    // Another constuctor
    public Models(){

    }

    //getter setter


    public String getTitle(){
        return Title;
    }

    public void setTitle(String title){
        Title=title;
    }

    public String getGenre(){
        return Genre;
    }

    public void setGenre(String genre){
        Genre=genre;
    }

    public String getDate(){
        return Date;
    }

    public void setDate(String date){
        Date=date;
    }
}
