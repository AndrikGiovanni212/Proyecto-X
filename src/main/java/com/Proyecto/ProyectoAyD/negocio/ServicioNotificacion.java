package com.Proyecto.ProyectoAyD.negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto.ProyectoAyD.datos.RepositoryNotificacion;
import com.Proyecto.ProyectoAyD.negocio.modelo.Notificacion;



@Service
public class ServicioNotificacion {
	@Autowired
	private RepositoryNotificacion repositorioNotificacion;
	

	/**
	 * 
	 * Envia el mensaje a repositorioNotificacion con los parametros 
	 * nombre, correo electronico, mensaje y asunto
	 * 
	 */
	//proce4
	public void enviarMensaje(String nombre, String correoElectronico, String Mensaje, String Asunto) {
		Notificacion notifi=new Notificacion();
		notifi.setNombre(nombre);
		notifi.setAsunto(Asunto);
		notifi.setMensaje(Mensaje);
		repositorioNotificacion.save(notifi);
	
	}
	
	//proc 1
	//Funcion para pedirle al repositorio notificacion las notificaciones que tiene el docente
	public List<Notificacion> mostrarNotifi(String contraseña,String nombre) {
		List<Notificacion> notifi1 = new ArrayList();
		return notifi1=repositorioNotificacion.findByDocenteIdDocente(contraseña);
	}
	
	public void solicitudFecha(String NombreDestinatario, String CorreoElectronico, String Mensaje, String Asunto,String nombreRemitente){
		Notificacion notifi=new Notificacion();
		notifi.setAsunto(Asunto);
		notifi.setCorreo(CorreoElectronico);
		notifi.setDestinatario(NombreDestinatario);
		notifi.setMensaje(Mensaje);
		notifi.setRemitente(nombreRemitente);
	
		repositorioNotificacion.save(notifi);
	}


}
