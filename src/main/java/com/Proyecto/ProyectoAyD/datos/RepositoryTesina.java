package com.Proyecto.ProyectoAyD.datos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Proyecto.ProyectoAyD.negocio.modelo.Tesina;



public interface RepositoryTesina  extends CrudRepository <Tesina, Long>  
{
	
}
