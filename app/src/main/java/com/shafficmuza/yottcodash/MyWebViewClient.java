package com.shafficmuza.yottcodash;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWebViewClient extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return super.shouldOverrideUrlLoading(view, url);

/*
        if("http://yottco.smsvibe.com/news".equals(Uri.parse("http://yottco.smsvibe.com/news").getHost())) {
            // This is my website, so do not override; let my WebView load the page
            return false;
        }
        // Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://yottco.smsvibe.com/news"));
        startActivity(intent);
        return true;

            }


    private void startActivity(Intent intent) {


    }
    */
    }
}
