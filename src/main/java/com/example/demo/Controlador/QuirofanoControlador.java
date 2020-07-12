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

import com.example.demo.Modelo.Quirofano;
import com.example.demo.Repositorio.QuirofanoRepositorio;



@RestController
@RequestMapping ("/api/quirofano")
@CrossOrigin(origins="*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class QuirofanoControlador {

	@Autowired
	QuirofanoRepositorio quirofanoRepo;
	
	@GetMapping
	public Iterable<Quirofano> getAll(){
		return quirofanoRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Quirofano getById(@PathVariable(value="id")Integer id) {
		return quirofanoRepo.findById(id).orElseGet(()->{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Quirofano no encontrado");
		});
	}
	
	@PostMapping
	public Quirofano guardar(@RequestBody Quirofano quirofano) {
		return quirofanoRepo.save(quirofano);
	}
	
	@PutMapping
	public Quirofano update(@RequestBody Quirofano quirofano) {
		return quirofanoRepo.save(quirofano);
	}
	
	@DeleteMapping("/{id}")
	public void borrar(@PathVariable(value="id") Integer id) {
		if(quirofanoRepo.findById(id).isPresent()){
			quirofanoRepo.delete(quirofanoRepo.findById(id).get());
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Quirofano no encontrado");
		}
	}
	
}
