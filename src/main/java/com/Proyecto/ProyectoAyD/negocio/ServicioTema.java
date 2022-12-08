package com.Proyecto.ProyectoAyD.negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto.ProyectoAyD.datos.RepositoryTema;
import com.Proyecto.ProyectoAyD.negocio.modelo.Tema;


@Service
public class ServicioTema 
{//Inicio de la clase Servicio / Modulo de negocio
	@Autowired
	RepositoryTema repositoryTema;
	//Metodo para recuperar temas del repositorio
	public List <Tema> recuperaTema() 
	{//inicio de metodo List
		List <Tema> temas = new ArrayList<>();
		for(Tema tema:repositoryTema.findAll()) 
		{//inicio de for
			temas.add(tema);
		}//fin de for
		return temas;
	}//fin del metodo list
}//fin de la clase Servicio
