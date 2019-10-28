package com.anhtu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Embeddable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Embeddable
public class TimeFrame {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("from")
    Timestamp fromDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("to")
    Timestamp toDate;

    public TimeFrame(Timestamp fromDate, Timestamp toDate) {
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public Timestamp getFromDate() {
        return fromDate;
    }

    public void setFromDate(Timestamp fromDate) {
        this.fromDate = fromDate;
    }

    public Timestamp getToDate() {
        return toDate;
    }

    public void setToDate(Timestamp toDate) {
        this.toDate = toDate;
    }

    public TimeFrame() {}
}
