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
}
