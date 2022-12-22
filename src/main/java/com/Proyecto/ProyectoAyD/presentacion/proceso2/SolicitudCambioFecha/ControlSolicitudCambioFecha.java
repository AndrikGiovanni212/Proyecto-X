package com.Proyecto.ProyectoAyD.presentacion.proceso2.SolicitudCambioFecha;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Proyecto.ProyectoAyD.negocio.ServicioAlumno;
import com.Proyecto.ProyectoAyD.negocio.ServicioEvaluador;
import com.Proyecto.ProyectoAyD.negocio.ServicioNotificacion;
import com.Proyecto.ProyectoAyD.negocio.ServicioTema;
import com.Proyecto.ProyectoAyD.negocio.ServicioTesina;
import com.Proyecto.ProyectoAyD.negocio.modelo.Alumno;
import com.Proyecto.ProyectoAyD.negocio.modelo.Evaluador;
import com.Proyecto.ProyectoAyD.negocio.modelo.Tema;

@Component
public class ControlSolicitudCambioFecha 
{
	@Autowired
	VistaSolicitudCambioFecha vistaControlSolicitud;
	@Autowired
	ServicioTema servicioTema;
	@Autowired
	ServicioTesina servicioTesina;
	@Autowired
	ServicioAlumno servicioAlumno;
	@Autowired
	ServicioEvaluador servicioEvaluador;
	@Autowired 
	private ServicioNotificacion servicioNotificacion;
	private String contraseña;
	
	
	public void inicia(String nombreAlumno,String contraseña) {
		Alumno alu = new Alumno();
		this.contraseña = contraseña;
		alu=servicioAlumno.recuperaByNombre(nombreAlumno);
		vistaControlSolicitud.muestra(this, nombreAlumno);
	}
	

	public Evaluador compruebaEvaluador(String nombre) {
		System.out.println(nombre);
		Evaluador eva = new Evaluador();
		eva=servicioEvaluador.recuperaNombre(nombre);
		return eva;
	}

	
	public void enviarSolicitud(String NombreDestinatario, String CorreoElectronico, String Mensaje, String Asunto,String nombreRemitente) {	
		servicioAlumno.solicitudFecha( NombreDestinatario,  CorreoElectronico, Mensaje,  Asunto, nombreRemitente,contraseña);

	}

}
