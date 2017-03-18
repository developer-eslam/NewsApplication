package com.project.newapp.news;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by Eslam on 3/15/2017.
 */

public class BitLrucache  extends LruCache<String,Bitmap> implements ImageLoader.ImageCache {


    public static  int getmaxsize()
    {
        int maxmemory = (int) (Runtime.getRuntime().maxMemory()*1024);

        return  maxmemory/8;
    }
    public BitLrucache() {
        super(getmaxsize());
    }

    @Override
    public Bitmap getBitmap(String url) {
        return get(url);
    }
    @Override
    protected int sizeOf(String key, Bitmap value) {
        return value.getRowBytes()*value.getHeight();
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {

        put(url,bitmap);
    }


}
