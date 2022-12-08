package com.Proyecto.ProyectoAyD.presentacion.proceso2.ModificarFechaEntrega;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Proyecto.ProyectoAyD.negocio.ServicioDocente;
import com.Proyecto.ProyectoAyD.negocio.modelo.Actividad;
import com.Proyecto.ProyectoAyD.presentacion.principal.ControlPrincipal;

@Component
public class ControlModificarFechaEntrega {
	@Autowired
	private VistaModificarFechaEntrega vistModifica;
	@Autowired
	private ServicioDocente servicioDocente;
	@Autowired
	private ControlPrincipal controlPrincipal;
	long id;
	private String nombre;
	private String contraseña;
	
	public void muestra(long id,String nombre, String contraseña) {
		this.id = id;
		this.nombre = nombre;
		this.contraseña = contraseña;
		Actividad actActual = servicioDocente.recuperaFecha(id);
		Date fechaActual=actActual.getFecha();
		String actividad = actActual.getNombreArchivo();
		vistModifica.muestra(this, fechaActual, actividad);
	}
	
	public void cambiaFecha(String fechaNueva) throws Exception {
		servicioDocente.cambiaFecha(id,fechaNueva);
	}
	
	public void regresaInicio() {
		controlPrincipal.inicioDocente(nombre,contraseña);
	}
}
