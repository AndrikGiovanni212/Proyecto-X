package com.Proyecto.ProyectoAyD.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto.ProyectoAyD.datos.RepositoryAlumno;
import com.Proyecto.ProyectoAyD.datos.RepositoryTema;
import com.Proyecto.ProyectoAyD.datos.RepositoryTesina;
import com.Proyecto.ProyectoAyD.negocio.modelo.Alumno;
import com.Proyecto.ProyectoAyD.negocio.modelo.Tema;
import com.Proyecto.ProyectoAyD.negocio.modelo.Tesina;
import com.Proyecto.ProyectoAyD.presentacion.proceso1.ElegirTema.ControlElegirTema;




@Service
public class ServicioTesina 
{//Inicio de clase ServicioTesina
	@Autowired
	RepositoryTesina repositoryTesina;
	@Autowired
	RepositoryAlumno repositoryAlumno;
	@Autowired
	RepositoryTema repositoryTema;
	public Tesina agregarTesina(String tema,Alumno autor) 
	{//inicio Tesina		
		Tema tema1 = repositoryTema.findBynombre(tema);
		Alumno al=autor;
		Tesina tesina;
		tesina = new Tesina();
		tesina.setAutor(al.getNombre());
		tesina.setTema(tema1);		
		repositoryTesina.save(tesina);	
		return tesina;
	}//Fin de tesina
}//fin de clase ServicioTesina
