package com.example.demo.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.Modelo.Emergencia;
import com.example.demo.Repositorio.EmergenciaRepositorio;

@RestController
@RequestMapping ("/api/emergencia")
@CrossOrigin(origins="*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class EmergenciaControlador {
	
	@Autowired
	EmergenciaRepositorio emergenciaRepo;
	
	@GetMapping
	public Iterable<Emergencia> getAll(){
		return emergenciaRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Emergencia getById(@PathVariable(value="id")Integer id) {
		return emergenciaRepo.findById(id).orElseGet(()->{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Emergencia no encontrada");
		});
	}
	
	@PostMapping
	public Emergencia guardar(@RequestBody Emergencia emergencia) {
		return emergenciaRepo.save(emergencia);
	}
	
	@PutMapping
	public Emergencia update(@RequestBody Emergencia emergencia) {
		return emergenciaRepo.save(emergencia);
	}
	
	@DeleteMapping("/{id}")
	public void borrar(@PathVariable(value="id") Integer id) {
		if(emergenciaRepo.findById(id).isPresent()){
			emergenciaRepo.delete(emergenciaRepo.findById(id).get());
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Emergencia no encontrada");
		}
	}



}
