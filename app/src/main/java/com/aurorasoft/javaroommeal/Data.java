package com.aurorasoft.javaroommeal;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Data {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "nama")
    private String nama;

    @ColumnInfo (name = "image")
    private String image;

    @Ignore
    public Data(String nama, String image) {
        this.nama = nama;
        this.image = image;
    }

    public Data(int id, String nama, String image) {
        this.id = id;
        this.nama = nama;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public String getImage() {
        return image;
    }

}
