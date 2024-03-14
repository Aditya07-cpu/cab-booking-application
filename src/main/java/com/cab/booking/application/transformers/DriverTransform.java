package com.cab.booking.application.transformers;

import com.cab.booking.application.dtos.DriverDTO;
import com.cab.booking.application.model.Driver;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DriverTransform {

    @Autowired
    private ModelMapper modelMapper;

    public Driver driverDtoToDriver(DriverDTO driverDTO) {
        Driver driver = modelMapper.map(driverDTO, Driver.class);
        return driver;
    }

    public DriverDTO driverToDriverDto(Driver driver) {
        DriverDTO driverDTO = modelMapper.map(driver, DriverDTO.class);
        return driverDTO;
    }
}
