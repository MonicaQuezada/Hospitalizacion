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

import com.example.demo.Modelo.Hospitalizacion;
import com.example.demo.Repositorio.HospitalizacionRepositorio;

@RestController
@RequestMapping ("/api/hospitalizacion")
@CrossOrigin(origins="*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class HospitalizacionControlador {

	@Autowired
	HospitalizacionRepositorio hospitalizacionRepo;
	
	@GetMapping
	public Iterable<Hospitalizacion> getAll(){
		return hospitalizacionRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Hospitalizacion getById(@PathVariable(value="id")Integer id) {
		return hospitalizacionRepo.findById(id).orElseGet(()->{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Hospitalizacion no encontrada");
		});
	}
	
	@PostMapping
	public Hospitalizacion guardar(@RequestBody Hospitalizacion hospitalizacion) {
		return hospitalizacionRepo.save(hospitalizacion);
	}
	
	@PutMapping
	public Hospitalizacion update(@RequestBody Hospitalizacion hospitalizacion) {
		return hospitalizacionRepo.save(hospitalizacion);
	}
	
	@DeleteMapping("/{id}")
	public void borrar(@PathVariable(value="id") Integer id) {
		if(hospitalizacionRepo.findById(id).isPresent()){
			hospitalizacionRepo.delete(hospitalizacionRepo.findById(id).get());
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Hospitalizacion no encontrada");
		}
	}



}
