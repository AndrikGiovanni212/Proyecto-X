package com.Proyecto.ProyectoAyD.presentacion.proceso4.EnviarCorreos;

import java.io.File;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.Proyecto.ProyectoAyD.ProyectoAyDApplication;
import com.Proyecto.ProyectoAyD.negocio.ServicioAlumno;
import com.Proyecto.ProyectoAyD.negocio.ServicioDocente;
import com.Proyecto.ProyectoAyD.negocio.modelo.Alumno;
import com.Proyecto.ProyectoAyD.negocio.modelo.Docente;
import com.Proyecto.ProyectoAyD.presentacion.principal.ControlPrincipal;
import com.Proyecto.ProyectoAyD.presentacion.proceso3.SubirHorario.ControlSubirEstatus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;


@Component
public class ControlEnviarCorreos {
	
	
	@Autowired
	private VistaEnviarCorreos vistaEnviarCorreos;
	@Autowired
	private JavaMailSender emailSende;
	@Autowired
	private ServicioDocente servicioDocente;
	@Autowired
	private ServicioAlumno servicioAlumno;
	@Autowired
	private ControlSubirEstatus controlSubirEstatus;
	@Autowired
	private ControlPrincipal controlPrincipal;
	private String contraseñaAdm;
	private String nombre;
	
	
	public void muestra(String nombre,String contraseña) {
		contraseñaAdm = contraseña;
		vistaEnviarCorreos.vistaEnviarCorreos(this, nombre);
		vistaEnviarCorreos.llenaTabla(servicioAlumno.recuperaListaAlumno(), servicioDocente.recuperaListaDocent());
	}
	
	public void regresaInicio() {
		controlPrincipal.inicioAdministrador(nombre, contraseñaAdm);
	}
	
	public void mensajeEnviado(List<Alumno> listAlumno,List<Docente> listDocente) {
		servicioAlumno.mensajeEnviado(listAlumno);
		servicioDocente.mensajeEnviado(listDocente);
	}
	
}
