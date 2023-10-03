package com.british_ariways.services.controller;
import com.british_ariways.services.model.BritishAirwaysTb;
import com.british_ariways.services.service.FlightCheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class ServicesController {

    @Autowired
    FlightCheckInService flightCheckInService;
//    @PostMapping("/createCustomer")
//    public BritishAirwaysTb saveCustomer(@RequestBody BritishAirwaysTb customer){
//        return flightCheckInService.create(customer);
//    }

    @PostMapping("/checkIn")
    public FilterResponseForCheckInService search(@RequestBody QueryParametersForCheckInService queryParametersForCheckInService) {
        BritishAirwaysTb britishAirwaysTb = flightCheckInService.findByPassengerNameAndBookReference(queryParametersForCheckInService.getPassengerName(), queryParametersForCheckInService.getBookReference());

        FilterResponseForCheckInService filterResponseForCheckInService = new FilterResponseForCheckInService();

        if (britishAirwaysTb == null){
            filterResponseForCheckInService.setFlightNumber(null);
            filterResponseForCheckInService.setCustomerId(null);
            filterResponseForCheckInService.setFlightDistance(null);
            filterResponseForCheckInService.setPassengerName(null);
            filterResponseForCheckInService.setFrom(null);
            filterResponseForCheckInService.setTo(null);
            filterResponseForCheckInService.setSeatNumber(null);
        }else{
            filterResponseForCheckInService.setFlightNumber(britishAirwaysTb.getFlightNumber());
            filterResponseForCheckInService.setCustomerId(britishAirwaysTb.getCustomerId());
            filterResponseForCheckInService.setFlightDistance(britishAirwaysTb.getFlightDistance());
            filterResponseForCheckInService.setPassengerName(britishAirwaysTb.getPassengerName());
            filterResponseForCheckInService.setFrom(britishAirwaysTb.getFlightFrom());
            filterResponseForCheckInService.setTo(britishAirwaysTb.getFlightTo());
            filterResponseForCheckInService.setSeatNumber(britishAirwaysTb.getSeatNumber());
        }


//        FinalResponseForCheckInService response = new FinalResponseForCheckInService();
//        response.setCheckIn(filterResponseForCheckInService);
        return filterResponseForCheckInService;
    }

}
