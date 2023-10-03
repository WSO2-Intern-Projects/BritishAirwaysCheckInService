package com.british_ariways.services.controller;

public class QueryParametersForCheckInService {
    private String passengerName;
    private String bookReference;

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getBookReference() {
        return bookReference;
    }

    public void setBookReference(String bookReference) {
        this.bookReference = bookReference;
    }
}