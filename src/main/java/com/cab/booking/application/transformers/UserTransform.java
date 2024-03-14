package com.cab.booking.application.transformers;

import com.cab.booking.application.dtos.UserDTO;
import com.cab.booking.application.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserTransform {

    @Autowired
    private ModelMapper modelMapper;

    public User userDtoToUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        return user;
    }

    public UserDTO userToUserDto(User user) {
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
    }
}
