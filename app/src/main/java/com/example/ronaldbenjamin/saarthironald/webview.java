package com.example.ronaldbenjamin.saarthironald;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import retrofit2.http.Url;

public class webview extends AppCompatActivity {

    private WebView webView;


    private String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
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
        webView=findViewById(R.id.webview1);
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient());

    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
