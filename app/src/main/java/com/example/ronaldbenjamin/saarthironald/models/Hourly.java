package com.example.ronaldbenjamin.saarthironald.models;


public class Hourly
{
    private String summary;

    private String icon;

    private String time;

    private String precipitation;

    private String temperature;

    public String getSummary ()
    {
        return summary;
    }

    public void setSummary (String summary)
    {
        this.summary = summary;
    }

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
        return temperature;
    }

    public void setTemperature (String temperature)
    {
        this.temperature = temperature;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [summary = "+summary+", icon = "+icon+", time = "+time+", precipitation = "+precipitation+", temperature = "+temperature+"]";
    }
}
