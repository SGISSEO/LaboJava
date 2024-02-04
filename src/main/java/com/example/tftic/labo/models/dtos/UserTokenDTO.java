package com.example.tftic.labo.models.dtos;

public record UserTokenDTO(
        UserDTO user,
        String token
) {
}
