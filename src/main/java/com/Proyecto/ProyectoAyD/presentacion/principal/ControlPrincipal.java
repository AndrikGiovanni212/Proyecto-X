package com.Proyecto.ProyectoAyD.presentacion.principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Proyecto.ProyectoAyD.negocio.ServicioAdministrador;
import com.Proyecto.ProyectoAyD.negocio.ServicioAlumno;
import com.Proyecto.ProyectoAyD.negocio.ServicioDocente;
import com.Proyecto.ProyectoAyD.negocio.ServicioEvaluador;
import com.Proyecto.ProyectoAyD.negocio.modelo.Alumno;
import com.Proyecto.ProyectoAyD.negocio.modelo.Evaluador;

//import com.Proyecto.ProyectoAyD.presentacion.proceso1.ElecciónDocente.ControlEleccionDocente;
import com.Proyecto.ProyectoAyD.presentacion.proceso1.ElegirTema.ControlElegirTema;
import com.Proyecto.ProyectoAyD.presentacion.proceso1.Mensaje.ControlMensaje;
import com.Proyecto.ProyectoAyD.presentacion.proceso1.SeleccionHorario.ControSeleccionHorario;
import com.Proyecto.ProyectoAyD.presentacion.proceso2.SolicitudCambioFecha.ControlSolicitudCambioFecha;
import com.Proyecto.ProyectoAyD.presentacion.proceso2.SubirActividades.ControlSubirActividades;
import com.Proyecto.ProyectoAyD.presentacion.proceso3.SubirHorario.ControlSubirEstatus;
import com.Proyecto.ProyectoAyD.presentacion.proceso3.VisualizarEstatus.ControlVisualizarEstatus;
import com.Proyecto.ProyectoAyD.presentacion.proceso4.AltaUsuario.ControlAlta;
import com.Proyecto.ProyectoAyD.presentacion.proceso4.BajaUsuario.ControlBaja;
import com.Proyecto.ProyectoAyD.presentacion.proceso4.CambiarPassword.ControlCambiarPassword;
import com.Proyecto.ProyectoAyD.presentacion.proceso4.EnviarCorreos.ControlEnviarCorreos;



@Component
public class ControlPrincipal {
	@Autowired
	private VentanaPrincipal ventanaPrincipal;
	
	@Autowired
	private ServicioAdministrador servicioAdministrador;
	@Autowired
	private ServicioDocente servicioDocente;
	@Autowired
	private ServicioAlumno servicioAlumno;
	@Autowired
	private ServicioEvaluador servicioEvaluador;
	@Autowired
	private ControlSubirActividades controlSubirActividades;
	@Autowired
	private ControlSubirEstatus controlSubir;
	@Autowired
	private ControlEnviarCorreos controlEnviarCorreos;
	@Autowired
	private ControlVisualizarEstatus controlVisualizarEstatus;
	@Autowired
	private ControSeleccionHorario controlSeleccionHorario;

	//proceso1
	@Autowired
	private ControlMensaje controlMensaje;
	//proceso4.1
	@Autowired
	private ControlAlta controlVisualizarAlta;

	//proc4.2
	@Autowired
	private ControlBaja controlVisualizarBaja;
	//proc4.3
	@Autowired
	private ControlCambiarPassword controlPassword;
	//proc2.3
	@Autowired
	private ControlSolicitudCambioFecha controlCambioFecha;
	
	

	//proceso1.3
	@Autowired
	ControlElegirTema controlElegirTema;

	public void inicia() {
		ventanaPrincipal.login(this);
		
	}
	
	public void datosAdministrador() {
		ventanaPrincipal.loginAdministrador(this);
	}
	
	public void datosDocentes() {
		ventanaPrincipal.loginDocente(this);
	}
	
	public void datosAlumnos() {
		ventanaPrincipal.loginAlumno(this);
	}
	
	public boolean buscaAdministrador(String Contraseña, String Nombre) {	
		return servicioAdministrador.buscaAdministrador(Contraseña, Nombre);
	}
	
	public boolean buscaDocente(String Contraseña, String Nombre) {	
		return servicioDocente.buscaDocente(Contraseña, Nombre);
	}
	
	public boolean buscaEvaluador(String Contraseña, String Nombre) {
		return servicioEvaluador.buscaEvaluador(Contraseña, Nombre);
	}
	public void ElegirTema(String Nombre) 
	{	
		controlElegirTema.inicia( Nombre);
	}//fin de ElegirTema
	public boolean buscaAlumno(String Contraseña, String Nombre) {	
		return servicioAlumno.buscaAlumno(Contraseña, Nombre);
	}
	
	public void inicioAdministrador(String nombre,String contraseña) {
		ventanaPrincipal.administrador(this, nombre,contraseña);
	}
	
	public void inicioAlumno(String nombre,String contraseña) {
		ventanaPrincipal.alumno(this, nombre,contraseña);
	}
	
	public void inicioDocente(String nombre, String contraseña) {
		ventanaPrincipal.docente(this, nombre,contraseña);
	}
	
	public void inicioEvaluador(String nombre, String contraseña) {
		ventanaPrincipal.evaluador(this, nombre,contraseña);
	}
	
	//proc2
	public void muestraSubirActividades(String nombreDocente,String contraseña) {
		controlSubirActividades.muestraSubirActividades(nombreDocente,contraseña);
	}
	
	//proceso3.1
	public void eleccionHorario(String nombre,String idDocente) {
		controlSubir.inicia(nombre,idDocente);
	}
	
	//procesos3 alumno
	public void eleccionHorarioAlumno(String nombreAlumno) {
		controlVisualizarEstatus.inicia(nombreAlumno);
	}
	
	//proceso 1 HU1-7 Alumno
	public void seleccionHorarioAlumno(String nombreAlumno) {
		controlSeleccionHorario.inicia(nombreAlumno);
	}
	
	//procesos 4 
	public void enviarCorreos(String nombre,String contraseña) {
		controlEnviarCorreos.muestra(nombre,contraseña);
	}
	
	//proceso1 Mensaje
	public void mensaje(String contraseña, String nombreDocente) {		
		controlMensaje.inicia(contraseña, nombreDocente);
	
	}
	
	//proceso1 elegirDocente
	public void EleccionDocente(String nombreAlumno,String contraseña) 
	{//inicio método EleccionDocente
			//controlEleccionDocente.inicia(nombreAlumno, contraseña);	

	}//fin de ElecicónDocente
	
	

	//proceso 4.1 Dar de Alta
	public void darAltas(String nombreAdmin, String contraseña) {
		controlVisualizarAlta.inicia(nombreAdmin, contraseña);
	}
	
	//proc 4.2
	public void darBajas(String nombreAdmin, String contraseña) {
		controlVisualizarBaja.inicia(nombreAdmin, contraseña);
	}
	
	//proc 4.3
	public void cambiarContraseña( String nombre,String contraseña) {
		controlPassword.inicia(nombre,contraseña);
	}
	//proceso 2.3 Cambio de Fecha de entrega
	public void cambioFechaEntrega(String nombreAlumno,String contraseña) {
		controlCambioFecha.inicia(nombreAlumno,contraseña);
	}
}
