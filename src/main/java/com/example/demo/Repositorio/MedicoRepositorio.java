package com.example.demo.Repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Modelo.Medico;

@Repository
public interface MedicoRepositorio extends CrudRepository<Medico,Integer>{
	
	@Query(value = "SELECT * FROM medico u WHERE u.cedula = ?1", nativeQuery = true)
	public Optional<Medico>findByCedula(String cedula);
	
	@Query(value = "SELECT * FROM medico u WHERE u.id_especialidad = ?1", nativeQuery = true)
	public List<Medico>findByIdEspecialidad(Integer idEspecialidad);
	
}
