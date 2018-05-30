package com.example.ronaldbenjamin.saarthironald.models;


public class Currently
{
    private String icon;

    private String time;

    private String location;

    private String precipitation;

    private String Temperature;

    private String Summary;

    public String getIcon ()
    {
        return icon;
    }

    public void setIcon (String icon)
    {
        this.icon = icon;
    }

    public String getTime ()
    {
        return time;
    }

    public void setTime (String time)
    {
        this.time = time;
    }

    public String getLocation ()
    {
        return location;
    }

    public void setLocation (String location)
    {
        this.location = location;
    }

    public String getPrecipitation ()
    {
        return precipitation;
    }

    public void setPrecipitation (String precipitation)
    {
        this.precipitation = precipitation;
    }

    public String getTemperature ()
    {
        return Temperature;
    }

    public void setTemperature (String Temperature)
    {
        this.Temperature = Temperature;
    }

    public String getSummary ()
    {
        return Summary;
    }

    public void setSummary (String Summary)
    {
        this.Summary = Summary;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [icon = "+icon+", time = "+time+", location = "+location+", precipitation = "+precipitation+", Temperature = "+Temperature+", Summary = "+Summary+"]";
    }
}



