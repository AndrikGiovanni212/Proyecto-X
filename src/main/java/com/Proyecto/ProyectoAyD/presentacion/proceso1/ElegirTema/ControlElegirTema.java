package com.Proyecto.ProyectoAyD.presentacion.proceso1.ElegirTema;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Proyecto.ProyectoAyD.negocio.ServicioTema;
import com.Proyecto.ProyectoAyD.negocio.ServicioTesina;
import com.Proyecto.ProyectoAyD.negocio.modelo.Alumno;
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
	//Método para iniciar la vista
	public void inicia(Alumno alumno) 
	{//Inicio del método inicia
		//Recuperamos los temas
		List <Tema> temas = servicioTema.recuperaTema();
		vista.muestra(this,temas,alumno);
	}//fin del método inicia
	
	public void agregarTesina(String tema,Alumno alum) {
		
		try {
			servicioTesina.agregarTesina(tema,alum);
			vista.muestraDialogoConMensaje("Tema agregado exitosamente");
		} catch(Exception ex) {
			vista.muestraDialogoConMensaje("Error, ya existe el tema: "+ex.getMessage());
		}
	}
	
}//fin de la clase ControlElegirTema
