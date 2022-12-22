package com.Proyecto.ProyectoAyD.datos;

import org.springframework.data.repository.CrudRepository;
import com.Proyecto.ProyectoAyD.negocio.modelo.Notificacion;





/**
 * Repositorio para Grupos
 * 
 * @author humbertocervantes
 *
 */
public interface RepositoryNotificacion extends CrudRepository <Notificacion, Long> {
	
	public Notificacion findByCorreo(String correo);
	

}
