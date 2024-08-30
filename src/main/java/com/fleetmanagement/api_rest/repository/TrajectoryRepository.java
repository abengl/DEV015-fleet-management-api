package com.fleetmanagement.api_rest.repository;

import com.fleetmanagement.api_rest.model.Trajectory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface TrajectoryRepository extends JpaRepository<Trajectory, Integer> {
	@Query("SELECT t FROM Trajectory t WHERE t.taxiId.id = :taxiId AND DATE(t.date) = :date")
	Page<Trajectory> findByIdAndDate(@Param("taxiId") Integer taxiId, @Param("date") LocalDate date,
									 Pageable pageable);
}
