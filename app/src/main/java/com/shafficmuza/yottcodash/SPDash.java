package com.shafficmuza.yottcodash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SPDash extends Fragment implements View.OnClickListener {
    View v;
    private CardView cbs,police,health_centre;

    public SPDash() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.sp_dash_fragment, container, false);

        cbs = (CardView) v.findViewById(R.id.cbs);
        police = (CardView) v.findViewById(R.id.police);
        health_centre = (CardView) v.findViewById(R.id.health_centre);

        cbs.setOnClickListener(this);
        police.setOnClickListener(this);
        health_centre.setOnClickListener(this);

        return v;

    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.cbs : i = new Intent(this.getActivity(), ServiceProviderActivity.class);startActivity(i); break;
            case R.id.police : i = new Intent(this.getActivity(), Police.class);startActivity(i); break;
            case R.id.health_centre : i = new Intent(this.getActivity(), HealthCentres.class);startActivity(i); break;
            //case R.id.cbs : i = new Intent(getActivity(), SGBVNews.class);startActivity(i); break;
           default:break;
        }

    }
}
