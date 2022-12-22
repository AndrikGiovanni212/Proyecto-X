package com.Proyecto.ProyectoAyD.datos;

import org.springframework.data.repository.CrudRepository;

import com.Proyecto.ProyectoAyD.negocio.modelo.Evaluador;

public interface RepositoryEvaluador extends CrudRepository <Evaluador, Long>  {
	public Evaluador findBynombre(String nombre);
	public Evaluador findByIdEvaluador(long id);
	public Evaluador findByContraseñaEvaluador(String id);	
}
