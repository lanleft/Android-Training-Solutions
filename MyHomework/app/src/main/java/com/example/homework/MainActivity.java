package com.example.homework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    List<ItemModel> items;
    RecyclerView recyclerView;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        items = new ArrayList<>();
//        listFragment = ListFragment.newInstance(items);
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        ft.add(R.id.list_fragment,listFragment);
//        ft.commit();
        context = MainActivity.this;
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        new GetJson().execute("https://lebavui.github.io/jsons/users.json");

    }

//    @Override
//    public void itemClick(int position) {
//        Log.v("TAG", "da nhan duoc");
//    }

    class GetJson extends AsyncTask<String, Integer, JSONArray>{

        @Override
        protected JSONArray doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                String line;
                StringBuilder builder = new StringBuilder();
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                while ((line = reader.readLine()) != null){
                    builder.append(line);
                }
                reader.close();

                String jsonString = builder.toString();
                Log.v("TAG", jsonString);
                return new JSONArray(jsonString);
            }catch (Exception ex){
                ex.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {
            try {
                ItemAdapter adapter = new ItemAdapter(jsonArray,context);
                recyclerView.setAdapter(adapter);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

    }

}