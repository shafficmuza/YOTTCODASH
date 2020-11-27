package com.shafficmuza.yottcodash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ProgramsDash extends AppCompatActivity {

    private WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programs_dash);

            wv = (WebView) findViewById(R.id.webPrograms);
            wv.loadUrl("http://yottco.prosystemsug.com/category/programs/");

            // Enable Javascript
            WebSettings webSettings = wv.getSettings();
            webSettings.setJavaScriptEnabled(true);

            // Force links and redirects to open in the WebView instead of in a browser
            wv.setWebViewClient(new WebViewClient());



    }
}
