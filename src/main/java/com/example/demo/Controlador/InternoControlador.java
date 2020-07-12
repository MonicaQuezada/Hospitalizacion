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

import com.example.demo.Modelo.Interno;
import com.example.demo.Repositorio.InternoRepositorio;

@RestController
@RequestMapping ("/api/interno")
@CrossOrigin(origins="*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class InternoControlador {
	
	@Autowired
	InternoRepositorio internoRepo;
	
	@GetMapping
	public Iterable<Interno> getAll(){
		return internoRepo.findAll();
	}
	
	/*@GetMapping("/{id}")
	public Medico getById(@PathVariable(value="id") Integer id) {
		return medicoRepo.findById(id).orElseGet(()->{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Medico no encontrado");
		});
	}*/
	
	@GetMapping("/{cedula}")
	public Interno getByCedula(@PathVariable(value="cedula") String cedula) {
		return internoRepo.findByCedula(cedula).orElseGet(()->{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Interno no encontrado");
		});
	}
	
	@PostMapping
	public Interno guardar(@RequestBody Interno interno) {
		return internoRepo.save(interno);
	}
	
	@PutMapping
	public Interno update(@RequestBody Interno interno) {
		return internoRepo.save(interno);
	}
	
	@DeleteMapping("/{cedula}")
	public void borrar(@PathVariable(value="cedula") String cedula) {
		if(internoRepo.findByCedula(cedula).isPresent()){
			internoRepo.delete(internoRepo.findByCedula(cedula).get());
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Interno no encontrado");
		}
	}


}
