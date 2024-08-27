package com.fleetmanagement.api_rest.repository;

import com.fleetmanagement.api_rest.model.Taxi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/*
 * TaxiRepository es una interfaz que extiende de JpaRepository o CrudRepository, proporcionada por Spring Data JPA.
 * Su función principal es manejar las operaciones de acceso a datos para la entidad Taxi.
 */
public interface TaxiRepository extends JpaRepository<Taxi, Integer> {
	// JpaRepository ya tiene métodos como findAll() para obtener todos los registros.

	/*
	Page<Taxi> findByIdAndPlate(Integer id, String plate, Pageable pageable);
	Page<Taxi> findById(Integer id, Pageable pageable);
	Page<Taxi> findByPlate(String plate, Pageable pageable);
	*/
	@Query("SELECT t FROM Taxi t WHERE (:id IS NULL OR t.id = :id) AND (:plate IS NULL OR t.plate = :plate)")
	Page<Taxi> findByIdOrPlate(@Param("id") Integer id, @Param("plate") String plate, Pageable pageable);

}
