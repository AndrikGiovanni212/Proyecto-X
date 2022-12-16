package com.Proyecto.ProyectoAyD.datos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.Proyecto.ProyectoAyD.negocio.modelo.Horario;

/**
 * 
 * Repositorio para horario
 * 
 *
 */


public interface RepositoryHorario extends CrudRepository <Horario, String>{
	
//	public List<Horario> findByaño(String alumno);
//	
//	public List<Horario> findByContraseñaAlumno(String contraseña);
//	
//	public List<Horario> findAllByAlumnoIdAlumno(String alumno);
	
}
