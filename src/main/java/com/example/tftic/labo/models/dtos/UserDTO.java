package com.example.tftic.labo.models.dtos;

import com.example.tftic.labo.models.entity.User;

public record UserDTO(

        Long userId,

        String username,

        String email
) {

    public static UserDTO fromEntity(User user){

        if( user == null )
            return null;

        return new UserDTO(
                user.getUserId(),
                user.getUsername(),
                user.getEmail()
        );
    }
}
