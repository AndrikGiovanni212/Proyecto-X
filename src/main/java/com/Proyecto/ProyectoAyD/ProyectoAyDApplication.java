package com.Proyecto.ProyectoAyD;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.Proyecto.ProyectoAyD.datos.ActividadesRepository;
import com.Proyecto.ProyectoAyD.datos.DocenteRepository;
import com.Proyecto.ProyectoAyD.datos.RepositoryAdministrador;
import com.Proyecto.ProyectoAyD.datos.RepositoryAlumno;
import com.Proyecto.ProyectoAyD.datos.RepositoryEvaluador;
import com.Proyecto.ProyectoAyD.datos.RepositoryNotificacion;
import com.Proyecto.ProyectoAyD.datos.RepositoryRol;
import com.Proyecto.ProyectoAyD.datos.RepositoryTema;
import com.Proyecto.ProyectoAyD.negocio.modelo.Actividad;
import com.Proyecto.ProyectoAyD.negocio.modelo.Administrador;
import com.Proyecto.ProyectoAyD.negocio.modelo.Alumno;
import com.Proyecto.ProyectoAyD.negocio.modelo.Docente;
import com.Proyecto.ProyectoAyD.negocio.modelo.Evaluador;
import com.Proyecto.ProyectoAyD.negocio.modelo.Notificacion;
import com.Proyecto.ProyectoAyD.negocio.modelo.Rol;
import com.Proyecto.ProyectoAyD.negocio.modelo.Tema;
import com.Proyecto.ProyectoAyD.presentacion.principal.ControlPrincipal;







@SpringBootApplication
public class ProyectoAyDApplication {
	@Autowired
	private ControlPrincipal controlPrincipal;
	@Autowired
	private DocenteRepository repositorioDocente;
	@Autowired
	private RepositoryNotificacion repositorioNotificacion;
	@Autowired
	private RepositoryAdministrador repositorioAdm;
	@Autowired
	private ActividadesRepository repositoryActividad;
	@Autowired
	private RepositoryAlumno repositorioAlumno;
	@Autowired
	private RepositoryEvaluador repositoryEvalaudor;

	public static void main(String[] args) {
		System.out.println("Primer Commit AAP");
		System.out.println("Prueba 1");
		System.out.println("Rama AAP_HU1-7_ElegirFecha");

		
		
		SpringApplicationBuilder builder = new SpringApplicationBuilder(ProyectoAyDApplication.class);

		builder.headless(false);

		builder.run(args);
	}
	@PostConstruct
	public void inicia() {
		inicializaBD();
		controlPrincipal.inicia();
	}
	public void inicializaBD() {
		Docente docente1 = new Docente();
		docente1.setIdDocente("12345");
		docente1.setNombre("nabeel");
		docente1.setCorreo("bob1nabeel@gmail.com");
		repositorioDocente.save(docente1);
	
		Docente docente = new Docente();
		docente.setIdDocente("78965");
		docente.setNombre("armando");
		docente.setCorreo("armaarzolape@gmail.com");
		repositorioDocente.save(docente);
		
		docente = new Docente();
		docente.setIdDocente("36541");
		docente.setNombre("manuel");
		docente.setCorreo("manuelmartinezv13@gmail.com");
		repositorioDocente.save(docente);
		
		Alumno alumno = new Alumno();
		alumno.setIdAlumno("75321");
		alumno.setNombre("andrik");
		alumno.setCorreo("gabg2116@gmail.com");
		repositorioAlumno.save(alumno);
		
		Administrador adm = new Administrador();
		adm.setIdAdministrador("14785");
		adm.setNombre("yesica");
		repositorioAdm.save(adm);
		
		Evaluador Revisor1= new Evaluador();
		Revisor1.setNombre("Omar");
		Revisor1.setUsuario("Omar Aldaco");
		Revisor1.setContraseña("Aldaco33");
		Revisor1.setTelefono(34244324);
		Revisor1.setCorreo("AldalcoOm34@izt.uam.mx");
		Revisor1.setStatus(true);
		Revisor1.setTipoRevisor("Director");
		
		repositoryEvalaudor.save(Revisor1);
		Revisor1= new Evaluador();
		Revisor1.setNombre("gabi");
		Revisor1.setUsuario("Omar Aldaco");
		Revisor1.setContraseña("gabi33");
		Revisor1.setTelefono(34244324);
		Revisor1.setCorreo("AldalcoOm34@izt.uam.mx");
		Revisor1.setStatus(true);
		Revisor1.setTipoRevisor("Director");
		repositoryEvalaudor.save(Revisor1);
		
		Evaluador Revisor2= new Evaluador();
		Revisor2.setNombre("Pedro");
		Revisor2.setUsuario("Pedro Rodriguez");
		Revisor2.setContraseña("Pedro45");
		Revisor2.setTelefono(6453564);
		Revisor2.setCorreo("PedroRodro674@izt.uam.mx");
		Revisor2.setTipoRevisor("Revisor");
		Revisor2.setStatus(true);
		repositoryEvalaudor.save(Revisor2);
		
		Revisor2= new Evaluador();
		Revisor2.setNombre("jorge");
		Revisor2.setUsuario("Pedro Rodriguez");
		Revisor2.setContraseña("jorge45");
		Revisor2.setTelefono(6453564);
		Revisor2.setCorreo("PedroRodro674@izt.uam.mx");
		Revisor2.setTipoRevisor("Revisor");
		Revisor2.setStatus(true);
		repositoryEvalaudor.save(Revisor2);
		
		Notificacion Notificacion1 = new Notificacion();
		Notificacion1.setIdNotificación(12345);
		Notificacion1.setRemitente("Gerardo");
		Notificacion1.setDestinatario("Andrik");
		Notificacion1.setCorreo("gabg2116@gmail.com");
		Notificacion1.setAsunto("Tesis");
		Notificacion1.setMensaje("Le falta mejorar a la tesis");
		Notificacion1.setDocente(docente1);
		repositorioNotificacion.save(Notificacion1);
		
		
	}
	
	

}

