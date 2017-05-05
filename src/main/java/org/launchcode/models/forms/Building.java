package org.launchcode.models.forms;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by henry on 5/3/17.
 */
@Entity
public class Building {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=5, max=20)
    private String address;

    @NotNull
    @Size(min=1)
    private Integer units;

    @NotNull
    @Size(min=2)
    private String city;

    @NotNull
    @Size(min=2)
    private String state;

    @NotNull
    @Size(min=5, max=5)
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
