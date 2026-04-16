package com.api.institutional_app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.institutional_app.entity.Coordinator;

@Repository
public interface CoordinatorRepo extends JpaRepository<Coordinator, Long> {

    Optional<Coordinator> findByEmail(String email);

    Optional<Coordinator> findByCpf(String cpf);

}
