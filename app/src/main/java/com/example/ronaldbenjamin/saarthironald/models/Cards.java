package com.example.ronaldbenjamin.saarthironald.models;


public class Cards
{


    private String url;
    private Thumbnails thumbnails;

    private String id;

    private String publishedAt;

    private String author;

    private String urlToImage;

    private String title;

    private String description;

    private Currently currently;

    private Hourly[] hourly;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public Currently getCurrently ()
    {
        return currently;
    }

    public void setCurrently (Currently currently)
    {
        this.currently = currently;
    }

    public Hourly[] getHourly ()
    {
        return hourly;
    }

    public void setHourly (Hourly[] hourly)
    {
        this.hourly = hourly;
    }
    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }
    public String getPublishedAt ()
    {
        return publishedAt;
    }

    public void setPublishedAt (String publishedAt)
    {
        this.publishedAt = publishedAt;
    }

    public String getAuthor ()
    {
        return author;
    }

    public void setAuthor (String author)
    {
        this.author = author;
    }

    public String getUrlToImage ()
    {
        return urlToImage;
    }

    public void setUrlToImage (String urlToImage)
    {
        this.urlToImage = urlToImage;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }
    public Thumbnails getThumbnails ()
    {
        return thumbnails;
    }

    public void setThumbnails (Thumbnails thumbnails)
    {
        this.thumbnails = thumbnails;
    }




    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", currently = "+currently+", hourly = "+hourly+"]";
    }
}
