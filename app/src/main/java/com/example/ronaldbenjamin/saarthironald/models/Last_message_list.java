package com.example.ronaldbenjamin.saarthironald.models;

public class Last_message_list
{
    private String pub_date;

    private int msg_type;

    private String msg_id;

    private String user_id;

    private String msg;

    public String getPub_date ()
    {
        return pub_date;
    }

    public void setPub_date (String pub_date)
    {
        this.pub_date = pub_date;
    }

    public int getMsg_type ()
    {
        return msg_type;
    }

    public void setMsg_type (int msg_type)
    {
        this.msg_type = msg_type;
    }

    public String getMsg_id ()
    {
        return msg_id;
    }

    public void setMsg_id (String msg_id)
    {
        this.msg_id = msg_id;
    }

    public String getUser_id ()
    {
        return user_id;
    }

    public void setUser_id (String user_id)
    {
        this.user_id = user_id;
    }

    public String getMsg ()
    {
        return msg;
    }

    public void setMsg (String msg)
    {
        this.msg = msg;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [pub_date = "+pub_date+", msg_type = "+msg_type+", msg_id = "+msg_id+", user_id = "+user_id+", msg = "+msg+"]";
    }
}
