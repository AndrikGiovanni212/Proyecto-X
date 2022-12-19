package com.Proyecto.ProyectoAyD.presentacion.proceso1.SeleccionHorario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Proyecto.ProyectoAyD.negocio.ServicioAlumno;
import com.Proyecto.ProyectoAyD.negocio.ServicioDocente;
import com.Proyecto.ProyectoAyD.negocio.ServicioHorario;
import com.Proyecto.ProyectoAyD.presentacion.principal.ControlPrincipal;
import com.Proyecto.ProyectoAyD.presentacion.proceso3.VisualizarEstatus.VistaVisualizarEstatus;

/**
 * Esta clase lleva el flujo de control de la ventana vistaSeleccionHorario
 * Módulo de control para la historia de usuario SeleccionHorario
 * @author ArmandoArzola
 * 
 */
@Component
public class ControSeleccionHorario {
	@Autowired
	private VistaSeleccionHorario vistaSeleccionHorario;
	@Autowired
	private ServicioAlumno alumnoServicio;
	@Autowired
	private ServicioHorario servicioDisponibilidad;
	@Autowired
	private ControlPrincipal controlPrincipal;
	private String nombreAlumno;
	public void inicia(String nombreAlumno) {
		this.nombreAlumno= nombreAlumno;
		vistaSeleccionHorario.muestra(this, nombreAlumno);
	}
	
	public boolean agendarHorario(String dia, String mes , String hora, String año, String modo , String alumno){
		System.out.println(dia+mes+hora+año+modo+ "Control");
		return servicioDisponibilidad.darAltaHorario(dia, mes, hora, año, modo, alumno);
	}

}
