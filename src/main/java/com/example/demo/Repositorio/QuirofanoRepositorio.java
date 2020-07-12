package com.example.demo.Repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Modelo.Quirofano;

@Repository
public interface QuirofanoRepositorio extends CrudRepository<Quirofano,Integer>{

}
