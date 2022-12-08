package com.Proyecto.ProyectoAyD.datos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Proyecto.ProyectoAyD.negocio.modelo.Archivo;

public interface RepositoryArchivo extends CrudRepository <Archivo, Long> {
	


}
