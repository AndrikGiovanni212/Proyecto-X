package com.Proyecto.ProyectoAyD.datos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.Proyecto.ProyectoAyD.negocio.modelo.Actividad;

import com.Proyecto.ProyectoAyD.negocio.modelo.Alumno;
import com.Proyecto.ProyectoAyD.negocio.modelo.Docente;


public interface DocenteRepository extends CrudRepository <Docente, String> {
	public Docente findByContraseñaDocente(String contraseña);
	
	public List<Docente> findAll();
	public List<Docente> findAllByCorreoEnviado(boolean correo);
	
	//proc4.2
	public Docente findByMatricula(String matricula);

}
