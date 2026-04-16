package com.api.institutional_app.dto;

import com.api.institutional_app.util.OperationType;

public record SummarySysLogs(
                Long id,
                OperationType operationType,
                String tableName,
                String oldData,
                String newData,
                String changedAt) {

}
