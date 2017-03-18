package com.project.newapp.news;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

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

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    int i;
    private List<articles> articlesList = new ArrayList<>();
    RecyclerView recyclerView;
    DetailsRecyclerviewAdapter detailsRecyclerviewAdapter;
    RequestQueue requestQueue;
    NetworkController networkController;





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





        articles articles = new articles();

         JSONObject params = new JSONObject();

        try {

             String a = params.getString("sources");
            String url = "https://newsapi.org/v1/articles?source="+a+"&sortBy=top&apiKey=c6ba249db52c44518722fe4796b6ea1d";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest( url
         ,params,new Response.Listener<JSONObject>() {
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
            });

            requestQueue.add(jsonObjectRequest);


        }catch (JSONException e){

        }



    }
}