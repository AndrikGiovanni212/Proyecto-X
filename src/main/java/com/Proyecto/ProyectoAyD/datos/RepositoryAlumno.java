package com.Proyecto.ProyectoAyD.datos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Proyecto.ProyectoAyD.negocio.modelo.Alumno;
import com.Proyecto.ProyectoAyD.negocio.modelo.Docente;
import com.Proyecto.ProyectoAyD.negocio.modelo.Evaluador;

public interface RepositoryAlumno extends CrudRepository <Alumno, Long> {	
	public Alumno findByIdAlumno(String contraseña);
	
	public List<Alumno> findAll();
	
	
	//proceso1 Mensaje
	public Alumno findByCorreo(String correo);
	public Alumno findByNombre(String nombre);
	public Alumno findByEvaluadorIdEvaluador(int id);
	//proc4.2
	public Alumno findByMatricula(String matricula);

	

}
