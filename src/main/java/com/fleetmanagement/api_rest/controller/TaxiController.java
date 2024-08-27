package com.fleetmanagement.api_rest.controller;

import com.fleetmanagement.api_rest.model.Taxi;
import com.fleetmanagement.api_rest.repository.TaxiRepository;
import com.fleetmanagement.api_rest.service.TaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/* TaxiController es una clase en el nivel de presentación (web) que maneja las solicitudes HTTP entrantes
relacionadas con Taxi. Define los endpoints de la API y coordina la interacción entre la capa de servicios y la capa
de repositorio.
 */
@RestController
@RequestMapping("/taxis")
public class TaxiController {
	private final TaxiService taxiService;

	@Autowired
	public TaxiController(TaxiService taxiService) {
		this.taxiService = taxiService;
	}

	/*
	// Endpoint para obtener todos los taxis
	@GetMapping
	public ResponseEntity<List<Taxi>> getAllTaxis() {
		List<Taxi> taxis = taxiService.getAllTaxis();
		return ResponseEntity.ok(taxis);
	}
	*/
	// Endpoint para obtener todos los taxis con paginación
	//http://127.0.0.1:8080/taxis?page=1&limit=10
	@GetMapping
	public ResponseEntity<List<Taxi>> getAllTaxis(
			@RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "limit", defaultValue = "10") int limit) {
		Pageable pageable = PageRequest.of(page, limit);
		Page<Taxi> pageTaxis = taxiService.getAllTaxis(pageable);
		return ResponseEntity.ok(pageTaxis.getContent());
	}

}
/*
Modelo: Define la estructura de la tabla taxis.
Repositorio: Proporciona acceso a la base de datos.
Servicio: Contiene la lógica de negocio para manejar los taxis.
Controlador: Maneja las solicitudes HTTP y responde con la lista de taxis.

 */
/*
 *  inyección de dependencias. En esencia, permite que Spring resuelva y proporcione los objetos necesarios
 * (dependencias) a los componentes de tu aplicación de forma automática.
 * */

/* Previous code that had a limit but no pagination

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

 */

/*
package com.fleetmanagement.api_rest.controller;

import com.fleetmanagement.api_rest.model.Taxi;
import com.fleetmanagement.api_rest.repository.TaxiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/taxis")
public class TaxiController {

    private final TaxiRepository taxiRepository;

    @Autowired
    public TaxiController(TaxiRepository taxiRepository) {
        this.taxiRepository = taxiRepository;
    }

    // Obtener todos los taxis con una limitación opcional
    @GetMapping
    public ResponseEntity<List<Taxi>> getTaxis(@RequestParam(value = "limit", required = false) Integer limit) {
        List<Taxi> taxis = taxiRepository.findAll();
        if (limit != null && limit > 0) {
            taxis = taxis.stream().limit(limit).toList();
        }
        return ResponseEntity.ok(taxis);
    }

    // Obtener todos los taxis con paginación
    @GetMapping("/paged")
    public ResponseEntity<List<Taxi>> getTaxisPaged(@RequestParam(value = "page", defaultValue = "0") int page,
                                                    @RequestParam(value = "size", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<Taxi> taxis = taxiRepository.findAll(pageable).getContent();
        return ResponseEntity.ok(taxis);
    }

    // Obtener un taxi por ID
    @GetMapping("/{id}")
    public ResponseEntity<Taxi> getTaxiById(@PathVariable Integer id) {
        Optional<Taxi> taxi = taxiRepository.findById(id);
        return taxi.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

 */