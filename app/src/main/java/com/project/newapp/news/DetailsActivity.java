package com.project.newapp.news;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import adapter.DetailsRecyclerviewAdapter;
import model.articles;
import model.sources;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetailsActivity extends AppCompatActivity {

    int i;
    private List<articles> articlesList = new ArrayList<>();
    RecyclerView recyclerView;
    DetailsRecyclerviewAdapter detailsRecyclerviewAdapter;
    RequestQueue requestQueue;
    NetworkController networkController;


    articles articles= new articles();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        requestQueue = Volley.newRequestQueue(this);
            recyclerView = (RecyclerView) findViewById(R.id.rcy);
            detailsRecyclerviewAdapter = new DetailsRecyclerviewAdapter(getApplicationContext(), articlesList);
            recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
            recyclerView.setAdapter(detailsRecyclerviewAdapter);
            requestQueue = (networkController.getNetworkController(getApplicationContext()).getmRequestQueue());





        String apiKey="c6ba249db52c44518722fe4796b6ea1d";

        JSONObject jsonObject = new JSONObject();
        try {
                 String source = jsonObject.getString("source");


                 articles articles = new articles(source);


                String url = "https://newsapi.org/v1/articles?source=" +articles.getSources()+ "&apiKey=" + apiKey;

                 JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url
                        , new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {

                            JSONArray jsonArrayarticles = response.getJSONArray("articles");
                            for (i = 0; i < jsonArrayarticles.length(); i++) {
                                JSONObject jsonObject = jsonArrayarticles.getJSONObject(i);
                                String title = jsonObject.getString("title");
                                String author = jsonObject.getString("author");
                                String urlToImage = jsonObject.getString("urlToImage");
                                model.articles detailsarticles = new articles(title, author, urlToImage);


                                articlesList.add(detailsarticles);


                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } finally {
                            detailsRecyclerviewAdapter.notifyItemChanged(i);
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }

                );

                requestQueue.add(jsonObjectRequest);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        }


}
