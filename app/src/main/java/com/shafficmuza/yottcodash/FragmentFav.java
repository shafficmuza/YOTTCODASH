package com.shafficmuza.yottcodash;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class FragmentFav extends Fragment {

    private WebView wv;
    View v;

    public FragmentFav() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fav_fragment,container,false);

            wv = (WebView) v.findViewById(R.id.webViewSHRS);
            wv.loadUrl("http://yottco.prosystemsug.com/category/srhr/");

            // Enable Javascript
            WebSettings webSettings = wv.getSettings();
            webSettings.setJavaScriptEnabled(true);

            // Force links and redirects to open in the WebView instead of in a browser
            wv.setWebViewClient(new WebViewClient());


        return v;
    }
}

