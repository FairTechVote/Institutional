package com.api.institutional_app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.institutional_app.entity.Institute;

@Repository
public interface InstituteRepo extends JpaRepository<Institute, Long> {

    public Optional<List<Institute>> findByName(String name);

    public Optional<List<Institute>> findByNameAndCnpj(String name, String cnpj);

}
