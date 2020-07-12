package com.example.demo.Repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Modelo.Hospitalizacion;

@Repository
public interface HospitalizacionRepositorio extends CrudRepository<Hospitalizacion,Integer>{

}
