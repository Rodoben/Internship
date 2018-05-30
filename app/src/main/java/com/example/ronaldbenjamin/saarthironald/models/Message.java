package com.example.ronaldbenjamin.saarthironald.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Message
    {
        @SerializedName("text")
        @Expose
        private String text;
        @SerializedName("context")
        @Expose
        private String context;
        @SerializedName("Success")
        @Expose
        private String success;
        @SerializedName("cards")
        @Expose
        private Cards[] cards;

        @SerializedName("error")
        @Expose
        private String error;

        public String getText ()
        {
            return text;
        }

        public void setText (String text)
        {
            this.text = text;
        }

        public String getContext ()
        {
            return context;
        }

        public void setContext (String context)
        {
            this.context = context;
        }

        public String getSuccess ()
        {
            return success;
        }

        public void setSuccess (String success)
        {
            this.success = success;
        }
        public String getError() {
            return error;
        }

        public void setError(String Error) {
            error = Error;
        }

        public Cards[] getCards ()
        {
            return cards;
        }

        public void setCards (Cards[] cards)
        {
            this.cards = cards;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [text = "+text+", context = "+context+", success = "+success+"]";
        }
        }



