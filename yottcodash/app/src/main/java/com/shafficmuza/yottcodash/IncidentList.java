package com.shafficmuza.yottcodash;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class IncidentList extends ArrayAdapter<Incident> {

    private Activity context;
    private List<Incident> incidentList;

   public IncidentList(Activity context, List<Incident> incidentList){
       super(context, R.layout.list_layout,incidentList);
       this.context = context;
       this.incidentList = incidentList;
   }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_layout,null,true);

        TextView textViewTitle = (TextView) listViewItem.findViewById(R.id.textViewTitle);
        TextView textViewLocation = (TextView) listViewItem.findViewById(R.id.textViewLocation);

        Incident incident = incidentList.get(position);

        textViewTitle.setText(incident.getIncidentTitle());
        textViewLocation.setText(incident.getIncidentLocation());

        return listViewItem;
        //return super.getView(position, convertView, parent);

    }
}
