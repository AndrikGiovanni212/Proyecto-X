package com.Proyecto.ProyectoAyD.presentacion.proceso1.ElecciónDocente;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Proyecto.ProyectoAyD.negocio.ServicioAlumno;
import com.Proyecto.ProyectoAyD.negocio.ServicioEvaluador;
import com.Proyecto.ProyectoAyD.negocio.modelo.Alumno;
import com.Proyecto.ProyectoAyD.negocio.modelo.Evaluador;

@Component
public class ControlEleccionDocente {
	@Autowired
	VistaEleccionDocente vista;
	@Autowired
	ServicioEvaluador servicioEvaluador;
	@Autowired
	ServicioAlumno servicioAlumno;
	public void inicia(String nombre, String contraseña){
		//Alumno alumnoLocal = new Alumno();
//		alumnoLocal = servicioAlumno.datosAlumno();
		List <Evaluador> evaluador= servicioEvaluador.recuperarTodo();
		vista.muestra(this,evaluador);	
		vista.llenaTabla(evaluador);
	}
	
	public void guardaEvaluador(long idDirector, long idRevisor) {
		servicioAlumno.guardaEvaluador(servicioEvaluador.recuperEvaluador(idDirector,idRevisor));
	}
	
	
}