package com.example.tftic.labo.bll.services.service;

import com.example.tftic.labo.models.entity.Salle;
import com.example.tftic.labo.models.entity.User;
import com.example.tftic.labo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService extends CrudService<User, Long>{

    User register(User user);
    User login(User user);



}


