package com.example.ronaldbenjamin.saarthironald.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Parameters
{
    @SerializedName("last_message_list")
    @Expose
    private Last_message_list[] last_message_list;

    public Last_message_list[] getLast_message_list ()
    {
        return last_message_list;
    }
    public void setLast_message_list (Last_message_list[] last_message_list)
    {
        this.last_message_list = last_message_list;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [last_message_list = "+last_message_list+"]";
    }
}
