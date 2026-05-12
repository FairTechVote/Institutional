package com.api.institutional_app.service;

import com.api.institutional_app.dto.CoordinatorInstituteListResponse;

public interface InstituteService {
    
    public CoordinatorInstituteListResponse getCoordinatorInstitute(Long coordinatorId);

}
