package com.example.demo.Repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Modelo.Cama;

@Repository
public interface CamaRepositorio extends CrudRepository<Cama,Integer>{

}
