package com.example.ronaldbenjamin.saarthironald.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Debug
{
    @SerializedName("view_called")
    @Expose
    private String view_called;
    @SerializedName("info")
    @Expose
    private String info;

    public String getView_called ()
    {
        return view_called;
    }

    public void setView_called (String view_called)
    {
        this.view_called = view_called;
    }

    public String getInfo ()
    {
        return info;
    }

    public void setInfo (String info)
    {
        this.info = info;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [view_called = "+view_called+", info = "+info+"]";
    }
}