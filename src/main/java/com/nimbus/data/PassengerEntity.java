package com.nimbus.data;

/**
 * Created by Kye on 09/04/15.
 */
public class PassengerEntity {


    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String passportId;
    private String phone;
    private JourneyEntity journeyEntity;

    public JourneyEntity getJourneyEntity() {
        return journeyEntity;
    }

    public void setJourneyEntity(JourneyEntity journeyEntity) {
        this.journeyEntity = journeyEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



}
