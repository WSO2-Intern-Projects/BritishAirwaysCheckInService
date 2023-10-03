package com.british_ariways.services.service;

import com.british_ariways.services.model.BritishAirwaysTb;
import org.springframework.stereotype.Service;

@Service
public interface FlightCheckInService {
    public BritishAirwaysTb create(BritishAirwaysTb customer);

    public BritishAirwaysTb findByPassengerNameAndBookReference(String passengerName, String bookReference);
}
