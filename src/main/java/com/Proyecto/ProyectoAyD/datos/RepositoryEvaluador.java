package com.Proyecto.ProyectoAyD.datos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Proyecto.ProyectoAyD.negocio.modelo.Archivo;
import com.Proyecto.ProyectoAyD.negocio.modelo.Evaluador;

public interface RepositoryEvaluador extends CrudRepository <Evaluador, Long>  {
	public Evaluador findBynombre(String nombre);
	public Evaluador findByIdEvaluador(long id);

	public Evaluador findBycontraseña(String contraseña);
	
	//public List<Archivo> findByContraseñaEvaluador(String Contraseña);

}
