package com.Proyecto.ProyectoAyD.presentacion.proceso4.CambiarPassword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Proyecto.ProyectoAyD.negocio.ServicioAlumno;
import com.Proyecto.ProyectoAyD.negocio.ServicioDocente;
import com.Proyecto.ProyectoAyD.negocio.modelo.Docente;
import com.Proyecto.ProyectoAyD.presentacion.principal.ControlPrincipal;
@Component
public class ControlCambiarPassword{
	@Autowired
	private VistaCambiarPassword vistaCambiarPassword;
	@Autowired
	private  ServicioDocente servicioDocente;
	@Autowired
	private ServicioAlumno servicioAlumno;
	@Autowired
	private ControlPrincipal controlPrincipal;

	
	public void inicia(String nombre,String contraseña) {
		vistaCambiarPassword.vistaCambiarPassword(this, nombre, contraseña);
	}
	
	public boolean cambiarContraseña(String contra,String nombre, String oldcontraseña) {
		
		try {
			servicioDocente.cambioContraseña(contra, nombre,oldcontraseña);
		} catch(Exception ex) {
			vistaCambiarPassword.muestraDialogoConMensaje("Error: "+ex.getMessage());
			return false;
		}
		return true;
	
	}
	public void regresaInicio(String nombre,String contraseñaNueva) {
		controlPrincipal.inicioDocente(nombre, contraseñaNueva);
		
	}

}