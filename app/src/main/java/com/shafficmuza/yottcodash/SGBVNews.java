package com.shafficmuza.yottcodash;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class SGBVNews extends AppCompatActivity {

    private WebView wv;
    //private ProgressBar pg3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sgbvnews);

        wv = (WebView) findViewById(R.id.sgbvData);
        wv.loadUrl("http://yottco.prosystemsug.com/category/sgbv/");

        // Enable Javascript
        WebSettings webSettings = wv.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Force links and redirects to open in the WebView instead of in a browser
        wv.setWebViewClient(new WebViewClient());
    }

}
