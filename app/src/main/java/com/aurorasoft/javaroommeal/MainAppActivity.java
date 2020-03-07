package com.aurorasoft.javaroommeal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class MainAppActivity extends AppCompatActivity {

    DataAdapter adapter;

    //panggil DB
    static MyDatabase db;

    List<Data> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_app);

        showRecyclerView();
    }

    void showRecyclerView(){

        RecyclerView view = (RecyclerView) findViewById(R.id.rv_meal);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        view.setLayoutManager(linearLayoutManager);

        datas = db.dataDao().getAll(); //ambil semua data

        adapter = new DataAdapter(datas, this);
        view.setAdapter(adapter);
    }


}
