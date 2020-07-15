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

import com.example.demo.Modelo.Servicio;
import com.example.demo.Repositorio.ServicioRepositorio;

@RestController
@RequestMapping ("/api/servicio")
@CrossOrigin(origins="*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ServicioControlador {
	@Autowired
	ServicioRepositorio servicioRepo;
	
	@GetMapping
	public Iterable<Servicio> getAll(){
		return servicioRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Servicio getById(@PathVariable(value="id")Integer id) {
		return servicioRepo.findById(id).orElseGet(()->{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Servicio no encontrado");
		});
	}
	
	@PostMapping
	public Servicio guardar(@RequestBody Servicio servicio) {
		return servicioRepo.save(servicio);
	}
	
	@PutMapping
	public Servicio update(@RequestBody Servicio servicio) {
		return servicioRepo.save(servicio);
	}
	
	@DeleteMapping("/{id}")
	public void borrar(@PathVariable(value="id") Integer id) {
		if(servicioRepo.findById(id).isPresent()){
			servicioRepo.delete(servicioRepo.findById(id).get());
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Servicio no encontrado");
		}
	}
	
}
