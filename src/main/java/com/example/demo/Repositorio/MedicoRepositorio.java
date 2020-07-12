package com.example.demo.Repositorio;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Modelo.Medico;

@Repository
public interface MedicoRepositorio extends CrudRepository<Medico,Integer>{

	public Set<Medico>findAllByCedula(String cedula);
	public Optional<Medico>findByCedula(String cedula);
	public Medico findByIdEspecialidad(Integer idEspecialidad);
	
}
