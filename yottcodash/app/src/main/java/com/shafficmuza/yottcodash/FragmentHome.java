package com.shafficmuza.yottcodash;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class FragmentHome extends Fragment{
    View v;
    WebView wv;
    private ProgressBar pghome;

    public FragmentHome() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       v = inflater.inflate(R.layout.home_layout, container, false);

        String url = "http://yottco.prosystemsug.com/";
        wv = (WebView) v.findViewById(R.id.webhome);
        pghome = (ProgressBar) v.findViewById(R.id.pghome);
        // open web browser
        wv.setWebViewClient(new FragmentHome.MyBrowser());
        WebSettings webSettings = wv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wv.loadUrl(url);

        wv.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onProgressChanged(WebView view, int newProgress) {

                // Method stub for TODO automatic generation

                if(newProgress==100){
                    pghome.setVisibility(View.GONE); // After loading the progress bar disappears
                }
                else{
                    pghome.setVisibility(view.VISIBLE); // display progress bar when starting to load web page
                    pghome.setProgress(newProgress); // Set progress value
                }
            }
        });
///////////////////////////////

        return v;
    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }



    private boolean haveNetworkConnection() {
        //Check internet connection:
        ConnectivityManager cm = (ConnectivityManager) this.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }

    private void alertView(){
        AlertDialog alertDialog = new AlertDialog.Builder(this.getContext()).create();
        alertDialog.setTitle("Attention");
        alertDialog.setMessage("No Net work Connection");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //  android.os.Process.killProcess(android.os.Process.myPid());
                        //  System.exit(1);
                        Intent i = new Intent(getContext(),MainActivity.class);
                        startActivity(i);
                    }
                });
        alertDialog.show();
    }

}