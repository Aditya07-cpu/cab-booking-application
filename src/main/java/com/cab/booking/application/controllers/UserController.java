package com.cab.booking.application.controllers;

import com.cab.booking.application.dtos.ResponseObject;
import com.cab.booking.application.dtos.UserDTO;
import com.cab.booking.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<ResponseObject> createUser(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.createUser(userDTO), HttpStatus.CREATED);
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<ResponseObject> getAllUser() {
        ResponseObject responseObject = new ResponseObject();

        List<UserDTO> userDTOList = userService.getAllUsers();
        responseObject.setMessage("Fetched All Users");
        responseObject.setSuccess(true);
        responseObject.setData(userDTOList);

        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ResponseObject> getUserById(@PathVariable String userId) {
        ResponseObject responseObject = new ResponseObject();

        UserDTO userDTO = userService.getUserById(userId);

        responseObject.setMessage("User With Id: " + userId + " is Found");
        responseObject.setSuccess(true);
        responseObject.setData(userDTO);

        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<ResponseObject> updateUser(@RequestBody UserDTO userDTO, @PathVariable String userId) {
        return new ResponseEntity<>(userService.updateUser(userDTO, userId), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ResponseObject> deleteUser(@PathVariable String userId) {
        ResponseObject responseObject = new ResponseObject();

        userService.deleteUser(userId);

        responseObject.setMessage("User With Id: " + userId + " Deleted Successfully");
        responseObject.setSuccess(true);
        responseObject.setData(null);

        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }
}
