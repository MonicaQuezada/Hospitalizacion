package com.example.demo.Repositorio;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Modelo.Interno;

@Repository
public interface InternoRepositorio extends CrudRepository<Interno,Integer>{
	public Set<Interno>findAllByCedula(String cedula);
	public Optional<Interno>findByCedula(String cedula);
}
