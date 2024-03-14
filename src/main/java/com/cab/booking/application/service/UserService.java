package com.cab.booking.application.service;

import com.cab.booking.application.dtos.ResponseObject;
import com.cab.booking.application.dtos.UserDTO;
import com.cab.booking.application.exception.NoUserFoundException;
import com.cab.booking.application.model.User;
import com.cab.booking.application.repository.UserRepo;
import com.cab.booking.application.transformers.UserTransform;
import com.cab.booking.application.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserTransform userTransform;
    @Autowired
    private UserUtils userUtils;

    public ResponseObject createUser(UserDTO userDTO) {
        ResponseObject responseObject = new ResponseObject();
        ResponseObject validateMobileNumberResponse = userUtils.validateMobileNumber(userDTO.getMobileNumber(), null);
        if (!validateMobileNumberResponse.isSuccess()) {
            return validateMobileNumberResponse;
        }
        User user = userTransform.userDtoToUser(userDTO);
        User savedUser = userRepo.save(user);
        UserDTO userDto = userTransform.userToUserDto(savedUser);

        responseObject.setSuccess(true);
        responseObject.setMessage("User Successfully Created !!");
        responseObject.setData(userDto);
        return responseObject;
    }

    public ResponseObject updateUser(UserDTO userDTO, String userId) {
        ResponseObject responseObject = new ResponseObject();
        User user = userRepo.findById(userId).orElseThrow(() -> new NoUserFoundException("No User found with user Id : " + userId));

        ResponseObject validateMobileNumberResponse = userUtils.validateMobileNumber(userDTO.getMobileNumber(), userId);
        if (!validateMobileNumberResponse.isSuccess()) {
            return validateMobileNumberResponse;
        }

        user.setId(userId);
        user.setName(userDTO.getName());
        user.setAge(userDTO.getAge());
        user.setGender(userDTO.getGender());
        user.setMobileNumber(userDTO.getMobileNumber());

        User updatedUser = userRepo.save(user);

        UserDTO userDto = userTransform.userToUserDto(updatedUser);
        responseObject.setSuccess(true);
        responseObject.setMessage("User Successfully Updated !!");
        responseObject.setData(userDto);
        return responseObject;
    }

    public UserDTO getUserById(String userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new NoUserFoundException("User Not found with user Id: " + userId));
        UserDTO userDTO = userTransform.userToUserDto(user);
        return userDTO;
    }

    public List<UserDTO> getAllUsers() {
        List<UserDTO> userDTOList = userRepo.findAll().stream().map(user -> userTransform.userToUserDto(user)).collect(Collectors.toList());
        return userDTOList;
    }

    public void deleteUser(String userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new NoUserFoundException("No User found with user Id: " + userId));
        userRepo.deleteById(userId);
    }
}
