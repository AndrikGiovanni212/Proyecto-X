package com.Proyecto.ProyectoAyD.datos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.Proyecto.ProyectoAyD.negocio.modelo.Actividad;

import com.Proyecto.ProyectoAyD.negocio.modelo.Alumno;
import com.Proyecto.ProyectoAyD.negocio.modelo.Docente;
import com.Proyecto.ProyectoAyD.negocio.modelo.Notificacion;


public interface DocenteRepository extends CrudRepository <Docente, String> {
	public Docente findByContraseñaDocente(String contraseña);
	
	public List<Docente> findAll();
	public List<Docente> findAllBycorreoEnviado(boolean correo);
	
	//proc4.2
	public Docente findBymatricula(String matricula);
	public List<Notificacion> findByIdDocente(String contraseña);

}
