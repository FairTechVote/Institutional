package com.api.institutional_app.service;

import com.api.institutional_app.dto.CoordinatorAuthResponse;
import com.api.institutional_app.dto.RequestCoordinator;

public interface RegisterService {

    public CoordinatorAuthResponse registerCoordinator(RequestCoordinator request);
}
