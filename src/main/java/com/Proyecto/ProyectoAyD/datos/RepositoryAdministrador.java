package com.Proyecto.ProyectoAyD.datos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Proyecto.ProyectoAyD.negocio.modelo.Actividad;
import com.Proyecto.ProyectoAyD.negocio.modelo.Administrador;





/**
 * Repositorio para Grupos
 * 
 * @author humbertocervantes
 *
 */
public interface RepositoryAdministrador extends CrudRepository <Administrador, Long> {
	
	public Administrador findByContraseñaAdm(String contraseña);
	


}
