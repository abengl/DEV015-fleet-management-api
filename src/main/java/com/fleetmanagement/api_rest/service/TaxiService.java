package com.fleetmanagement.api_rest.service;

import com.fleetmanagement.api_rest.model.Taxi;
import com.fleetmanagement.api_rest.repository.TaxiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxiService {

	private final TaxiRepository taxiRepository;

	@Autowired
	public TaxiService(TaxiRepository taxiRepository) {
		this.taxiRepository = taxiRepository;
	}

	// Método para recuperar todos los taxis sin paginación
	public List<Taxi> getAllTaxis() {
		return taxiRepository.findAll();
	}

	// Método para recuperar todos los taxis con paginación
	public Page<Taxi> getAllTaxis(Pageable pageable) {
		return taxiRepository.findAll(pageable);
	}

	// Método para recuperar taxis con filtrado y paginación
	public Page<Taxi> getTaxisByFilters(Integer id, String plate, Pageable pageable) {
		return taxiRepository.findByIdOrPlate(id, plate, pageable);
		/*
		if (id != null && plate != null) {
			return taxiRepository.findByIdAndPlate(id, plate, pageable);
		} else if (id != null) {
			return taxiRepository.findById(id, pageable);
		} else if (plate != null) {
			return taxiRepository.findByPlate(plate, pageable);
		} else {
			return taxiRepository.findAll(pageable);
		}
		 */
	}
}
