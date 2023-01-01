package com.Proyecto.ProyectoAyD.presentacion.proceso3.VisualizarEstatus;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Proyecto.ProyectoAyD.negocio.ServicioDocente;
import com.Proyecto.ProyectoAyD.negocio.ServicioHorarioDisponibilidad;
import com.Proyecto.ProyectoAyD.negocio.modelo.HorarioDisponibilidad;
import com.Proyecto.ProyectoAyD.presentacion.principal.ControlPrincipal;






/**
 * 
 * Módulo de control para la historia de usuario SubirEstatus
 * 
 *
 */
@Component
public class ControlVisualizarEstatus {
	@Autowired
	private VistaVisualizarEstatus vistaVisualizarEstatus;
	@Autowired
	private ServicioDocente docenteServicio;
	@Autowired
	private ServicioHorarioDisponibilidad servicioDisponibilidad;
	@Autowired
	private ControlPrincipal controlPrincipal;
	
	private String nombre;
	
	
	public void inicia(String nombre) {
		this.nombre=nombre;
		vistaVisualizarEstatus.vistaVisualizarEstatus(this, nombre);
	}
	//aqui nos quedamos
	public ArrayList<HorarioDisponibilidad> buscaHorario( String contraseña) {
		ArrayList<HorarioDisponibilidad> HD = servicioDisponibilidad.buscaHorario(contraseña);
		if(HD != null) {
			return HD;
		}else {
			return null;
		}	
	}
	
	public void muestraHorario(ArrayList<HorarioDisponibilidad> HD) {
		vistaVisualizarEstatus.muestraHorario(HD,this,nombre);
	}
	
	public void salir() {
		controlPrincipal.inicia();
	}
	
}
