package com.example.tftic.labo.models.form;

import com.example.tftic.labo.models.entity.User;
import jakarta.validation.constraints.NotBlank;

public class UserForm {
     String username;
     String password;
     String email;
     Long userId;

    public User toEntity(){
        User user = new User();
        user.setUsername( username );
        user.setPassword( password );
        user.setEmail( email );
        user.setUserId( userId );
        return user;
    }
}
