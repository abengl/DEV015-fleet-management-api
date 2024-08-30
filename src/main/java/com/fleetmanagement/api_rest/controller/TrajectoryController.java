package com.fleetmanagement.api_rest.controller;

import com.fleetmanagement.api_rest.model.Trajectory;
import com.fleetmanagement.api_rest.service.TrajectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/trajectories")
public class TrajectoryController {

	private final TrajectoryService trajectoryService;

	@Autowired
	public TrajectoryController(TrajectoryService trajectoryService) {
		this.trajectoryService = trajectoryService;
	}

/*
	@GetMapping("/")
	public ResponseEntity<List<Trajectory>> getAllTrajectories(
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "limit", defaultValue = "5") int limit) {
		Pageable pageable = PageRequest.of(page, limit);
		Page<Trajectory> pageTrajectories = trajectoryService.getAllTrajectories(pageable);
		return ResponseEntity.ok(pageTrajectories.getContent());

	}
*/

	@GetMapping("/{taxiId}")
	public ResponseEntity<List<Trajectory>> getTrajectoriesByIdAndDate(
			@PathVariable Integer taxiId,
			@RequestParam(name = "date", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "limit", defaultValue = "10") int limit) {

		/*if (!trajectoryService.checkTaxiExists(taxiId)) {
			throw new NoSuchElementException("Taxi ID not found");
		}

		if (taxiId == null || taxiId <= 0) {
			throw new IllegalArgumentException("Invalid taxiId");
		}

		if (date == null) {
			throw new IllegalArgumentException("Date is missing or incorrectly formatted");
		}*/

		// Validate taxiId
		if (taxiId == null || taxiId <= 0) {
			return ResponseEntity.badRequest().body(null); // Returning 400 Bad Request
		}

		// Validate date
		if (date == null) {
			return ResponseEntity.badRequest().body(null); // Returning 400 Bad Request
		}

		// Check if taxi exists
		if (!trajectoryService.checkTaxiExists(taxiId)) {
			return ResponseEntity.notFound().build(); // Returning 404 Not Found
		}

		Pageable pageable = PageRequest.of(page, limit);
		Page<Trajectory> pageTrajectories = trajectoryService.getTrajectoriesByIdAndDate(taxiId, date, pageable);
		return ResponseEntity.ok(pageTrajectories.getContent());
	}

}
