package com.api.institutional_app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.institutional_app.dto.CoordinatorAuthResponse;
import com.api.institutional_app.dto.RequestCoordinator;
import com.api.institutional_app.entity.Coordinator;
import com.api.institutional_app.exception.BadRequestException;
import com.api.institutional_app.exception.ConflictException;
import com.api.institutional_app.repository.CoordinatorRepo;
import com.api.institutional_app.security.JwtProvider;
import com.api.institutional_app.util.Status;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final CoordinatorRepo coordinatorRepo;
    private final JwtProvider jwtProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public CoordinatorAuthResponse registerCoordinator(RequestCoordinator request) {

        Optional<Coordinator> emailExists = coordinatorRepo
                .findByEmail(request.email());

        if (emailExists.isPresent()) {
            throw new ConflictException("Email já vinculado a conta");
        }

        Optional<Coordinator> cpfExists = coordinatorRepo
                .findByCpf(request.cpf());

        if (cpfExists.isPresent()) {
            throw new ConflictException("CPF já está cadastrado");
        }

        if (request.cpf() == null || request.cpf().length() != 14) {
            throw new BadRequestException("CPF inválido. Formato esperado: XX.XXX.XXX/XXXX-XX");
        }

        if (request.email() == null || request.email().isBlank()) {
            throw new BadRequestException("Email não pode estar vazio");
        }

        if (request.name() == null || request.name().isBlank()) {
            throw new BadRequestException("Nome não pode estar vazio");
        }

        if (request.password() == null || request.password().length() < 6) {
            throw new BadRequestException("Senha deve ter no mínimo 6 caracteres");
        }

        String encodedPassword = passwordEncoder.encode(request.password());

        Coordinator newCoordinator = new Coordinator();
        newCoordinator.setName(request.name());
        newCoordinator.setCpf(request.cpf());
        newCoordinator.setEmail(request.email());
        newCoordinator.setPassword(encodedPassword);
        newCoordinator.setStatus(Status.ACTIVE);

        Coordinator savedCoordinator = coordinatorRepo.save(newCoordinator);

        String token = jwtProvider.generateToken(savedCoordinator.getEmail());

        return new CoordinatorAuthResponse(
                token,
                savedCoordinator.getId(),
                savedCoordinator.getEmail(),
                savedCoordinator.getName());
    }

}
