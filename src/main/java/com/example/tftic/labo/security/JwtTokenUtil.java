package com.example.tftic.labo.security;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

public class JwtTokenUtil {

    private static final String SECRET = "votre_secret_key";
    private static final long EXPIRATION_TIME = 864_000_000; // 10 jours

    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    // Ajoutez ici la logique pour extraire des informations du token et valider sa signature.
}
