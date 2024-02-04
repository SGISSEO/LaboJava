package com.example.tftic.labo.bll.services.impl;

import com.example.tftic.labo.bll.services.service.UserService;
import com.example.tftic.labo.models.entity.Salle;
import com.example.tftic.labo.models.entity.User;
import com.example.tftic.labo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }


    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long userId) {
        return userRepository.findById(userId).orElseThrow();
    }

    @Override
    public User insert(User user) {
        return userRepository.save( user );
    }

    @Override
    public User update(Long userId, User user) {
        User toUpdate = getById( userId );
        toUpdate.setPassword( user.getPassword() );
        toUpdate.setUsername( user.getUsername() );
        toUpdate.setEmail( user.getEmail() );
        toUpdate.setUserId( user.getUserId() );
        return userRepository.save( toUpdate );
    }

    @Override
    public void delete(Long userId) {
        User toDelete = getById( userId );
        userRepository.delete( toDelete );
    }

    @Override
    public User register(User user) {
        user.setPassword( encoder.encode(user.getPassword()) );
        return userRepository.save(user);
    }

    @Override
    public User login(User user) {

        User existingUser = userRepository.findByUsername(user.getUsername()).orElseThrow();
        if(!encoder.matches(user.getPassword(), existingUser.getPassword())){
            throw new RuntimeException("Wrong password");
        }
        return existingUser;
    }
}
