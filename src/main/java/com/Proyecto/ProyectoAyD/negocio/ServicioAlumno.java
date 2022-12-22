package com.Proyecto.ProyectoAyD.negocio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto.ProyectoAyD.datos.RepositoryAlumno;
import com.Proyecto.ProyectoAyD.datos.RepositoryEvaluador;
import com.Proyecto.ProyectoAyD.datos.RepositoryNotificacion;
import com.Proyecto.ProyectoAyD.negocio.modelo.Actividad;
import com.Proyecto.ProyectoAyD.negocio.modelo.Alumno;
import com.Proyecto.ProyectoAyD.negocio.modelo.Docente;
import com.Proyecto.ProyectoAyD.negocio.modelo.Evaluador;
import com.Proyecto.ProyectoAyD.negocio.modelo.Notificacion;
import com.Proyecto.ProyectoAyD.negocio.modelo.Tema;

@Service
public class ServicioAlumno 
{
	
	@Autowired
	RepositoryAlumno repositoryAlumno;
	@Autowired
	RepositoryEvaluador repositoryEvaluador;
	@Autowired
	RepositoryNotificacion repositoryNotificacion;
	Alumno alumnoLocal;
	int numero = 1;
	
	List<Notificacion> list=new ArrayList<Notificacion>();
	//pro3
	public boolean buscaAlumno(String contraseña, String nombre) {
		alumnoLocal = repositoryAlumno.findByContraseñaAlumno(contraseña);
		if(alumnoLocal != null) {
			if(alumnoLocal.getNombre().equals(nombre)) { //valida el nombre del docente obtenido con el nombre ingresado
				return true;
			}
		}	
		return false;
	}
	
	public Alumno datosAlumno() {
		return alumnoLocal;
	}
	
	//proc4
	public List<Alumno> recuperaListaAlumno(){
		List <Alumno> list = new ArrayList();
		list = repositoryAlumno.findAllByCorreoEnviado(false);
		return list;
	
	}
	
	//proceso 1 mensaje

	/**
	 * 
	 * valida que el usuario(alumno) exista a traves del correo y nombre
	 * 
	 * @return un booleano true si es valido y false en dado caso que no se encontro
	 */
	public boolean validaUsuario(String Nombre, String CorreoElectronico, String Mensaje, String Asunto) {
		Alumno alumno=repositoryAlumno.findByCorreo(CorreoElectronico);
		Alumno alumno2=repositoryAlumno.findByNombre(Nombre);
		if(alumno.getCorreo().equals(CorreoElectronico) && alumno2.getNombre().equals(Nombre)) {
			return true;
		}else {return false;}
	}
	
	
	//proceso 1 EleccionDocente
	public void guardaEvaluador(List<Evaluador> evaluadores) {
		alumnoLocal.setEvaluador(evaluadores);
		repositoryAlumno.save(alumnoLocal);
	}

	
	//proce4.4
	public boolean mensajeEnviado(List<Alumno> list) {
		if(list == null) {
			throw new NullPointerException("Null parameters are not allowed"); 
		}
		
		if(list.isEmpty()) {
			return false;
		}
		
		for(Alumno alum:list) {
			alum.setCorreoEnviado(true);
			repositoryAlumno.save(alum);
		}
		return true;
	}
	
	//proc4.2
	
	public Alumno recuperaByNombre(String nombre) {
		if(nombre == null) {
			throw new NullPointerException("Null parameters are not allowed"); 
		}
		
		
		return repositoryAlumno.findByNombre(nombre);
	}
	//proc2.3
	public void solicitudFecha(String NombreDestinatario, String CorreoElectronico, String Mensaje, String Asunto,String nombreRemitente,String contraseña){
		
		if(NombreDestinatario == null) {
			throw new NullPointerException("Null parameters are not allowed"); 
		}
		
		
		Notificacion notifi=new Notificacion();
		if(repositoryNotificacion.findByAlumnoContraseñaAlumno(contraseña).size() == 0) {
			this.list = new ArrayList<>();
			this.numero = 1;
		}
		notifi.setAsunto(Asunto);
		notifi.setCorreo(CorreoElectronico);
		notifi.setDestinatario(NombreDestinatario);
		notifi.setMensaje(Mensaje);
		notifi.setRemitente(nombreRemitente);
		Alumno alum = new Alumno();
		alum =repositoryAlumno.findByContraseñaAlumno(contraseña);
		notifi.setAlumno(alum);
		repositoryNotificacion.save(notifi);
		this.list.add(notifi);
		alum.setNotificacicion(list);
		repositoryAlumno.save(alum);
		
	}

}
