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

	
	public void inicia(String nombre,String contraseña) {
		vistaCambiarPassword.muestra(this, nombre, contraseña);
	}
	
	public void cambiarContraseña(String contra,String nombre, String oldcontraseña) {
		
		try {
			servicioDocente.cambioContraseña(contra, nombre,oldcontraseña);
			vistaCambiarPassword.muestraDialogoConMensaje("Contraseña cambiada exitosamente");
		} catch(Exception ex) {
			vistaCambiarPassword.muestraDialogoConMensaje("Error: "+ex.getMessage());
		}
	
	}
	public void regresaInicio() {
		// TODO Auto-generated method stub
		
	}
//	public Docente recuperaDocente(String nombre) {
//		return servicioDocente.recuperDocente(nombre);
//	}
}