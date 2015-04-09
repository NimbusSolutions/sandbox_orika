package com.nimbus.domain;

import java.util.List;

/**
 * Created by Kye on 09/04/15.
 */
public class Journey {

    private String pnr;
    private List<Passenger> passengers;

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }
}
