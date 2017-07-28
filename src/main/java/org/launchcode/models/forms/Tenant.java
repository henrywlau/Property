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
    @Size(min=3, max=20, message="Name must be between 3 and 20 characters.")
    private String name;

    @ManyToOne
    private Building building;

    private String unit;

    @NotNull
    @Size(min=10, max=10, message="Phone number must be 10 numbers.")
    private String phoneNumber;

    private String altNumber;

    @Email
    private String email;

    @NotNull(message="Please enter a monthly rent amount.")
    private Integer rent;

    @NotNull
    @Size(min=10, max=10, message="Please enter a valid date.")
    private String moveInDate;

    public Tenant(String name, String phoneNumber, String altNumber, String email, Integer rent, String moveInDate) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.altNumber = altNumber;
        this.email = email;
        this.rent = rent;
        this.moveInDate = moveInDate;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAltNumber() {
        return altNumber;
    }

    public void setAltNumber(String altNumber) {
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

    public Integer getRent() {
        return rent;
    }

    public void setRent(Integer rent) {
        this.rent = rent;
    }

    public String getMoveInDate() {
        return moveInDate;
    }

    public void setMoveInDate(String moveInDate) {
        this.moveInDate = moveInDate;
    }
}
