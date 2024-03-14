package com.cab.booking.application.controllers;

import com.cab.booking.application.dtos.ResponseObject;
import com.cab.booking.application.dtos.RideDTO;
import com.cab.booking.application.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ride")
public class RideController {

    @Autowired
    private RideService rideService;

    @GetMapping("/find_ride")
    public ResponseEntity<ResponseObject> find_ride(@RequestParam(name = "mobileNumber") String mobileNumber,
                                                    @RequestParam(name = "sourceXCoordinate") Long sourceXCoordinate,
                                                    @RequestParam(name = "sourceYCoordinate") Long sourceYCoordinate,
                                                    @RequestParam(name = "destXCoordinate") Long destXCoordinate,
                                                    @RequestParam(name = "destYCoordinate") Long destYCoordinate) {
        RideDTO rideDTO = new RideDTO(mobileNumber, sourceXCoordinate, sourceYCoordinate, destXCoordinate, destYCoordinate);
        return new ResponseEntity<>(rideService.find_ride(rideDTO), HttpStatus.OK);
    }

    @GetMapping("/choose_ride")
    public ResponseEntity<ResponseObject> choose_ride(@RequestParam(name = "userMobileNumber") String userMobileNumber, @RequestParam(name = "driverMobileName") String driverMobileName) {
        return new ResponseEntity<>(rideService.choose_ride(userMobileNumber, driverMobileName), HttpStatus.OK);
    }
}
