package com.anhtu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("from")
    Timestamp fromDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("to")
    Timestamp toDate;

    @Column(name = "roomName")
    String roomName;

    String login;
    String password;

    public Reservation(String roomName, String login, String password, Timestamp from, Timestamp to) {
        this.fromDate = from;
        this.toDate = to;
        this.roomName = roomName;
        this.login = login;
        this.password = password;
    }

    public Reservation() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getFrom() {
        return fromDate;
    }

    public void setFrom(Timestamp from) {
        this.fromDate = from;
    }

    public Timestamp getTo() {
        return toDate;
    }

    public void setTo(Timestamp to) {
        this.toDate = to;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
