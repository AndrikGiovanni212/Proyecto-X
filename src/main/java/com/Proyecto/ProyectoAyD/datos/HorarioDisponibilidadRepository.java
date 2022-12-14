package com.Proyecto.ProyectoAyD.datos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.Proyecto.ProyectoAyD.negocio.modelo.HorarioDisponibilidad;





/**
 * 
 * Repositorio para horarioDisponibilidad
 * 
 *
 */

public interface HorarioDisponibilidadRepository extends CrudRepository <HorarioDisponibilidad, String> {
	
	public Optional<HorarioDisponibilidad> findByDocenteIdDocente(String docente);
	
	public Optional<HorarioDisponibilidad> findByContrase├▒aDocente(String contrase├▒a);
	

	public List<HorarioDisponibilidad> findAllByDocenteContrase├▒aDocente(String docente);

	
}

