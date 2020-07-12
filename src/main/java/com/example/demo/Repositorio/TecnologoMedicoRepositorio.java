package com.example.demo.Repositorio;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Modelo.TecnologoMedico;

@Repository
public interface TecnologoMedicoRepositorio extends CrudRepository<TecnologoMedico,Integer>{
	public Set<TecnologoMedico>findAllByCedula(String cedula);
	public Optional<TecnologoMedico>findByCedula(String cedula);
}
