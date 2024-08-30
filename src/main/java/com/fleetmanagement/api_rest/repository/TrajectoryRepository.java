package com.fleetmanagement.api_rest.repository;

import com.fleetmanagement.api_rest.model.Trajectory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface TrajectoryRepository extends JpaRepository<Trajectory, Integer> {
	Page<Trajectory> findByIdAndDate(Integer taxiId, Timestamp date, Pageable pageable);
	Page<Trajectory> findById(Integer taxiId, Pageable pageable);
	Page<Trajectory> findByDate(Timestamp date, Pageable pageable);
}
