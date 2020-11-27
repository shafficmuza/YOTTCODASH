package com.shafficmuza.yottcodash;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class AboutYottco extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_yottco);

        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
        adapter = new ViewPageAdapter(getSupportFragmentManager());

        // add fragments here
        adapter.AddFragment(new FragmentHome(), "");
        adapter.AddFragment(new FragmentCall(), "");
        adapter.AddFragment(new FragmentFav(),"SRHR");
        adapter.AddFragment(new FragmentSGBV(),"SGBV");
        adapter.AddFragment(new FragmentReportINC(),"Incidents");
        adapter.AddFragment(new SPDash(),"Service Provider");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home_white_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_info);
        //tabLayout.getTabAt(2).setIcon(R.drawable.ic_group);
        //tabLayout.getTabAt(2).setIcon(R.drawable.ic_star);

        SPDash fragment = new SPDash();
        FragmentManager manager = getSupportFragmentManager();
        // change the package name
        manager.beginTransaction().add(R.id.viewpager_id,fragment).commit();


    }




}
