package com.ghackk.assignment.converter;

import com.ghackk.assignment.document.User;
import com.ghackk.assignment.dto.UserDto;

/**
 * @author Ankit Khatri
 */
public class UserConverter {

    public static UserDto entityToDto(final User user){
        return UserDto.builder()
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }

    public static User dtoToEntity(final UserDto userDto){
        return User.builder()
                .password(userDto.getPassword())
                .email(userDto.getEmail())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .build();
    }
}
