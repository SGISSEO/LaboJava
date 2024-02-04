package com.example.tftic.labo.repository;

import com.example.tftic.labo.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.username like :username")
    Optional<User> findByUsername(String username);
    // Ajoutez des méthodes spécifiques si nécessaire
}
