package com.example.demo.Repositorio;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Modelo.Especialidad;

@Repository
public interface EspecialidadRepositorio extends CrudRepository<Especialidad,Integer>{
	
	public Optional<Especialidad>findByNombre(String nombre);
}
