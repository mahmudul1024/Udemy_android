package com.example.roomdb;

import androidx.room.Database;
import androidx.room.RoomDatabase;

// 2 ..create a database class
@Database(entities={Mydetailinfo.class},version=1,exportSchema=false)
public abstract class Mydatabase extends RoomDatabase {

    //3 create a  inner Dao class method
    public abstract DetailinfDao detailinfoDao();
}
