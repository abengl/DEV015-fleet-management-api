package com.fleetmanagement.api_rest.service;

import com.fleetmanagement.api_rest.model.Trajectory;
import com.fleetmanagement.api_rest.repository.TrajectoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;

@Service
public class TrajectoryService {
	private final TrajectoryRepository trajectoryRepository;

	@Autowired
	public TrajectoryService(TrajectoryRepository trajectoryRepository) {
		this.trajectoryRepository = trajectoryRepository;
	}

	/*public List<Trajectory> getAllTrajectories() {
		return trajectoryRepository.findAll();
	}*/

	public Page<Trajectory> getAllTrajectories(Pageable pageable) {
		return trajectoryRepository.findAll(pageable);
	}

	public Page<Trajectory> getTrajectoriesByIdAndDate(Integer taxiId, Timestamp date, Pageable pageable) {
		if (taxiId != null && date != null) {
			return trajectoryRepository.findByIdAndDate(taxiId, date, pageable);
		} else if (taxiId != null) {
			return trajectoryRepository.findById(taxiId, pageable);
		} else if (date != null) {
			return trajectoryRepository.findByDate(date, pageable);
		} else {
			return trajectoryRepository.findAll(pageable);
		}
	}
}
