package com.api.institutional_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.institutional_app.entity.SysLogs;

@Repository
public interface SysLogsRepo extends JpaRepository<SysLogs, Long> {

}
