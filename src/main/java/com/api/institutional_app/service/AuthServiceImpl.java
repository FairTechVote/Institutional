package com.api.institutional_app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.institutional_app.dto.CoordinatorAuthRequest;
import com.api.institutional_app.dto.CoordinatorAuthResponse;
import com.api.institutional_app.entity.Coordinator;
import com.api.institutional_app.exception.InvalidCredentialsException;
import com.api.institutional_app.repository.CoordinatorRepo;
import com.api.institutional_app.security.JwtProvider;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final CoordinatorRepo coordinatorRepo;
    private final JwtProvider jwtProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public CoordinatorAuthResponse login(CoordinatorAuthRequest request) {

        Optional<Coordinator> search = coordinatorRepo
                .findByEmail(request.email());

        if (search.isEmpty()) {
            throw new InvalidCredentialsException("Email não encontrado");
        }

        Coordinator coordinator = search.get();

        if (!passwordEncoder.matches(request.password(), coordinator.getPassword())) {
            throw new InvalidCredentialsException("Senha incorreta");
        }

        String token = jwtProvider.generateToken(coordinator.getEmail());

        return new CoordinatorAuthResponse(
                token,
                coordinator.getId(),
                coordinator.getEmail(),
                coordinator.getName());
    }
}
