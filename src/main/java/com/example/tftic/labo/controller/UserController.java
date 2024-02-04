package com.example.tftic.labo.controller;


import com.example.tftic.labo.models.dtos.UserDTO;
import com.example.tftic.labo.models.dtos.UserTokenDTO;
import com.example.tftic.labo.models.entity.User;
import com.example.tftic.labo.models.form.LoginForm;
import com.example.tftic.labo.models.form.RegisterForm;
import com.example.tftic.labo.models.form.UserForm;
import com.example.tftic.labo.bll.services.service.UserService;
import com.example.tftic.labo.security.JwtTokenUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/users")
public class UserController {


    private final UserService userService;



    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody RegisterForm form) {
        User user = form.toEntity();
        user = userService.register(user);
        return ResponseEntity.ok()
                .body(UserDTO.fromEntity(user));
    }


    @PostMapping("/login")
    public ResponseEntity<UserTokenDTO> loginUser(@RequestBody LoginForm form) {
        User user = form.toEntity();
        user = userService.login(user);
        UserDTO dto = UserDTO.fromEntity(user);
//        String token = JwtTokenUtil.generateToken(user.getUsername());
        return ResponseEntity.ok()
                .body(new UserTokenDTO(dto,"token"));
    }


    @GetMapping
    public ResponseEntity<List<UserDTO>> getAll(){
        return ResponseEntity.ok(
                userService.getAll().stream()
                        .map( UserDTO::fromEntity )
                        .toList()
        );
    }


    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long userId) {
        return ResponseEntity.ok(
                UserDTO.fromEntity( userService.getById(userId) )
        );
    }


    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody @Valid UserForm form){
        User toCreate = form.toEntity();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        UserDTO.fromEntity( userService.insert( toCreate ) )
                );
    }


    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long userId, @RequestBody @Valid UserForm form) {
        return ResponseEntity.ok(
                UserDTO.fromEntity( userService.update(userId, form.toEntity()) )
        );
    }


    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.delete(userId);
        return ResponseEntity.ok().build();
    }
}
