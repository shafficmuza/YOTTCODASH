package com.shafficmuza.yottcodash;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RepInc extends AppCompatActivity {

    EditText editTextTitle;
    Button buttonAdd;
    Spinner spinnerGenres;
    TextView testOne;

    DatabaseReference databaseIncidents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rep_inc);

        databaseIncidents = FirebaseDatabase.getInstance().getReference("incidentsTbl");

        editTextTitle = (EditText) findViewById(R.id.editTextTitle);
        buttonAdd = (Button) findViewById(R.id.btnSubmit);
        spinnerGenres = (Spinner) findViewById(R.id.spinnerGenres);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addIncident();
                Toast.makeText(RepInc.this, "Hello there", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void addIncident(){
        String name = editTextTitle.getText().toString().trim();
        String genre = spinnerGenres.getSelectedItem().toString();

        if(!TextUtils.isEmpty(name)){

            String id = databaseIncidents.push().getKey();
            Incident incident = new Incident(id,name,genre);
            databaseIncidents.child(id).setValue(incident);

            Toast.makeText(this,"Incident Reported", Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(this, "You should Enter Incident Title", Toast.LENGTH_LONG).show();
        }
    }
}
