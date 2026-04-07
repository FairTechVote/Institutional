package com.api.institutional_app.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.institutional_app.entity.SysLogs;

@Repository
public interface SysLogsRepo extends JpaRepository<SysLogs, Long> {

    List<SysLogs> findByChangedAtBetween(LocalDateTime start, LocalDateTime end);

}
