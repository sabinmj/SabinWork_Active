package com.example.sabin.sabinwork_active;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class Webview_demo extends AppCompatActivity {
    private WebView wvResult;
    private ProgressBar pbWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_demo);

        wvResult = (WebView) findViewById(R.id.wvresult);
        pbWeb = (ProgressBar) findViewById(R.id.progressBar);

    }
    protected void onStart() {
        super.onStart();

        wvResult.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                pbWeb.setVisibility(View.INVISIBLE);
            }
        });
        WebSettings webSettings = wvResult.getSettings();
        webSettings.setJavaScriptEnabled(true);

        wvResult.loadUrl("https://google.com");
    }

}
