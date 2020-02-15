package com.aurorasoft.javaroommeal;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DataDao {
    @Query("SELECT * FROM data")
    List<Data> getAll();

    @Insert
    void insertAll (Data data);

    @Update
    void update (Data data);

    @Delete
    void delete (Data data);
}
