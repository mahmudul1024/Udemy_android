package com.example.cardviwapp;

public class Models_Data {

   private String name;
   private int noofdownloads;
   private int thumnail;

    public Models_Data(String name, int noofdownloads, int thumnail){
        this.name=name;
        this.noofdownloads=noofdownloads;
        this.thumnail=thumnail;
    }

    public Models_Data(){
    }


    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public int getNoofdownloads(){
        return noofdownloads;
    }

    public void setNoofdownloads(int noofdownloads){
        this.noofdownloads=noofdownloads;
    }

    public int getThumnail(){
        return thumnail;
    }

    public void setThumnail(int thumnail){
        this.thumnail=thumnail;
    }
}
