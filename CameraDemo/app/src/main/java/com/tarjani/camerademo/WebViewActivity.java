package com.tarjani.camerademo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    private WebView web;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        web=findViewById(R.id.web);
        String html="<html><body><p style='color:green'>Hello World</p></body></html>";
        //web.loadData(html,"text/html","UTF-8");
        web.loadUrl("https://www.google.com");
        web.setWebViewClient(new WebClientTest());
       // web.loadUrl("file://android_asset/");


    }
    class WebClientTest extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;

        }
    }
}