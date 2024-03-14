package com.cab.booking.application.service;

import com.cab.booking.application.dtos.ResponseObject;
import com.cab.booking.application.dtos.RideDTO;
import com.cab.booking.application.exception.DriverNotFoundException;
import com.cab.booking.application.exception.NoUserFoundException;
import com.cab.booking.application.model.Driver;
import com.cab.booking.application.model.User;
import com.cab.booking.application.repository.DriverRepo;
import com.cab.booking.application.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RideService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private DriverRepo driverRepo;

    private long destXCoordinate;
    private long destYCoordinate;

    public ResponseObject find_ride(RideDTO rideDTO) {
        ResponseObject responseObject = new ResponseObject();
        //user should be present to find ride.
        List<User> users = userRepo.findByMobileNumber(rideDTO.getUsername());
        if (users.isEmpty()) {
            throw new NoUserFoundException("No User found with username : " + rideDTO.getUsername());
        }

        //Save destination coordinates for use in choose_ride_service later
        destXCoordinate = rideDTO.getDestinationXCoordinates();
        destYCoordinate = rideDTO.getDestinationYCoordinates();

        List<Driver> availableDrivers = new ArrayList<>();
        // Fetching all drivers who are currently available
        List<Driver> driverList = driverRepo.findAllByIsAvailable(true);
        for (Driver driver : driverList) {
            double driverDistance = calculateDistance(driver.getxCoordinates(), driver.getyCoordinates(),
                    rideDTO.getSourceXCoordinates(), rideDTO.getSourceYCoordinates());

            if(driver.isAvailable() && driverDistance <= 5.0)
            {
                availableDrivers.add(driver);
            }
        }
        if (availableDrivers.isEmpty()) {
            responseObject.setSuccess(false);
            responseObject.setMessage("No ride found [Since all the driver are more than 5 units away from user]");
            return responseObject;
        }
        responseObject.setSuccess(true);
        responseObject.setMessage("Drivers Available for ride [Available]");
        responseObject.setData(availableDrivers);
        return responseObject;
    }

    //Calculates distance between 2 points in 2 dimensions
    private double calculateDistance(long sourceXCoordinate, long sourceYCoordinate,
                                  long destXCoordinate, long destYCoordinate)
    {
        double xDistance = Math.pow(sourceXCoordinate - destXCoordinate, 2);
        double yDistance = Math.pow(sourceYCoordinate - destYCoordinate, 2);

        return Math.sqrt(xDistance + yDistance);
    }

    public ResponseObject choose_ride(String userMobileNumber, String driverMobileNumber) {
        ResponseObject responseObject = new ResponseObject();

        List<User> users = userRepo.findByMobileNumber(userMobileNumber);
        if (users.isEmpty()) {
            throw new NoUserFoundException("No User found with username : " + userMobileNumber);
        }
        User user = users.get(0);
        List<Driver> drivers = driverRepo.findByMobileNumber(driverMobileNumber);
        if (drivers.isEmpty()) {
            throw new DriverNotFoundException("No Driver found with username : " + driverMobileNumber);
        }
        Driver driver = drivers.get(0);
        //Driver has been locked for the ride for this user.
        driver.setxCoordinates(destXCoordinate);
        driver.setyCoordinates(destYCoordinate);
        driver.setAvailable(false);
        driverRepo.save(driver);
        responseObject.setSuccess(true);
        responseObject.setMessage("Driver with name : " + driver.getName() + " will fulfill the ride request for user with name : " + user.getName());
        return responseObject;
    }
}
