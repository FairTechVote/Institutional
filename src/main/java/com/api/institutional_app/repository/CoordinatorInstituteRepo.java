package com.api.institutional_app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.institutional_app.entity.CoordinatorInstitute;
import com.api.institutional_app.util.Status;

@Repository
public interface CoordinatorInstituteRepo extends JpaRepository<CoordinatorInstitute, Long> {

    Optional<List<CoordinatorInstitute>> findByCoordinatorIdAndStatus(Long id, Status status);

}
