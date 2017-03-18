package model;

import java.io.Serializable;

/**
 * Created by Eslam on 3/16/2017.
 */

public class articles implements Serializable {

    private String sources;
    private String title;
    private String urlToImage;
    private String publishedAt;
    private String author;



    public articles(String title,String author,String urlToImage){
        this.setTitle(title);
        this.setAuthor(author);
        this.setUrlToImage(urlToImage);
    }

    public articles(){
        setSources(sources);
    }



    public  articles(String sources){
        setSources(sources);
    }
    public String getSources() {
        return sources;
    }

    public void setSources(String sources) {
        this.sources = sources;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
