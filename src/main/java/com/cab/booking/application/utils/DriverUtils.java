package com.cab.booking.application.utils;

import com.cab.booking.application.dtos.ResponseObject;
import com.cab.booking.application.model.Driver;
import com.cab.booking.application.model.User;
import com.cab.booking.application.repository.DriverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DriverUtils {

    @Autowired
    private DriverRepo driverRepo;

    public ResponseObject validateMobileNumber(String mobile, String id) {
        ResponseObject responseObject = new ResponseObject();
        List<Driver> drivers = driverRepo.findByMobileNumber(mobile);
        if (id != null) {
            if (!drivers.isEmpty()) {
                drivers.removeIf(driver -> driver.getId().equals(id));
            }
        }
        if (!drivers.isEmpty()) {
            responseObject.setSuccess(false);
            responseObject.setMessage("Mobile Number: " + mobile + " is already registered with other driver.");
        } else {
            responseObject.setSuccess(true);
            responseObject.setMessage("Mobile Number validated successfully");
        }
        return responseObject;
    }
}
