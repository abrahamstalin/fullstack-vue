package com.ajal.technology.cursos.adminincidencias.incidencia;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("incidencias")
@CrossOrigin
public class IncidenciaController {
	
	@Autowired IncidenciaRepository incidenciaRepository;
	
	@GetMapping
	public ResponseEntity<List<Incidencia>> all(){
		List<Incidencia> incidencias = incidenciaRepository.findAll();
		if (incidencias.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Incidencia>>(incidencias, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Incidencia> save(@Valid @RequestBody Incidencia incidencia){
		incidencia.setEstatusIncidencia(EstatusIncidencia.SIN_ASIGNAR);
		Incidencia persist = incidenciaRepository.save(incidencia);
		return new ResponseEntity<Incidencia>(persist, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/{estatusIncidencia}")
	public ResponseEntity<List<Incidencia>> get(@PathVariable EstatusIncidencia estatusIncidencia){
		List<Incidencia> incidencias = incidenciaRepository.findByEstatusIncidencia(estatusIncidencia);
		if (incidencias.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Incidencia>>(incidencias, HttpStatus.OK);
	}
	
	@PutMapping("{id}/{estatusIncidencia}")
	public ResponseEntity<Incidencia> update(@PathVariable  Integer id, @PathVariable EstatusIncidencia estatusIncidencia){
		Optional<Incidencia> optional = incidenciaRepository.findById(id);
		if (optional.isPresent()) {
			Incidencia incidencia = optional.get();
			incidencia.setEstatusIncidencia(estatusIncidencia);
			incidencia = incidenciaRepository.save(incidencia);
			return new ResponseEntity<Incidencia>(incidencia, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
