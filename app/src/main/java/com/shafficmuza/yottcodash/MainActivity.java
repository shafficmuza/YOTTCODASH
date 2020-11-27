package com.shafficmuza.yottcodash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private CardView about_Yottco,serviceProvider,sgbv_news,programs,news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // defining cards
        about_Yottco = (CardView) findViewById(R.id.about_yottco);
        serviceProvider = (CardView) findViewById(R.id.service_provider);
        sgbv_news = (CardView) findViewById(R.id.sgbv_news);
        programs = (CardView) findViewById(R.id.programs);
        news = (CardView) findViewById(R.id.news);
        // Add click listener to the cards
        about_Yottco.setOnClickListener(this);
        serviceProvider.setOnClickListener(this);
        sgbv_news.setOnClickListener(this);
        programs.setOnClickListener(this);
        news.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.about_yottco : i = new Intent(this,AboutYottco.class);startActivity(i);break;
            //case R.id.service_provider : i = new Intent(this,ServiceProvider.class);startActivity(i);break;
            case R.id.sgbv_news : i = new Intent(this,SGBVNews.class);startActivity(i);break;
            case R.id.programs : i = new Intent(this,ProgramsDash.class);startActivity(i);break;
            case R.id.news : i = new Intent(this,NewsDash.class);startActivity(i);break;
            default:break;
        }

    }
}
