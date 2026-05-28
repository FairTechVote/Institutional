package com.api.institutional_app.controller;

//Rest components

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Internal depedencys
import com.api.institutional_app.dto.ResponseCoordinator;
import com.api.institutional_app.dto.RequestCoordinator;


//Lombok components
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/coordinator")
@RequiredArgsConstructor
public class CoordinatorController {

	@GetMapping("/{id}")
	public ResponseEntity<ResponseCoordinator> getCoordinatorById(
		@PathVariable Long id
	) {
		return ResponseEntity.ok(null);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ResponseCoordinator> updateCoordinator(
		@PathVariable Long id,
		@RequestBody RequestCoordinator request
	) {
		return ResponseEntity.ok(null);
	}

}