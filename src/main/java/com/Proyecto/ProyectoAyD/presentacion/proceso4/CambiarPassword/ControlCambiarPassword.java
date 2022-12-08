package com.Proyecto.ProyectoAyD.presentacion.proceso4.CambiarPassword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Proyecto.ProyectoAyD.negocio.ServicioAlumno;
import com.Proyecto.ProyectoAyD.negocio.ServicioDocente;
import com.Proyecto.ProyectoAyD.negocio.modelo.Docente;
import com.Proyecto.ProyectoAyD.presentacion.principal.ControlPrincipal;

public class ControlCambiarPassword{
	@Autowired
	private VistaCambiarPassword vistaCambiarPassword;
	@Autowired
	private static ServicioDocente servicioDocente;
	@Autowired
	private ServicioAlumno servicioAlumno;
	@Autowired
	private ControlPrincipal controlPrincipal;
	
	long id;
	private String nombre;
	private String contraseña;
	
	public void muestra(long id,String nombre, String contraseña) {
		Docente password = servicioDocente.recuperaContraseña(contraseña);
		this.id = id;
		this.nombre = nombre;
		this.contraseña = contraseña;
		
	}
	public static void cambiaPassword(String contraseña) {
		// TODO Auto-generated method stub
		servicioDocente.cambiaPassword(contraseña);
	}
	public void regresaInicio() {
		// TODO Auto-generated method stub
		
	}
	
}