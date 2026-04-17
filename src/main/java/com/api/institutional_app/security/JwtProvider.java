package com.api.institutional_app.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtProvider {

    @Value("${JWT_SECRET}")
    private String jwtSecret;

    @Value("${JWT_EXPIRATION}")
    private long jwtExpiration;

    public String generateToken(String email) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpiration);

        return Jwts.builder()
                .subject(email)
                .issuedAt(now)
                .expiration(expiryDate)
                .signWith(getSigninKey())
                .compact();
    }

    public SecretKey getSigninKey() {
        return Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    public String validateTokenAndGetUsername(String token) {
        System.out.println("JWT_SECRET: " + jwtSecret);
        try {
            Claims claims = Jwts.parser()
                    .verifyWith(getSigninKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();

            return claims.getSubject();

        } catch (JwtException e) {
            throw new RuntimeException("Invalid Token");
        }
    }

}
