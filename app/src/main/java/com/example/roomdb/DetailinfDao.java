package com.example.roomdb;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DetailinfDao {

    @Insert
    void insertUserDetail(Mydetailinfo mydetailinfo);
    //pass model class object into insert dao or
    //data access object (insertuserdetail) will access data object of modelclass where data resides

    @Query("SELECT * from userdetail")
    //data will come as list after calling fetch method
    List <Mydetailinfo>fetchAllData();

}
