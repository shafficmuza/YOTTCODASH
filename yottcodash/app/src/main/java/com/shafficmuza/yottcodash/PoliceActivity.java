package com.shafficmuza.yottcodash;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PoliceActivity extends AppCompatActivity {

    private RecyclerView myRecyclerView;
    private List<ServiceProvider> listServiceProvider;
    private PoliceRecyclerViewAdapter policeRecyclerViewAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.police_activity);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Police Stations");
        actionBar.setDisplayHomeAsUpEnabled(true);

        //getData method that fetch and display sp data
        getData();

    }

    private void getData() {
        listServiceProvider = new ArrayList<>();
        //declare the url that accept the data from php
        //String url = "http://192.168.122.1/yottco/sp_data.php";
        String url = "http://smsvibe.com/yottco/sp_data.php?category=police";

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        ServiceProvider serviceProvider = new ServiceProvider();
                        serviceProvider.setTitle(jsonObject.getString("title"));
                        serviceProvider.setDesc(jsonObject.getString("description"));
                        serviceProvider.setPhone(jsonObject.getString("phone"));
                        serviceProvider.setLocation(jsonObject.getString("location"));

                        listServiceProvider.add(serviceProvider);

                    } catch (JSONException e) {
                        e.printStackTrace();
                        progressDialog.dismiss();
                    }
                }
                policeRecyclerViewAdapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());
                progressDialog.dismiss();
            }
        });

        myRecyclerView = (RecyclerView) findViewById(R.id.sp_recyclerView);
        policeRecyclerViewAdapter = new PoliceRecyclerViewAdapter(getBaseContext(), listServiceProvider);
        myRecyclerView.setAdapter(policeRecyclerViewAdapter);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return false;
    }
}