package com.api.institutional_app.entity;

import java.time.LocalDateTime;

import com.api.institutional_app.util.OperationType;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "sys_logs")
public class SysLogs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OperationType operationType;

    @Column(name = "table_name", nullable = false)
    private String tableName;

    @Column(name = "old_data", columnDefinition = "jsonb", nullable = true)
    private String oldData;

    @Column(name = "new_data", columnDefinition = "jsonb", nullable = true)
    private String newData;

    @Column(name = "changed_at", nullable = false, updatable = false)
    private LocalDateTime changedAt = LocalDateTime.now();

}
