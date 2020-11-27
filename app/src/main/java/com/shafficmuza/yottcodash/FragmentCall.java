package com.shafficmuza.yottcodash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentCall extends Fragment implements View.OnClickListener {

    View v;
    WebView wv;
    private ProgressBar pghomeww;
    private CardView aboutId,health_centrenjjssj,policesasas;

    public FragmentCall() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.call_fragment, container, false);

        aboutId = (CardView) v.findViewById(R.id.aboutId);
        health_centrenjjssj = (CardView) v.findViewById(R.id.health_centrenjjssj);
        policesasas = (CardView) v.findViewById(R.id.policesasas);

        aboutId.setOnClickListener(this);
        health_centrenjjssj.setOnClickListener(this);
        policesasas.setOnClickListener(this);
        ////////////////////////////////////


        return v;
        }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId())
        {
            case R.id.aboutId: i = new Intent(getActivity(), About.class);startActivity(i);break;
            case R.id.health_centrenjjssj: i = new Intent(getActivity(),Programs.class); startActivity(i);break;
            case R.id.policesasas: i = new Intent(getActivity(), SGBV.class);startActivity(i);break;
            default: break;
        }

    }
}
