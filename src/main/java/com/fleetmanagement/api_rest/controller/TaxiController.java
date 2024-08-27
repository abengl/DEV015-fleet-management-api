package com.fleetmanagement.api_rest.controller;

import com.fleetmanagement.api_rest.model.Taxi;
import com.fleetmanagement.api_rest.repository.TaxiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/* TaxiController es una clase en el nivel de presentación (web) que maneja las solicitudes HTTP entrantes relacionadas con Taxi. Define los endpoints de la API y coordina la interacción entre la capa de servicios y la capa de repositorio.
 */
@RestController
@RequestMapping("/taxis")
public class TaxiController {
	/*
	*  inyección de dependencias. En esencia, permite que Spring resuelva y proporcione los objetos necesarios (dependencias) a los componentes de tu aplicación de forma automática.
	* */
	@Autowired
	private TaxiRepository taxiRepository;
//
//	@GetMapping("/")
//	public String hello() {
//		return "Hello";
//	}

	@GetMapping
	public ResponseEntity<List<Taxi>>getTaxis(@RequestParam(value = "limit", defaultValue = "10") int limit){
		List<Taxi> taxis = taxiRepository
				.findAll()
				.stream()
				.limit(limit)
				.toList();
		return ResponseEntity.ok(taxis);
	}
}
