package com.cab.booking.application.controllers;

import com.cab.booking.application.dtos.DriverDTO;
import com.cab.booking.application.dtos.ResponseObject;
import com.cab.booking.application.dtos.UserDTO;
import com.cab.booking.application.service.DriverService;
import com.cab.booking.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping("/createDriver")
    public ResponseEntity<ResponseObject> createDriver(@RequestBody DriverDTO driverDTO) {
        return new ResponseEntity<>(driverService.createDriver(driverDTO), HttpStatus.CREATED);
    }

    @GetMapping("/getAllDriver")
    public ResponseEntity<ResponseObject> getAllDriver() {
        ResponseObject responseObject = new ResponseObject();

        List<DriverDTO> driverDTOList = driverService.getAllDrivers();
        responseObject.setMessage("Fetched All Drivers");
        responseObject.setSuccess(true);
        responseObject.setData(driverDTOList);

        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }

    @GetMapping("/{driverId}")
    public ResponseEntity<ResponseObject> getDriverById(@PathVariable String driverId) {
        ResponseObject responseObject = new ResponseObject();

        DriverDTO driverDTO = driverService.getDriverById(driverId);

        responseObject.setMessage("Driver With Id: " + driverId + " is Found");
        responseObject.setSuccess(true);
        responseObject.setData(driverDTO);

        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }

    @PutMapping("/{driverId}")
    public ResponseEntity<ResponseObject> updateDriver(@RequestBody DriverDTO driverDTO, @PathVariable String driverId) {
        return new ResponseEntity<>(driverService.updateDriver(driverDTO, driverId), HttpStatus.OK);
    }

    @DeleteMapping("/{driverId}")
    public ResponseEntity<ResponseObject> deleteDriver(@PathVariable String driverId) {
        ResponseObject responseObject = new ResponseObject();

        driverService.deleteDriver(driverId);

        responseObject.setMessage("Driver With Id: " + driverId + " Deleted Successfully");
        responseObject.setSuccess(true);
        responseObject.setData(null);

        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }
}
