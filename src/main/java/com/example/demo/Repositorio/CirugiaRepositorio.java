package com.example.demo.Repositorio;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Modelo.Cirugia;

@Repository
public interface CirugiaRepositorio extends CrudRepository<Cirugia,Integer>{
	public Cirugia findByIdCirugiaAndCedulaPaciente(Integer idCirugia, String cedula);
}
