package com.project.newapp.news;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import model.sources;
import adapter.RecyclerViewApdaterNews;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    List<sources>sourcesList=new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerViewApdaterNews recyclerViewAdapterNews;
    RequestQueue requestQueue;
    NetworkController networkController;
    int i ;
    String url = "https://newsapi.org/v1/sources?language=en&apiKey=c6ba249db52c44518722fe4796b6ea1d";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        requestQueue = Volley.newRequestQueue(this);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        recyclerViewAdapterNews=new RecyclerViewApdaterNews(getApplicationContext(),sourcesList);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setAdapter(recyclerViewAdapterNews);
        requestQueue = (networkController.getNetworkController(getApplicationContext()).getmRequestQueue());


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {


                try {
                    JSONArray  jsonArray = response.getJSONArray("sources");
                    for(i = 0;i<jsonArray.length();i++){

                        JSONObject jsonObject = jsonArray.getJSONObject(i);

//
                        String id = jsonObject.getString("id");

                          JSONObject urlsToLogos  = jsonObject.getJSONObject("urlsToLogos");


                            String small = urlsToLogos.getString("small");
                            model.sources sources = new sources(id,small);
                            sourcesList.add(sources);



                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }finally {
                   recyclerViewAdapterNews.notifyItemChanged(i);
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(jsonObjectRequest);

    }

}
