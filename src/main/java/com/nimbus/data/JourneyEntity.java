package com.nimbus.data;

import java.util.List;

/**
 * Created by Kye on 09/04/15.
 */
public class JourneyEntity {

    private Long id;
    private String pnr;
    private List<PassengerEntity> passengerEntities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public List<PassengerEntity> getPassengerEntities() {
        return passengerEntities;
    }

    public void setPassengerEntities(List<PassengerEntity> passengerEntities) {
        this.passengerEntities = passengerEntities;
    }
}
