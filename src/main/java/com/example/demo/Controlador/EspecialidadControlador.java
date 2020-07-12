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

import com.example.demo.Modelo.Especialidad;
import com.example.demo.Repositorio.EspecialidadRepositorio;

@RestController
@RequestMapping ("/api/especialidad")
@CrossOrigin(origins="*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class EspecialidadControlador {
	@Autowired
	EspecialidadRepositorio especialidadRepo;
	
	@GetMapping
	public Iterable<Especialidad> getAll(){
		return especialidadRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Especialidad getById(@PathVariable(value="id")Integer id) {
		return especialidadRepo.findById(id).orElseGet(()->{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Especialidad no encontrada");
		});
	}
	
	@GetMapping("nombre/{nombre}")
	public Especialidad getByNombre(@PathVariable(value="nombre")String nombre) {
		return especialidadRepo.findByNombre(nombre).orElseGet(()->{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Especialidad no encontrada");
		});
	}
	
	@PostMapping
	public Especialidad guardar(@RequestBody Especialidad especialidad) {
		return especialidadRepo.save(especialidad);
	}
	
	@PutMapping
	public Especialidad update(@RequestBody Especialidad especialidad) {
		return especialidadRepo.save(especialidad);
	}
	
	@DeleteMapping("/{id}")
	public void borrar(@PathVariable(value="id") Integer id) {
		if(especialidadRepo.findById(id).isPresent()){
			especialidadRepo.delete(especialidadRepo.findById(id).get());
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Especialidad no encontrada");
		}
	}
	
}
