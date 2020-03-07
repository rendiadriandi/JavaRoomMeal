package com.aurorasoft.javaroommeal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    ProgressBar pb;

    static MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = Room.databaseBuilder(
                getApplicationContext(),
                MyDatabase.class, "database")
                .allowMainThreadQueries()
                .build();

        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        String url = "https://www.themealdb.com/api/json/v1/1/filter.php?c=Seafood";

        //Log.i("get seafood ", "load: " + url);
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("rendi: ", response.toString());
                        String id, nama, image;

                        try {
                            JSONArray jsonArray = response.getJSONArray("results");

                            if (jsonArray.length() != 0) {
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject data = jsonArray.getJSONObject(i);

                                    id = data.getString("id").toString().trim();
                                    nama = data.getString("nama").toString().trim();
                                    image = data.getString("image").toString().trim();

                                    db.dataDao().insertAll(new Data(nama, image));
                                }

                                Intent i = new Intent(MainActivity.this,MainAppActivity.class);
                                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                MainActivity.this.startActivity(i);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        pb.setVisibility(ProgressBar.GONE);
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub
                Log.d("Events: ", error.toString());

            }
        });

        queue.add(jsObjRequest);

//        viewRecyclerView();
    }

//    public void viewRecyclerView(){
//        RecyclerView view = (RecyclerView) findViewById(R.id.rv_meal);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
//        view.setLayoutManager(linearLayoutManager);
//
//        datas = db.dataDao().getAll();
//
//        adapter = new DataAdapter(datas, this);
//        view.setAdapter(adapter);
//    }

    @Override
    protected void onResume() {
        super.onResume();
//        viewRecyclerView();
    }
}
