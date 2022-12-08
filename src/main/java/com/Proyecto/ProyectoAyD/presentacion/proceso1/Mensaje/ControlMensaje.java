package com.Proyecto.ProyectoAyD.presentacion.proceso1.Mensaje;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Proyecto.ProyectoAyD.negocio.ServicioAlumno;
import com.Proyecto.ProyectoAyD.negocio.ServicioNotificacion;
import com.Proyecto.ProyectoAyD.presentacion.principal.ControlPrincipal;


/**
 * Esta clase lleva el flujo de control de la ventana vistaMensaje
 * Módulo de control para la historia de usuario EnviarMensaje
 * @author ArmandoArzola
 *
 */
@Component
public class ControlMensaje {

	@Autowired
	private VistaMensaje vista;
	
	@Autowired 
	private ServicioAlumno servicioAlumno;
	@Autowired 
	private ServicioNotificacion servicioNotificacion;
	@Autowired
	ServicioNotificacion servicioEvaluador;
	@Autowired
	ControlPrincipal controlPrincipal;
	private String nombre;
	private String contraseña;
	
	/**
	 * Inicia la historia de usuario
	 * 
	 */
	public void inicia(String contraseña,String nombre)
	{
		this.nombre = nombre;
		this.contraseña = contraseña;
		vista.muestra(this,contraseña,nombre);
	}


	
	/**
	 * Método que arranca la historia de usuario "enviar mensaje"
	 * 
	 */
	public void enviarInfo(String Nombre, String CorreoElectronico, String Mensaje, String Asunto) {
		if(servicioAlumno.validaUsuario(Nombre,CorreoElectronico,Mensaje,Asunto)==true) {
			
			servicioNotificacion.enviarMensaje(Nombre, CorreoElectronico,Mensaje,Asunto);
			
			servicioEvaluador.enviarMensaje(Nombre, CorreoElectronico,Mensaje,Asunto);
			muestraDialogoConMensaje("EXITO");
			
		}
	}
	
	public void MostrarNotifi(String contraseña,String nombre) {
		
		vista.llenaTabla(servicioNotificacion.mostrarNotifi(contraseña,nombre));
	}
	
	public void regresaInicio() {
		controlPrincipal.inicioDocente(nombre, contraseña);
	}
	
	public void muestraDialogoConMensaje(String mensaje ) {
		JOptionPane.showInputDialog(this , mensaje);
	}

}
