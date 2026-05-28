package com.api.institutional_app.service;

//Internal components
import com.api.institutional_app.dto.ResponseCoordinator;
import com.api.institutional_app.dto.RequestCoordinator;

public interface CoordinatorService {

	public ResponseCoordinator getCoordinatorById(
		Long request);

	public ResponseCoordinator updateCoordinator(
		RequestCoordinator request);

}