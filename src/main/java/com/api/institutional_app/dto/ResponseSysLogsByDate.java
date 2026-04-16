package com.api.institutional_app.dto;

import java.util.List;

public record ResponseSysLogsByDate(
                List<SummarySysLogs> sysLogs) {
}
