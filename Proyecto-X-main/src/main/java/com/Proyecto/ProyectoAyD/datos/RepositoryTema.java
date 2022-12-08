package com.Proyecto.ProyectoAyD.datos;

import org.springframework.data.repository.CrudRepository;

import com.Proyecto.ProyectoAyD.negocio.modelo.Tema;





public interface RepositoryTema extends CrudRepository <Tema, Long> {
	public Tema findBynombre(String nombre);
}
