package com.example.ronaldbenjamin.saarthironald;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import retrofit2.http.Url;

public class YoutubeActivity extends YouTubeBaseActivity {
    Button b;
    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayer.OnInitializedListener onInitializedListener;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                url= null;
            } else {
                url= extras.getString("Url");
            }
        } else {
            url = (String) savedInstanceState.getSerializable("Url");
        }
        int i=0;
        while(url.charAt(i)!='=')
        {
            i++;
        }
        final String newurl=url.substring(i+1,url.length());
        Log.i("url",url);
        Log.i("newurl",newurl);

        youTubePlayerView=(YouTubePlayerView)findViewById(R.id.youtube_view);
        onInitializedListener=new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(newurl);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {


            }
        };
        youTubePlayerView.initialize("AIzaSyBC2X9S7iqrmQCJEKCipd10xGSL-qzH2v0",onInitializedListener);
    }
}
