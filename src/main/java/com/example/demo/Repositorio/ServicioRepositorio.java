package com.example.demo.Repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Modelo.Servicio;

@Repository
public interface ServicioRepositorio extends CrudRepository<Servicio,Integer>{

}
