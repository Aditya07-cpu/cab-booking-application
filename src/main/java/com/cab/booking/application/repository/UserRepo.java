package com.cab.booking.application.repository;

import com.cab.booking.application.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    List<User> findByMobileNumber(String mobileNumber);
}
