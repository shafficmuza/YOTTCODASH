
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
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

public class NewsDash extends AppCompatActivity {

    private WebView wv;
    private ProgressBar pg1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_dash);
        if(!haveNetworkConnection()){
            alertView();
        }

        //////////////////////////
        //String url = "http://prosystemsug.com/yottco-news/";
        String url = "http://yottco.prosystemsug.com/";
        wv = (WebView) findViewById(R.id.webNews);
        pg1 = (ProgressBar) findViewById(R.id.progressBar1);
        // open web browser
        wv.setWebViewClient(new MyBrowser());
        WebSettings webSettings = wv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wv.loadUrl(url);

        wv.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onProgressChanged(WebView view, int newProgress) {

                // Method stub for TODO automatic generation

                if(newProgress==100){
                    pg1.setVisibility(View.GONE); // After loading the progress bar disappears
                }
                else{
                    pg1.setVisibility(view.VISIBLE); // display progress bar when starting to load web page
                    pg1.setProgress(newProgress); // Set progress value
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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        // Method stub for TODO automatic generation
        if(keyCode==KeyEvent.KEYCODE_BACK) {
            if(wv.canGoBack()) {// when WebView is not on the first page, return to the previous page
                wv.goBack();
                return true;
            }
            else  {// Exit the program directly when the WebView is on the first page
                System.exit(0);
            }
        }

        return super.onKeyDown(keyCode, event);
    }


    private boolean haveNetworkConnection() {
        //Check internet connection:
        ConnectivityManager cm = (ConnectivityManager) this.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }

    private void alertView(){
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Attention");
        alertDialog.setMessage("No Net work Connection");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                      //  android.os.Process.killProcess(android.os.Process.myPid());
                      //  System.exit(1);
                        Intent i = new Intent(NewsDash.this,MainActivity.class);
                        startActivity(i);
                    }
                });
        alertDialog.show();
    }
}
