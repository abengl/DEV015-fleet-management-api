package com.fleetmanagement.api_rest.service;

import com.fleetmanagement.api_rest.model.Trajectory;
import com.fleetmanagement.api_rest.repository.TaxiRepository;
import com.fleetmanagement.api_rest.repository.TrajectoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;

@Service
public class TrajectoryService {
	private final TrajectoryRepository trajectoryRepository;
	private final TaxiRepository taxiRepository; // Assuming you have a repository to check taxi existence

	@Autowired
	public TrajectoryService(TrajectoryRepository trajectoryRepository, TaxiRepository taxiRepository) {
		this.trajectoryRepository = trajectoryRepository;
		this.taxiRepository = taxiRepository;
	}

	public Page<Trajectory> getAllTrajectories(Pageable pageable) {
		return trajectoryRepository.findAll(pageable);
	}

	public Page<Trajectory> getTrajectoriesByIdAndDate(Integer taxiId, LocalDate date, Pageable pageable) {
		return trajectoryRepository.findByIdAndDate(taxiId, date, pageable);
	}

	public boolean checkTaxiExists(Integer taxiId) {
		return taxiRepository.existsById(taxiId);
	}
}
