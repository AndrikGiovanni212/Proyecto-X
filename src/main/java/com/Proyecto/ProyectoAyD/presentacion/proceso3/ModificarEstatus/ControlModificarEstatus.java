package com.Proyecto.ProyectoAyD.presentacion.proceso3.ModificarEstatus;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Proyecto.ProyectoAyD.negocio.ServicioDocente;
import com.Proyecto.ProyectoAyD.negocio.ServicioHorarioDisponibilidad;
import com.Proyecto.ProyectoAyD.negocio.modelo.HorarioDisponibilidad;
import com.Proyecto.ProyectoAyD.presentacion.principal.ControlPrincipal;
import com.Proyecto.ProyectoAyD.presentacion.proceso2.SubirActividades.ControlSubirActividades;
import com.Proyecto.ProyectoAyD.presentacion.proceso3.SubirHorario.ControlSubirEstatus;






/**
 * 
 * Módulo de control para la historia de usuario SubirEstatus
 * 
 *
 */

@Component
public class ControlModificarEstatus {	
	@Autowired
	private ServicioHorarioDisponibilidad servicioDisponibilidad;
	@Autowired
	private ServicioDocente docenteServicio;
	@Autowired
	private VistaModificarEstatus ventanaModifica;
	@Autowired
	private ControlPrincipal controlPrincipal;
	@Autowired
	private ControlSubirActividades controlSubirActividades;
	@Autowired
	private ControlSubirEstatus controlSubirEstatus;
	
	
	/**
	 * busca el horario de disponibilida que existe con el idDocente guardandolo en un ArrayList<HorarioDisponibilida> para
	 * pasarlo coomo parametro a la ventana modifica estatus
	 * @param idDocente
	 */
	public void modificaEstatus(String nombre,String idDocente) {
		ArrayList<HorarioDisponibilidad> HD = servicioDisponibilidad.verificaExistenciaHorario(idDocente); // se obtiene un arraysList de horario disponibilidad 
		ventanaModifica.ventanaModificarEstatus(nombre,idDocente, HD, this);
	}
	
	/**
	 * busca el horario de disponibilida que existe con el idDocente guardandolo en un ArrayList<HorarioDisponibilida> para
	 * pasarlo coomo parametro a la ventana modifica 
	 * @param idDocente
	 */
	public void modifica(String nombre,String idDocente) {
		ArrayList<HorarioDisponibilidad> HD = servicioDisponibilidad.verificaExistenciaHorario(idDocente);
		ventanaModifica.modifica(nombre,idDocente, HD, this);
	}
	/**
	 * actualiza el horario que pasandole como parametro al servicioDisponibilidad el nuevo estatus del docente y su id 
	 * @param estatus[][], idDocente
	 * return true si se actualiza correctamente y false si no se actualizo correctamente
	 */
	public boolean actualizaHorario(boolean estatus[][], String idDocente) {
		return servicioDisponibilidad.actualiza(estatus,idDocente);
	}
	/**
	 * muestra un mensaje en la pantalla una vez teniendo exito la tarea a pedir
	 * @param nombre, idDocente
	 */
	public void mensajeExito(String nombre,String idDocente) {
		ventanaModifica.muestraMensajeExito(nombre,idDocente, this);
	}
	/**
	 * envia los datos al contro subirActvidades para mostrar la ventana de subir Actividad
	 * @param nombre, idDocente
	 */
	public void ventanaActividades(String nombre, String idDocente) {
		controlSubirActividades.muestraSubirActividades(nombre, idDocente);
	}
	/**
	 * envia los datos al contro subirActvidades para mostrar la ventana de subir Actividad
	 * @param nombre, idDocente
	 */
	public void ventanaHorarioDisponibilidad(String nombre, String contraseña) {
		controlSubirEstatus.inicia(nombre, contraseña);
	}
	/**
	 * regresa al control principal para mostrarnos la vista principal del login 
	 */
	public void salir() {
		controlPrincipal.inicia();
	}
	
}
