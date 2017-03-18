package com.project.newapp.news;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by Eslam on 3/15/2017.
 */
public class NetworkController {
    private static RequestQueue mRequestQueue;
    private Context context;
    private static  NetworkController networkController;

    private ImageLoader mimageLoader;
    public NetworkController(Context context){
        this.context=context;
        mRequestQueue = getmRequestQueue();
        mimageLoader = new ImageLoader(mRequestQueue,
                new ImageLoader.ImageCache() {
                    //Create ImageCache of max size 10MB
                    private final LruCache<String, Bitmap>
                            cache = new LruCache<String, Bitmap>(10);

                    @Override
                    public Bitmap getBitmap(String url) {
                        return cache.get(url);
                    }

                    @Override
                    public void putBitmap(String url, Bitmap bitmap) {
                        cache.put(url, bitmap);
                    }
                });    }

    public RequestQueue getmRequestQueue(){
        if(mRequestQueue==null){
            mRequestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return  mRequestQueue;
    }

    public  static  synchronized   NetworkController getNetworkController(Context context){
        if(networkController==null){
            networkController = new NetworkController(context);
        }
        return  networkController;
    }

    public ImageLoader geImageLoader(){
        return  mimageLoader;
    }
    public <T> void addToRequestQueue(Request<T> req) {
        getmRequestQueue().add(req);
    }

}
