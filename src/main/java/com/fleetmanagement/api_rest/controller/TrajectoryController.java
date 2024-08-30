package com.fleetmanagement.api_rest.controller;

import com.fleetmanagement.api_rest.model.Trajectory;
import com.fleetmanagement.api_rest.service.TrajectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/trajectories")
public class TrajectoryController {

	private final TrajectoryService trajectoryService;

	@Autowired
	public TrajectoryController(TrajectoryService trajectoryService) {
		this.trajectoryService = trajectoryService;
	}

	@GetMapping("/")
	public ResponseEntity<List<Trajectory>> getAllTrajectories(
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "limit", defaultValue = "5") int limit) {
		Pageable pageable = PageRequest.of(page, limit);
		Page<Trajectory> pageTrajectories = trajectoryService.getAllTrajectories(pageable);
		return ResponseEntity.ok(pageTrajectories.getContent());

	}

	@GetMapping("/{taxiId}")
	public ResponseEntity<List<Trajectory>> getTrajectoriesByIdAndDate(
			@PathVariable Integer taxiId,
			@RequestParam(name = "date", required = false) Timestamp date,
			@RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "limit", defaultValue = "100") int limit) {
		Pageable pageable = PageRequest.of(page, limit);
		Page<Trajectory> pageTrajectories = trajectoryService.getTrajectoriesByIdAndDate(taxiId, date, pageable);
		return ResponseEntity.ok(pageTrajectories.getContent());
	}
}
