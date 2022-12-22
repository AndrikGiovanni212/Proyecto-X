package com.Proyecto.ProyectoAyD.datos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Proyecto.ProyectoAyD.negocio.modelo.Actividad;





/**
 * Repositorio para Grupos
 * 
 * @author humbertocervantes
 *
 */
public interface ActividadesRepository extends CrudRepository <Actividad, Long> {
	
	public List<Actividad> findByDocenteContraseñaDocente(String contraseña);
	
	public Actividad findByNumeroActividad(long id);
	
	

}
