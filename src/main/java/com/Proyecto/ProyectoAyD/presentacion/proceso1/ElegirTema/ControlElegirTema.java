package com.Proyecto.ProyectoAyD.presentacion.proceso1.ElegirTema;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Proyecto.ProyectoAyD.negocio.ServicioAlumno;
import com.Proyecto.ProyectoAyD.negocio.ServicioEvaluador;
import com.Proyecto.ProyectoAyD.negocio.ServicioTema;
import com.Proyecto.ProyectoAyD.negocio.ServicioTesina;
import com.Proyecto.ProyectoAyD.negocio.modelo.Alumno;
import com.Proyecto.ProyectoAyD.negocio.modelo.Evaluador;
import com.Proyecto.ProyectoAyD.negocio.modelo.Tema;

@Component
public class ControlElegirTema 
{//Inicio de ControlElegirTema, Capa de presentacion
	@Autowired
	VistaElegirTema vista;
	@Autowired
	ServicioTema servicioTema;
	@Autowired
	ServicioTesina servicioTesina;
	@Autowired
	ServicioAlumno servicioAlumno;
	@Autowired
	ServicioEvaluador servicioEvaluador;
	//Método para iniciar la vista
	public void inicia(String nombreAlumno) 
	{//Inicio del método inicia
		//Recuperamos los temas
		List <Tema> temas = servicioTema.recuperaTema();
		System.out.println(recuperaporNombre(nombreAlumno) + " : name");
		
		Alumno alu = new Alumno();
		alu=servicioAlumno.recuperaByNombre(nombreAlumno);
		vista.muestra(this,temas,alu );
	}//fin del método inicia
	
	public void agregarTesina(String tema,Alumno alum) {
		
		try {
			servicioTesina.agregarTesina(tema,alum);
			vista.muestraDialogoConMensaje("Tema agregado exitosamente");
		} catch(Exception ex) {
			vista.muestraDialogoConMensaje("Error, ya existe el tema: "+ex.getMessage());
		}
	}
	public Alumno recuperaporNombre(String nombre) {
		Alumno alum = new Alumno();
		alum=servicioAlumno.recuperaByNombre(nombre);
		System.out.println(alum.getNombre());
		return servicioAlumno.recuperaByNombre(nombre);
		
	}
	public void agregarAvance(String nombre,File archivo,String Evaluador) {
		Evaluador eva= servicioEvaluador.recuperaNombre(Evaluador);
		System.out.println(eva+"Control");
		servicioEvaluador.guardaravance(nombre, archivo, Evaluador);
	}

}