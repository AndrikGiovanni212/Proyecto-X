package com.Proyecto.ProyectoAyD.presentacion.proceso2.SubirTareasAlumno;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Proyecto.ProyectoAyD.negocio.ServicioAlumno;
import com.Proyecto.ProyectoAyD.negocio.ServicioEvaluador;
import com.Proyecto.ProyectoAyD.negocio.ServicioTema;
import com.Proyecto.ProyectoAyD.negocio.ServicioTesina;
import com.Proyecto.ProyectoAyD.negocio.modelo.Alumno;
import com.Proyecto.ProyectoAyD.negocio.modelo.Evaluador;
import com.Proyecto.ProyectoAyD.negocio.modelo.Tema;
import com.Proyecto.ProyectoAyD.presentacion.principal.ControlPrincipal;
import com.Proyecto.ProyectoAyD.presentacion.proceso2.SubirTareasAlumno.VistaSubirTareasAlumno;

@Component
public class ControlSubirTareasAlumno {
	@Autowired
	private VistaSubirTareasAlumno vistaTareas;

	@Autowired
	ServicioTema servicioTema;
	@Autowired
	ServicioTesina servicioTesina;
	@Autowired
	ServicioAlumno servicioAlumno;
	@Autowired
	ServicioEvaluador servicioEvaluador;
	@Autowired
	private ControlPrincipal controlPrincipal;
	
	private String nombre;
	
	public void inicia(String nombre)
	{
		this.nombre = nombre;
		
		vistaTareas.muestra(this,nombre);
	}
	
	public void agregarAvance(String nombre,File archivo,String Evaluador) {
		Evaluador eva= servicioEvaluador.recuperaNombre(Evaluador);
		System.out.println(eva+"Control");
		servicioEvaluador.guardaravance(nombre, archivo, Evaluador);
	}
	
	
}
