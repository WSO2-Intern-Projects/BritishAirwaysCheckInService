package com.british_ariways.services.controller;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FilterResponseForCheckInService {

    private String flightNumber;
    private String seatNumber;
    private String passengerName;
    private String customerId;
    private String From;
    private String To;
    private Integer flightDistance;

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public String getTo() {
        return To;
    }

    public void setTo(String to) {
        To = to;
    }

    public Integer getFlightDistance() {
        return flightDistance;
    }

    public void setFlightDistance(Integer flightDistance) {
        this.flightDistance = flightDistance;
    }
}
