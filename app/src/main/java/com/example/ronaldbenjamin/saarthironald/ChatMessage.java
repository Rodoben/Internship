package com.example.ronaldbenjamin.saarthironald;

import com.example.ronaldbenjamin.saarthironald.models.Message;

public class ChatMessage {
    public int left;

    public String message;

    public String context;

    public Message msg;

    public ChatMessage(int left, String message, String context, Message msg) {
        this.left = left;
        this.message = message;
        this.context = context;
        this.msg = msg;
    }

    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }

    public Message getMsg() {
        return msg;
    }

    public void setMsg(Message msg) {
        this.msg = msg;
    }


    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

}