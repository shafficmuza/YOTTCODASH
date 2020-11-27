package com.shafficmuza.yottcodash;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FragmentReportINC extends Fragment {

    Button btnSubmit;
    EditText editTextTitle;
    Spinner spinnerGenre;

    Context context;
    View v;
    DatabaseReference databaseIncidents;

    List<Incident> incidentList;

    ListView listViewIncidents;

    public FragmentReportINC() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.report_inc_fragment,container,false);

        databaseIncidents = FirebaseDatabase.getInstance().getReference("incidentsTbl");

        context = v.getContext();
        editTextTitle = (EditText) v.findViewById(R.id.editTextTitle);
        spinnerGenre = (Spinner) v.findViewById(R.id.spinnerGenres);
        btnSubmit = (Button) v.findViewById(R.id.btnSubmit);

        listViewIncidents = (ListView) v.findViewById(R.id.listViewIncidents);

        incidentList = new ArrayList<>();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Intent intent = new Intent(context,RepInc.class);
               // startActivity(intent);
                addIncident();

            }
        });

        return v;

    }

    @Override
    public void onStart() {
        super.onStart();

        databaseIncidents.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                incidentList.clear();
                for(DataSnapshot incidentSnapshot : dataSnapshot.getChildren()){
                    Incident incident = incidentSnapshot.getValue(Incident.class);

                    incidentList.add(incident);
                }

               // IncidentList adapter = new IncidentList(FragmentReportINC.this, incidentList);
                IncidentList adapter = new IncidentList(getActivity(),incidentList);
                listViewIncidents.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void addIncident(){
        String name = editTextTitle.getText().toString().trim();
        String genre = spinnerGenre.getSelectedItem().toString().trim();

        if(!TextUtils.isEmpty(name)){

            String id = databaseIncidents.push().getKey();
            Incident incident = new Incident(id,name,genre);
            databaseIncidents.child(id).setValue(incident);

           Toast.makeText(context,"Incident Reported", Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(context, "You should Enter Incident Title", Toast.LENGTH_LONG).show();
        }
    }


}
