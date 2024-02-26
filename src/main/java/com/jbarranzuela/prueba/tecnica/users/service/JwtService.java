package com.jbarranzuela.prueba.tecnica.users.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Function;

@Component
@Data
public class JwtService {
    private static final String JWT_SECRET_KEY = "TExBVkVfTVVZX1NFQ1JFVEzE3Zmxu7BSGSJx72BSBXM";
    private static final long JWT_TIME_VALIDITY = 1000 * 60 * 15;

    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TIME_VALIDITY))
                .signWith(SignatureAlgorithm.HS256, JWT_SECRET_KEY)
                .compact();
    }

    public boolean validateToken(String token) {
        return !extractClaim(token, Claims::getExpiration).before(new Date());
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = Jwts.parser().setSigningKey(JWT_SECRET_KEY).build().parseClaimsJws(token).getBody();
        return claimsResolver.apply(claims);
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }
}
