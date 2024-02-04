package com.example.tftic.labo.models.form;

import com.example.tftic.labo.models.entity.User;
import lombok.Data;

@Data
public class LoginForm {
    private String username;
    private String password;

    public User toEntity(){
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        return user;
    }
}
