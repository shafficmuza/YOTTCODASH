package com.shafficmuza.yottcodash;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class FragmentSGBV extends Fragment {
    View v;
    WebView mWebView;
    public FragmentSGBV() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.sgbv_fragment,container,false);

        mWebView = (WebView) v.findViewById(R.id.sgbvWebview);
        mWebView.loadUrl("http://yottco.prosystemsug.com/category/sgbv/");

        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient());


        return v;
    }
}
