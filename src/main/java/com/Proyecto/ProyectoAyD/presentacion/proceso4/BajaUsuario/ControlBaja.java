package com.Proyecto.ProyectoAyD.presentacion.proceso4.BajaUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Proyecto.ProyectoAyD.negocio.ServicioAdministrador;
import com.Proyecto.ProyectoAyD.negocio.modelo.Alumno;
import com.Proyecto.ProyectoAyD.negocio.modelo.Docente;
import com.Proyecto.ProyectoAyD.presentacion.principal.ControlPrincipal;
import com.Proyecto.ProyectoAyD.presentacion.principal.VentanaPrincipal;

@Component
public class ControlBaja {
	@Autowired
	private VistaBaja vistaBaja;
	@Autowired
	private ServicioAdministrador servicioAdm;
	@Autowired
	private ControlPrincipal controlPrincipal;
	
	private String contraseñaAdm;
	
	
	
	public void inicia(String nombreAdmin,String contraseña) {
		this.contraseñaAdm = contraseña;
		vistaBaja.muestra(this, nombreAdmin);
	}
	
	/**
	 * Se contacta con el servicio para Dar de Alta a un usuario de tipo Alumno
	 * @param correo,usuario,edad,nombre,contraseña,matricula,telefono
	 */
	public boolean darAltaAlumno(String correo,String usuario,int edad,String nombre,String contraseña,String matricula, int telefono){
		return servicioAdm.darAltaAlumno(correo,usuario,edad,nombre,contraseña,matricula,telefono);
	}
	/**
	 * Se contacta con el servicio para  Dar de Alta a un usuario de tipo Docente
	 * @param correo,usuario,edad,nombre,contraseña,matricula,telefono,tipo,tipoRevisor
	 */
	public boolean darAltaDocente(String correo,String usuario,int edad,String nombre,String contraseña,String matricula, int telefono, String tipo,String tipoRevisor){
		return servicioAdm.darAltaDocente(correo,usuario,edad,nombre,contraseña,matricula,telefono,tipo,tipoRevisor);	
	}
	/**
	 * Se contacta con el servicio para saber si existe el Alumno buscado
	 * @param correo,usuario,edad,nombre,contraseña,matricula,telefono
	 */
	public boolean verificarAltaAlumno(String correo,String usuario,int edad,String nombre,String contraseña,String matricula, int telefono){
		return servicioAdm.verificaAlumno(contraseña,nombre);
	}
	/**
	 * Se contacta con el servicio para saber si existe el Docente buscado
	 * @param correo,usuario,edad,nombre,contraseña,matricula,telefono,tipo,tipoRevisor
	 */
	public boolean verificarAltaDocente(String correo,String usuario,int edad,String nombre,String contraseña,String matricula, int telefono, String tipo) {
		return servicioAdm.verificaDocente(contraseña,nombre);	
	}
	/**
	 * Se contacta con el servicio para saber si existe el Alumno buscado
	 * @param matricula
	 */
	public Alumno verificaAlumnoBaja(String matricula){
		return servicioAdm.verificaAlumnoParaBaja(matricula);
	}
	
	/**
	 * Se contacta con el servicio para saber si existe el Alumno buscado
	 * @param matricula
	 */
	public Docente verificaDocenteBaja(String matricula){
		return servicioAdm.verificaDocenteParaBaja(matricula);
	}
	
	/**
	 * Se contacta con el servicio para saber si existe el Usuario buscado
	 * @param matricula
	 */
	public boolean verificaExistenciaBaja(String matricula){
		return servicioAdm.verificaExistencia(matricula);
	}
	

	
	public void regresaInicio(String nombre) {
		controlPrincipal.inicioAdministrador(nombre, contraseñaAdm);
	}
	
	/**
	 * Se contacta con el servicio para dar de baja a un usuario con el dato de la matricula
	 * @param matricula
	 */
	public boolean darBaja(String matricula){
		return servicioAdm.bajaPorMatricula(matricula);
	}

}
