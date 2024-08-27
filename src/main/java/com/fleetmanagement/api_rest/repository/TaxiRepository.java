package com.fleetmanagement.api_rest.repository;

import com.fleetmanagement.api_rest.model.Taxi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/*
* TaxiRepository es una interfaz que extiende de JpaRepository o CrudRepository, proporcionada por Spring Data JPA. Su función principal es manejar las operaciones de acceso a datos para la entidad Taxi.
*/
public interface TaxiRepository extends JpaRepository<Taxi, Integer> {
	// JpaRepository ya tiene métodos como findAll() para obtener todos los registros.
}
