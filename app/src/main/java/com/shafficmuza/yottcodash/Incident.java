package com.shafficmuza.yottcodash;

public class Incident {

    String incidentId;
    String incidentTitle;
    String incidentLocation;

    public Incident(){

    }

    public Incident(String incidentId, String incidentTitle, String incidentLocation) {
        this.incidentId = incidentId;
        this.incidentTitle = incidentTitle;
        this.incidentLocation = incidentLocation;
    }

    public String getIncidentId() {
        return incidentId;
    }

    public String getIncidentTitle() {
        return incidentTitle;
    }

    public String getIncidentLocation() {
        return incidentLocation;
    }
}

