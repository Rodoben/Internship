package com.example.ronaldbenjamin.saarthironald.models;

public class Thumbnails
{

    private  Default adefault;

    private Standard standard;

    private High high;

    private Medium medium;


    public Standard getStandard ()
    {
        return standard;
    }

    public void setStandard (Standard standard)
    {
        this.standard = standard;
    }

    public High getHigh ()
    {
        return high;
    }

    public void setHigh (High high)
    {
        this.high = high;
    }

    public Medium getMedium ()
    {
        return medium;
    }

    public void setMedium (Medium medium)
    {
        this.medium = medium;
    }
    public Default getAdefault() {
        return adefault;
    }

    public void setAdefault(Default adefault) {
        this.adefault = adefault;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [default = "+adefault+", standard = "+standard+", high = "+high+", medium = "+medium+"]";
    }
}