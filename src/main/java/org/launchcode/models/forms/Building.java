package org.launchcode.models.forms;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by henry on 5/3/17.
 */
@Entity
public class Building {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String address;

    @NotNull
    private Integer units;

    @NotNull
    private String city;

    @NotNull
    private String state;

    @NotNull
    private Integer zipCode;

    public Building(String address, Integer units, String city, String state, Integer zipCode) {
        this.address = address;
        this.units = units;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Building() { }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }
}
