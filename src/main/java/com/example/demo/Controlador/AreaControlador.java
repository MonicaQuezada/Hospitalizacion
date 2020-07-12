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

import com.example.demo.Modelo.Area;
import com.example.demo.Repositorio.AreaRepositorio;

@RestController
@RequestMapping ("/api/area")
@CrossOrigin(origins="*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AreaControlador {
	
	@Autowired
	AreaRepositorio areaRepo;
	
	@GetMapping
	public Iterable<Area> getAll(){
		return areaRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Area getById(@PathVariable(value="id")Integer id) {
		return areaRepo.findById(id).orElseGet(()->{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Area no encontrada");
		});
	}
	
	@PostMapping
	public Area guardar(@RequestBody Area area) {
		return areaRepo.save(area);
	}
	
	@PutMapping
	public Area update(@RequestBody Area area) {
		return areaRepo.save(area);
	}
	
	@DeleteMapping("/{id}")
	public void borrar(@PathVariable(value="id") Integer id) {
		if(areaRepo.findById(id).isPresent()){
			areaRepo.delete(areaRepo.findById(id).get());
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Area no encontrada");
		}
	}

}
