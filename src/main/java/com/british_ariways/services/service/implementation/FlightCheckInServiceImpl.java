package com.british_ariways.services.service.implementation;

import com.british_ariways.services.model.BritishAirwaysTb;
import com.british_ariways.services.repository.CustomerRepository;
import com.british_ariways.services.service.FlightCheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightCheckInServiceImpl implements FlightCheckInService {

    @Autowired
    CustomerRepository customerRepository;
    @Override
    public BritishAirwaysTb create(BritishAirwaysTb customer) {

        return customerRepository.save(customer);
    }

    @Override
    public BritishAirwaysTb findByPassengerNameAndBookReference(String PassengerName, String bookReference) {
        return customerRepository.fetchUsingPassengerNameAndBookReference(PassengerName,bookReference);
    }

}
