package com.example.demo.Controlador;


import java.util.List;

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

import com.example.demo.Modelo.Medico;
import com.example.demo.Repositorio.MedicoRepositorio;

@RestController
@RequestMapping ("/api/medico")
@CrossOrigin(origins="*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class MedicoControlador{

	@Autowired
	MedicoRepositorio medicoRepo;
	
	@GetMapping
	public Iterable<Medico> getAll(){
		return medicoRepo.findAll();
	}
	
	/*@GetMapping("/{id}")
	public Medico getById(@PathVariable(value="id") Integer id) {
		return medicoRepo.findById(id).orElseGet(()->{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Medico no encontrado");
		});
	}*/
	
	@GetMapping("/{cedula}")
	public Medico getByCedula(@PathVariable(value="cedula") String cedula) {
		return medicoRepo.findByCedula(cedula).orElseGet(()->{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Medico no encontrado");
		});
	}
	
	@GetMapping("/especialidad/{idEspecialidad}")
	public List<Medico> getByIdEspecialidad(@PathVariable(value="idEspecialidad") Integer idEspecialidad) {
		return medicoRepo.findByIdEspecialidad(idEspecialidad);
	}
	
	@PostMapping
	public Medico guardar(@RequestBody Medico medico) {
		return medicoRepo.save(medico);
	}
	
	@PutMapping
	public Medico update(@RequestBody Medico medico) {
		return medicoRepo.save(medico);
	}
	
	@DeleteMapping("/{cedula}")
	public void borrar(@PathVariable(value="cedula") String cedula) {
		if(medicoRepo.findByCedula(cedula).isPresent()){
			medicoRepo.delete(medicoRepo.findByCedula(cedula).get());
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Medico no encontrado");
		}
	}

}
