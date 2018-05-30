package com.example.ronaldbenjamin.saarthironald;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ronaldbenjamin.saarthironald.models.Cards;
import com.example.ronaldbenjamin.saarthironald.models.Currently;
import com.example.ronaldbenjamin.saarthironald.models.Hourly;
import com.example.ronaldbenjamin.saarthironald.models.Message;
import com.example.ronaldbenjamin.saarthironald.models.Cards;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

class ChatArrayAdapter extends ArrayAdapter<ChatMessage> {
    private String IconName;
    private TextView tv;
    private Message message;
    private TextView chatText;
    private List<ChatMessage> chatMessageList = new ArrayList<ChatMessage>();
    private Context context;

    @Override
    public void add(ChatMessage object) {
        chatMessageList.add(object);
        super.add(object);
    }

    public ChatArrayAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
        this.context = context;
    }

    public int getCount() {
        return this.chatMessageList.size();
    }

    public ChatMessage getItem(int index) {
        return this.chatMessageList.get(index);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ImageView imageView;
        ChatMessage chatMessageObj = getItem(position);
        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (chatMessageObj.left==1 && chatMessageObj.context==null) {
            row = inflater.inflate(R.layout.right, parent, false);
            chatText = (TextView) row.findViewById(R.id.msgr);
            chatText.setText(chatMessageObj.message);
            }
        else if(chatMessageObj.context=="Weather" && chatMessageObj.left==1)
        {
            message=chatMessageObj.getMsg();
            Cards c[];
            c=message.getCards();
            Currently currently=c[0].getCurrently();
            Hourly[] hourly=c[0].getHourly();
            row = inflater.inflate(R.layout.weather, parent, false);
            imageView=row.findViewById(R.id.currentlyImage);
            IconName=currently.getIcon();
            Log.i("Icon",IconName);
            image(IconName,imageView);
            tv=row.findViewById(R.id.locationname);
            tv.setText(currently.getLocation());
            tv=row.findViewById(R.id.temperature);
            tv.setText(currently.getTemperature());
            /* tv=row.findViewById(R.id.locationname);
             tv.setText(currently.getLocation());
             tv=row.findViewById(R.id.temperature);
             tv.setText(currently.getTemperature());*/


        }
        else if(chatMessageObj.context=="News Headlines" && chatMessageObj.left==1)
        {
            TextView u1;
            TextView u2;
            TextView u3;
            message=chatMessageObj.getMsg();
            final Cards c[];
            c=message.getCards();
            row = inflater.inflate(R.layout.activity_news, parent, false);
            tv = row.findViewById(R.id.title1);
            tv.setText(c[0].getTitle());
            tv=row.findViewById(R.id.author1);
            tv.setText(c[0].getDescription().substring(0,50)+"....");
            u1=row.findViewById(R.id.url1);
            tv=row.findViewById(R.id.url1);
            tv.setText("Click Here");
            imageView=row.findViewById(R.id.imageView1);
            Picasso.with(getContext()).load(c[0].getUrlToImage()).resize(200,100).into(imageView);
            u1.setOnClickListener(
                    new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(getContext(), webview.class);
                    myIntent.putExtra("Url",c[0].getUrl());
                    context.startActivity(myIntent);
                }
            });
            //
            tv = row.findViewById(R.id.title2);
            tv.setText(c[1].getTitle());
            tv=row.findViewById(R.id.author2);
            tv.setText(c[1].getDescription().substring(0,50)+"....");
            u2=row.findViewById(R.id.url2);
            tv=row.findViewById(R.id.url2);
            tv.setText("Click Here");
            imageView=row.findViewById(R.id.imageView2);
            Picasso.with(getContext()).load(c[1].getUrlToImage()).resize(200,100).into(imageView);
            u2.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent myIntent = new Intent(getContext(), webview.class);
                            myIntent.putExtra("Url",c[1].getUrl());
                            context.startActivity(myIntent);
                        }
                    });


            //
            tv = row.findViewById(R.id.title3);
            tv.setText(c[2].getTitle());
            tv=row.findViewById(R.id.author3);
            tv.setText(c[2].getDescription().substring(0,50)+"....");
            u3=row.findViewById(R.id.url3);
            tv=row.findViewById(R.id.url3);
            tv.setText("Click here");
            imageView=row.findViewById(R.id.imageView3);
            Log.i("Hello",c[2].getTitle());
            Picasso.with(getContext()).load(c[2].getUrlToImage()).resize(200,100).into(imageView);
            u3.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent myIntent = new Intent(getContext(), webview.class);
                            myIntent.putExtra("Url",c[2].getUrl());
                            context.startActivity(myIntent);
                        }
                    });

        }
        else if(chatMessageObj.context=="Youtube-Search" && chatMessageObj.left==1)
        {
            TextView u1;
            TextView u2;
            message=chatMessageObj.getMsg();
            final Cards c[];
            c=message.getCards();
            row = inflater.inflate(R.layout.youtube_card, parent, false);
            tv = row.findViewById(R.id.ytitle1);
            tv.setText(c[0].getTitle());
            tv=row.findViewById(R.id.ypublishedAt1);
            tv.setText(c[0].getPublishedAt());
            u1=row.findViewById(R.id.yurl1);
            tv=row.findViewById(R.id.yurl1);
            tv.setText("Click Here");
            imageView=row.findViewById(R.id.thumbnail1);
            Picasso.with(getContext()).load(c[0].getThumbnails().getHigh().getUrl()).resize(200,100).into(imageView);
            u1.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent myIntent = new Intent(getContext(), YoutubeActivity.class);
                            myIntent.putExtra("Url",c[0].getUrl());
                            context.startActivity(myIntent);
                        }
                    });
            //
            tv = row.findViewById(R.id.ytitle2);
            tv.setText(c[1].getTitle());
            tv=row.findViewById(R.id.ypublishedAt2);
            tv.setText(c[1].getPublishedAt());
            u2=row.findViewById(R.id.yurl2);
            tv=row.findViewById(R.id.yurl2);
            tv.setText("Click Here");
            imageView=row.findViewById(R.id.thumbnail2);
            Picasso.with(getContext()).load(c[1].getThumbnails().getHigh().getUrl()).resize(200,100).into(imageView);
            u2.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent myIntent = new Intent(getContext(), YoutubeActivity.class);
                            myIntent.putExtra("Url",c[1].getUrl());
                            context.startActivity(myIntent);
                        }
                    });


            //


        }
        else if(chatMessageObj.context=="Youtube-Play" && chatMessageObj.left==1)
        {
            row = inflater.inflate(R.layout.left, parent, false);
            chatText = (TextView) row.findViewById(R.id.msgr);
            chatText.setText("Playing video");
            Message message=chatMessageObj.getMsg();
            Cards c[];
            c=message.getCards();
            Intent myIntent = new Intent(getContext(), YoutubeActivity.class);
            myIntent.putExtra("Url",c[0].getUrl());
            Log.i("able",c[0].getUrl());
            context.startActivity(myIntent);

        }
        else if(chatMessageObj.context=="Open_bluetooth" && chatMessageObj.left==1)
        {
            row = inflater.inflate(R.layout.left, parent, false);
            chatText = (TextView) row.findViewById(R.id.msgr);
            chatText.setText("Opening Bluetooth");
            Log.i("Inside Bluetooth","Bluetooth");
            Bluetooh_Activity bluetooh_activity=new Bluetooh_Activity();
            bluetooh_activity.bluetoothOpen();

        }
        else if(chatMessageObj.context=="Open back camera" && chatMessageObj.left==1)
        {
            row = inflater.inflate(R.layout.left, parent, false);
            chatText = (TextView) row.findViewById(R.id.msgr);
            chatText.setText("Opening Camera");
            ((ChatMainPage)context).initCamera(true, false);
        }
        else if(chatMessageObj.context=="Selfie" && chatMessageObj.left==1)
        {
            row = inflater.inflate(R.layout.left, parent, false);
            chatText = (TextView) row.findViewById(R.id.msgr);
            chatText.setText("Taking selfie");
            ((ChatMainPage)context).initCamera(true,true);
        }
        else{
            row = inflater.inflate(R.layout.left, parent, false);
            Log.i("Thats one ","hello that one");
            chatText = (TextView) row.findViewById(R.id.msgr);
            chatText.setText(chatMessageObj.message);
            }
        return row;
    }
    void image(String IconName,ImageView imageView)
    {
        if(IconName.equals("clear-day"))
        {
            imageView.setImageResource(R.drawable.clearday);
        }
        else if(IconName.equals("clear-night"))
        {
            imageView.setImageResource(R.drawable.clearnight);
        }
        else if(IconName.equals("cloudy"))
        {
            imageView.setImageResource(R.drawable.cloudy);
        }
        else if(IconName.equals("fog"))
        {
            imageView.setImageResource(R.drawable.fog);
        }
        else if (IconName.equals("partly-cloudy-day"))
        {
            Log.i("helo","hello");
            imageView.setImageResource(R.drawable.partlycloudlyday);

        }
        else if(IconName.equals("rain"))
        {
            imageView.setImageResource(R.drawable.rain);
        }
        else if(IconName.equals("sleet"))
        {
            imageView.setImageResource(R.drawable.sleet);
        }
        else if(IconName.equals("snow"))
        {
            imageView.setImageResource(R.drawable.snow);
        }
        else
        {
            imageView.setImageResource(R.drawable.wind);
        }

    }


}