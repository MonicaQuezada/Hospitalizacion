package com.example.demo.Repositorio;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Modelo.Cirugia;

@Repository
public interface CirugiaRepositorio extends CrudRepository<Cirugia,Integer>{
	
	@Query(value = "SELECT * FROM cirugia u WHERE u.id_cirugia = ?1 AND u.cedula_paciente=?1", nativeQuery = true)
	public Cirugia findByIdCirugiaAndCedulaPaciente(Integer idCirugia, String cedula);
	
	@Query(value = "SELECT * FROM cirugia u WHERE u.cedula_paciente=?1", nativeQuery = true)
	public List<Cirugia> findByCedulaPaciente(String cedula);
}
