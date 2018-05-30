package com.example.ronaldbenjamin.saarthironald.models;

import android.os.Debug;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChatResonse {
    @SerializedName("message")
    @Expose
    private Message message;

    @SerializedName("debug")
    @Expose
    private Debug debug;
    @SerializedName("success")
    @Expose
    private  String success;

    @SerializedName("parameters")
    @Expose
    private Parameters parameters;

    public Message getMessage ()
    {
        return message;
    }

    public void setMessage (Message message)
    {
        this.message = message;
    }


    public Debug getDebug ()
    {
        return debug;
    }

    public void setDebug (Debug debug)
    {
        this.debug = debug;
    }

    public String getSuccess ()
    {
        return success;
    }

    public void setSuccess (String success)
    {
        this.success = success;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }
    @Override
    public String toString()
    {
        return "ClassPojo [message = "+message+", debug = "+debug+", success = "+success+"]";
    }


}

