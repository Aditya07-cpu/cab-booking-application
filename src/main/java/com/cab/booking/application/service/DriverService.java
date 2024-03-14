package com.cab.booking.application.service;

import com.cab.booking.application.dtos.DriverDTO;
import com.cab.booking.application.dtos.ResponseObject;
import com.cab.booking.application.exception.DriverNotFoundException;
import com.cab.booking.application.model.Driver;
import com.cab.booking.application.repository.DriverRepo;
import com.cab.booking.application.transformers.DriverTransform;
import com.cab.booking.application.utils.DriverUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverService {

    @Autowired
    private DriverRepo driverRepo;
    @Autowired
    private DriverTransform driverTransform;
    @Autowired
    private DriverUtils driverUtils;

    public ResponseObject createDriver(DriverDTO driverDTO) {
        ResponseObject responseObject = new ResponseObject();
        ResponseObject validateMobileNumberResponse = driverUtils.validateMobileNumber(driverDTO.getMobileNumber(), null);
        if (!validateMobileNumberResponse.isSuccess()) {
            return validateMobileNumberResponse;
        }
        Driver driver = driverTransform.driverDtoToDriver(driverDTO);
        Driver savedDriver = driverRepo.save(driver);
        DriverDTO driverDto = driverTransform.driverToDriverDto(savedDriver);

        responseObject.setSuccess(true);
        responseObject.setMessage("Driver Successfully Created !!");
        responseObject.setData(driverDto);
        return responseObject;
    }

    public ResponseObject updateDriver(DriverDTO driverDTO, String driverId) {
        ResponseObject responseObject = new ResponseObject();
        Driver driver = driverRepo.findById(driverId).orElseThrow(() -> new DriverNotFoundException("No Driver found with user Id : " + driverId));

        ResponseObject validateMobileNumberResponse = driverUtils.validateMobileNumber(driverDTO.getMobileNumber(), driverId);
        if (!validateMobileNumberResponse.isSuccess()) {
            return validateMobileNumberResponse;
        }

        driver.setId(driverId);
        driver.setName(driverDTO.getName());
        driver.setAge(driverDTO.getAge());
        driver.setGender(driverDTO.getGender());
        driver.setMobileNumber(driverDTO.getMobileNumber());
        driver.setAvailable(driverDTO.isAvailable());
        driver.setRegistrationNumber(driverDTO.getRegistrationNumber());
        driver.setVehicleName(driverDTO.getVehicleName());
        driver.setVehicleType(driverDTO.getVehicleType());
        driver.setxCoordinates(driverDTO.getxCoordinates());
        driver.setyCoordinates(driverDTO.getyCoordinates());

        Driver updatedDriver = driverRepo.save(driver);

        DriverDTO driverDto = driverTransform.driverToDriverDto(updatedDriver);
        responseObject.setSuccess(true);
        responseObject.setMessage("User Successfully Updated !!");
        responseObject.setData(driverDto);
        return responseObject;
    }

    public DriverDTO getDriverById(String driverId) {
        Driver driver = driverRepo.findById(driverId).orElseThrow(() -> new DriverNotFoundException("No Driver found with Id: " + driverId));
        return driverTransform.driverToDriverDto(driver);
    }

    public List<DriverDTO> getAllDrivers() {
        List<DriverDTO> driverDTOS = driverRepo.findAll().stream().map(driver -> driverTransform.driverToDriverDto(driver)).collect(Collectors.toList());
        return driverDTOS;
    }

    public void deleteDriver(String driverId) {
        Driver driver = driverRepo.findById(driverId).orElseThrow(() -> new DriverNotFoundException("No Driver found with Id: " + driverId));
        driverRepo.deleteById(driverId);
    }
}
