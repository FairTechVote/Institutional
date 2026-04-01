package com.api.institutional_app.dto;

import java.util.List;

public record ResponseInstitute(
                Long id,
                String name,
                String cnpj,
                Double locallat,
                Double locallong,
                List<SummaryEventDto> events,
                List<SummaryCoordinatorDto> coordinators) {

}
