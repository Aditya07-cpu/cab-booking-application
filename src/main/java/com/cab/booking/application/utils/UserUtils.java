package com.cab.booking.application.utils;

import com.cab.booking.application.dtos.ResponseObject;
import com.cab.booking.application.model.User;
import com.cab.booking.application.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserUtils {

    @Autowired
    private UserRepo userRepo;

    public ResponseObject validateMobileNumber(String mobile, String id) {
        ResponseObject responseObject = new ResponseObject();
        List<User> users = userRepo.findByMobileNumber(mobile);
        if (id != null) {
            if (!users.isEmpty()) {
                users.removeIf(user -> user.getId().equals(id));
            }
        }
        if (!users.isEmpty()) {
            responseObject.setSuccess(false);
            responseObject.setMessage("Mobile Number: " + mobile + " is already registered with other user.");
        } else {
            responseObject.setSuccess(true);
            responseObject.setMessage("Mobile Number validated successfully");
        }
        return responseObject;
    }
}
