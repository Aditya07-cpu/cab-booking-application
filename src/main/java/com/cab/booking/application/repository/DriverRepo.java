package com.cab.booking.application.repository;

import com.cab.booking.application.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepo extends JpaRepository<Driver, String> {
    List<Driver> findByMobileNumber(String mobileNumber);
    List<Driver> findAllByIsAvailable(boolean isAvailable);
}
