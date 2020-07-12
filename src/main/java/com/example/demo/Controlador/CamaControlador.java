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

import com.example.demo.Modelo.Cama;
import com.example.demo.Repositorio.CamaRepositorio;


@RestController
@RequestMapping ("/api/cama")
@CrossOrigin(origins="*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CamaControlador {
	@Autowired
	CamaRepositorio camaRepo;
	
	@GetMapping
	public Iterable<Cama> getAll(){
		return camaRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Cama getById(@PathVariable(value="id")Integer id) {
		return camaRepo.findById(id).orElseGet(()->{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Cama no encontrada");
		});
	}
	
	@PostMapping
	public Cama guardar(@RequestBody Cama cama) {
		return camaRepo.save(cama);
	}
	
	@PutMapping
	public Cama update(@RequestBody Cama cama) {
		return camaRepo.save(cama);
	}
	
	@DeleteMapping("/{id}")
	public void borrar(@PathVariable(value="id") Integer id) {
		if(camaRepo.findById(id).isPresent()){
			camaRepo.delete(camaRepo.findById(id).get());
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Cama no encontrada");
		}
	}


}
