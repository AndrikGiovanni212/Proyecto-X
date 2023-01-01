package com.Proyecto.ProyectoAyD.presentacion.proceso3.SubirHorario;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Proyecto.ProyectoAyD.negocio.ServicioDocente;
import com.Proyecto.ProyectoAyD.negocio.ServicioHorarioDisponibilidad;
import com.Proyecto.ProyectoAyD.presentacion.principal.ControlPrincipal;
import com.Proyecto.ProyectoAyD.presentacion.proceso2.SubirActividades.ControlSubirActividades;
import com.Proyecto.ProyectoAyD.presentacion.proceso3.ModificarEstatus.ControlModificarEstatus;

/**
 * 
 * Módulo de control para la historia de usuario SubirEstatus
 * 
 *
 */

@Component
public class ControlSubirEstatus {
	@Autowired
	private ServicioHorarioDisponibilidad servicioDisponibilidad;
	@Autowired
	private ServicioDocente docenteServicio;
	@Autowired
	private VistaSubirEstatus ventanaSubir;	
	@Autowired
	private ControlModificarEstatus controlModifica;	
	@Autowired
	private ControlPrincipal controlPrincipal;
	@Autowired
	private ControlSubirEstatus controlSubirEstatus;
	@Autowired
	private ControlSubirActividades controlSubirActividades;
	private String nombre;
	private String contraseña;
	
	/**
	 * manda la señal para que muestre la vista de subir estatus o si ya exite alguno de poderlo modificar
	 * primero yendo al servicio a buscar si existe un horario ya disponible
	 * 
	 * @param idDocent, nombre
	 */
	public void inicia(String nombre,String idDocente) {
		this.nombre=nombre;
		contraseña = idDocente;
		if(servicioDisponibilidad.verificaExistenciaHorario(idDocente) == null) {  //verfica si existen algun horario en existencia 
			ventanaSubir.vistaSubirEstatus(this,nombre,idDocente);
		}else {
			controlModifica.modificaEstatus(nombre,idDocente);
		}
	}
	
	public void dameHorario(String nombre,String idDocente) {
		ventanaSubir.muestraHorario(this, nombre,idDocente);	
	}
	
	public boolean subeEstatus(String idDocente,String datos [][],boolean estatus[][], String contraseña) {
		return servicioDisponibilidad.agregaHorario(idDocente,datos,estatus,contraseña);	
	}
	
	public void muestraMensajeExito(String nombre,String idDocente) {		
		ventanaSubir.muestraMensajeExito(this,nombre,idDocente);
	}
	
	public void modifica(String nombre,String idDocente) {
		controlModifica.modifica(nombre,idDocente);
	}
	
	public void ventanaActividades(String nombre, String contraseña) {
		controlSubirActividades.muestraSubirActividades(nombre, contraseña);
	}
	
	public void ventanaHorarioDisponibilidad(String nombre, String contraseña) {
		controlSubirEstatus.inicia(nombre, contraseña);
	}
	
	public void salir() {
		controlPrincipal.inicia();
	}
	
	public void regresaInicio() {
		controlPrincipal.inicioDocente(nombre, contraseña);
	}
	
	
}
