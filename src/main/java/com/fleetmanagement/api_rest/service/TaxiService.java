package com.fleetmanagement.api_rest.service;

import com.fleetmanagement.api_rest.model.Taxi;
import com.fleetmanagement.api_rest.repository.TaxiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxiService {

	private final TaxiRepository taxiRepository;

	@Autowired
	public TaxiService(TaxiRepository taxiRepository) {
		this.taxiRepository = taxiRepository;
	}

	// Método para recuperar todos los taxis
	public List<Taxi> getAllTaxis() {
		return taxiRepository.findAll();
	}
}
