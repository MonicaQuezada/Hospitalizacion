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

import com.example.demo.Modelo.TecnologoMedico;
import com.example.demo.Repositorio.TecnologoMedicoRepositorio;

@RestController
@RequestMapping ("/api/tecnologo")
@CrossOrigin(origins="*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class TecnologoControlador {
	
	@Autowired
	TecnologoMedicoRepositorio tecnologoRepo;
	
	@GetMapping
	public Iterable<TecnologoMedico> getAll(){
		return tecnologoRepo.findAll();
	}
	
	/*@GetMapping("/{id}")
	public Medico getById(@PathVariable(value="id") Integer id) {
		return medicoRepo.findById(id).orElseGet(()->{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Medico no encontrado");
		});
	}*/
	
	@GetMapping("/{cedula}")
	public TecnologoMedico getByCedula(@PathVariable(value="cedula") String cedula) {
		return tecnologoRepo.findByCedula(cedula).orElseGet(()->{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Tecnologo no encontrado");
		});
	}
	
	@PostMapping
	public TecnologoMedico guardar(@RequestBody TecnologoMedico tecnologo) {
		return tecnologoRepo.save(tecnologo);
	}
	
	@PutMapping
	public TecnologoMedico update(@RequestBody TecnologoMedico tecnologo) {
		return tecnologoRepo.save(tecnologo);
	}
	
	@DeleteMapping("/{cedula}")
	public void borrar(@PathVariable(value="cedula") String cedula) {
		if(tecnologoRepo.findByCedula(cedula).isPresent()){
			tecnologoRepo.delete(tecnologoRepo.findByCedula(cedula).get());
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Tecnologo no encontrado");
		}
	}


}
