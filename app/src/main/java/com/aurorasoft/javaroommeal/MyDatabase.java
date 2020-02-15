package com.aurorasoft.javaroommeal;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Data.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase {
    public abstract DataDao dataDao();
}
