package com.anhtu.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Entity
public class Room {

    @Id
    @Length(max = 50)
    private String name;

    @Length(max = 256)
    private String location;

    @NotNull
    @Max(100)
    private Long seats;

    @Column(columnDefinition = "enum('yes', 'no') default 'no'")
    private PROJECTOR projector;

    @Length(max = 100)
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public Room(String name, String location, Long seats, PROJECTOR projector, String phoneNumber) {
        this.name = name;
        this.location = location;
        this.seats = seats;
        this.projector = projector;
        this.phoneNumber = phoneNumber;
    }

    public Room(String name, String location, Long seats, PROJECTOR projector) {
        this.name = name;
        this.location = location;
        this.seats = seats;
        this.projector = projector;
    }

    public Room(String name, String location, Long seats) {
        this.name = name;
        this.location = location;
        this.seats = seats;
    }

    public Room() {}

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getSeats() {
        return seats;
    }

    public void setSeats(Long seats) {
        this.seats = seats;
    }

    public PROJECTOR getProjector() {
        return projector;
    }

    public void setProjector(PROJECTOR projector) {
        this.projector = projector;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
