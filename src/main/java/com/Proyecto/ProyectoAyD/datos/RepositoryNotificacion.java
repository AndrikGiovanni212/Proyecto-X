package com.Proyecto.ProyectoAyD.datos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Proyecto.ProyectoAyD.negocio.modelo.Actividad;
import com.Proyecto.ProyectoAyD.negocio.modelo.Notificacion;





/**
 * Repositorio para Grupos
 * 
 * @author humbertocervantes
 *
 */
public interface RepositoryNotificacion extends CrudRepository <Notificacion, Long> {
	
	public Notificacion findByCorreo(String correo);
	public List<Notificacion> findByDocenteIdDocente(String contraseña);

}
