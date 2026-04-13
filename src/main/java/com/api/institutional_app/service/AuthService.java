package com.api.institutional_app.service;

import com.api.institutional_app.dto.CoordinatorAuthRequest;
import com.api.institutional_app.dto.CoordinatorAuthResponse;

public interface AuthService {

    public CoordinatorAuthResponse login(CoordinatorAuthRequest request);

}
