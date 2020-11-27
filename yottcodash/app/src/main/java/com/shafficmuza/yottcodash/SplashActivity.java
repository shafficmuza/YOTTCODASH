package com.shafficmuza.yottcodash;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {
    AlertDialog.Builder builder;

    private ProgressBar prograssBar;
    private Handler hdlr = new Handler();
    private int i = 0;
    private TextView tvPercentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);


        ConnectivityManager mConnMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = mConnMgr.getActiveNetworkInfo();
        boolean isOnline = networkInfo != null && networkInfo.isConnected();

        if (!isOnline) {
            Toast.makeText(getApplicationContext(), "No Internet Connection!", Toast.LENGTH_LONG).show();
            finishAffinity();
            finish();
           /* //Setting message manually and performing action on no network is detected
            builder.setMessage("Please turn on your mobile network connection or connect to a wifi network to proceed!")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                        }

                    });
            //Creating dialog box
            AlertDialog alert = builder.create();
            //Setting the title manually
            alert.setTitle("Not Connected");
            alert.show();*/
        } else {
            prograssBar = (ProgressBar) findViewById(R.id.progressBar);
            tvPercentage = (TextView) findViewById(R.id.tvPercentage);

            //set progress and percentage label visible
            prograssBar.setVisibility(View.VISIBLE);
            //tvPercentage.setVisibility(View.VISIBLE);

            new Thread(new Runnable() {
                public void run() {
                    while (i < 100) {
                        i += 2;
                        // Update the progress bar and display the current value in text view
                        hdlr.post(new Runnable() {
                            public void run() {
                                prograssBar.setProgress(i);
                                //tvPercentage.setText("Loading... " + i + "% Please Wait!");
                                if (i > 99) {
                                    Intent intent = new Intent(getApplicationContext(), AboutYottco.class);
                                    startActivity(intent);
                                }
                            }
                        });
                        try {
                            // Sleep for 100 milliseconds to show the progress slowly.
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }
}