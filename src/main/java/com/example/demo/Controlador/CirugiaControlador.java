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

import com.example.demo.Modelo.Cirugia;
import com.example.demo.Repositorio.CirugiaRepositorio;

@RestController
@RequestMapping ("/api/cirugia")
@CrossOrigin(origins="*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CirugiaControlador {
	
	@Autowired
	CirugiaRepositorio cirugiaRepo;
	
	@GetMapping
	public Iterable<Cirugia> getAll(){
		return cirugiaRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Cirugia getById(@PathVariable(value="id")Integer id) {
		return cirugiaRepo.findById(id).orElseGet(()->{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Cama no encontrada");
		});
	}
	
	@GetMapping("/{idCirugia}/{cedula}")
	public Cirugia getByIdCirugiaAndCedula(@PathVariable(value="idCirugia") Integer idCirugia, @PathVariable(value="cedula")String cedula) {
		return cirugiaRepo.findByIdCirugiaAndCedulaPaciente(idCirugia, cedula);
	}
	
	@PostMapping
	public Cirugia guardar(@RequestBody Cirugia cirugia) {
		return cirugiaRepo.save(cirugia);
	}
	
	@PutMapping
	public Cirugia update(@RequestBody Cirugia cirugia) {
		return cirugiaRepo.save(cirugia);
	}
	
	@DeleteMapping("/{id}")
	public void borrar(@PathVariable(value="id") Integer id) {
		if(cirugiaRepo.findById(id).isPresent()){
			cirugiaRepo.delete(cirugiaRepo.findById(id).get());
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Cirugia no encontrada");
		}
	}
}
