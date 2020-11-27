package com.shafficmuza.yottcodash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class Programs extends AppCompatActivity {

    WebView wv;
    private ProgressBar pghome2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programs);

        String url = "http://yottco.prosystemsug.com/";

        wv = (WebView) findViewById(R.id.webprogram);
        pghome2 = (ProgressBar) findViewById(R.id.pghome);

        // open web browser
        wv.setWebViewClient(new Programs.MyBrowser());
        WebSettings webSettings = wv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wv.loadUrl(url);

        wv.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onProgressChanged(WebView view, int newProgress) {

                // Method stub for TODO automatic generation

                if(newProgress==100){
                    pghome2.setVisibility(View.GONE); // After loading the progress bar disappears
                }
                else{
                    pghome2.setVisibility(View.VISIBLE); // display progress bar when starting to load web page
                    pghome2.setProgress(newProgress); // Set progress value
                }
            }
        });
///////////////////////////////
    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
