package com.example.demo.Repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Modelo.Emergencia;

@Repository
public interface EmergenciaRepositorio extends CrudRepository<Emergencia,Integer>{

}
