package org.launchcode.models.forms;

import org.hibernate.validator.constraints.Email;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by henry on 5/3/17.
 */
@Entity
public class Tenant {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    @ManyToOne
    private Building building;

    @NotNull
    private String unit;

    @NotNull
    private int phoneNumber;

    private Integer altNumber;

    @Email
    private String email;

//    private Integer rentAmt;
//    private Integer depositAmt;
//    private Date moveInDate;
//    private Date depositPaidDate;

    public Tenant(String name, Integer phoneNumber, Integer altNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.altNumber = altNumber;
        this.email = email;
    }

    public Tenant() { }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAltNumber() {
        return altNumber;
    }

    public void setAltNumber(Integer altNumber) {
        this.altNumber = altNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
