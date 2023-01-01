package com.Proyecto.ProyectoAyD.negocio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto.ProyectoAyD.datos.ActividadesRepository;
import com.Proyecto.ProyectoAyD.datos.RepositoryAlumno;
import com.Proyecto.ProyectoAyD.datos.RepositoryArchivo;
import com.Proyecto.ProyectoAyD.datos.RepositoryEvaluador;
import com.Proyecto.ProyectoAyD.datos.RepositoryNotificacion;
import com.Proyecto.ProyectoAyD.negocio.modelo.Actividad;
import com.Proyecto.ProyectoAyD.negocio.modelo.Alumno;
import com.Proyecto.ProyectoAyD.negocio.modelo.Archivo;
import com.Proyecto.ProyectoAyD.negocio.modelo.Docente;
import com.Proyecto.ProyectoAyD.negocio.modelo.Evaluador;
import com.Proyecto.ProyectoAyD.negocio.modelo.Notificacion;
import com.Proyecto.ProyectoAyD.negocio.modelo.Tema;

@Service
public class ServicioAlumno 
{
	@Autowired
	ActividadesRepository repositoryActividad;
	@Autowired
	RepositoryAlumno repositoryAlumno;
	@Autowired
	RepositoryEvaluador repositoryEvaluador;
	@Autowired
	RepositoryNotificacion repositoryNotificacion;
	Alumno alumnoLocal;
	int numero = 1;
	@Autowired
	RepositoryArchivo repositoryArchivo;
	List<Notificacion> list=new ArrayList<Notificacion>();
	List<Archivo> listArchivo=new ArrayList<Archivo>();
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
	
	/*public List<Actividad> recuperaListaPDF(String Contraseña){
		List<Actividad> list = new ArrayList();		
		for(Actividad act:repositoryActividad.findByAlumnoIdAlumno(Contraseña)) {
			Actividad vo = new Actividad();
			vo.setIdActividad(act.getIdActividad());
			vo.setNombreArchivo(act.getNombreArchivo());
			vo.setArchivoPdf(act.getArchivoPdf());
			vo.setFecha(act.getFecha());
			list.add(vo);		
		}
		return list;
	}*/
	
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
	public boolean guardaEvaluador(List<Evaluador> evaluadores) {
		if(evaluadores.isEmpty()) {
			return false;
		}
		alumnoLocal.setEvaluador(evaluadores);
		repositoryAlumno.save(alumnoLocal);
		return true;
		
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
	
	public boolean guardaravance( String nombre, File ruta,String contraseña) {
		if(nombre.equals("") && contraseña.equals("")) {
			return false;
		}else {
			Archivo archi = new Archivo();
			if(repositoryArchivo.findByAlumnoContraseñaAlumno(contraseña).size() == 0) {
				this.listArchivo = new ArrayList<>();
				this.numero = 1;
			}
			try {
	          byte[] pdf = new byte[(int) ruta.length()];
	          InputStream input = new FileInputStream(ruta);
	          input.read(pdf);
	          archi.setArchivoPdf(pdf);
	          archi.setNombreArchivo(nombre);
	          Alumno alum = new Alumno();
	  		  alum =repositoryAlumno.findByContraseñaAlumno(contraseña);
	  	 	  archi.setAlumno(alum);
	  		  repositoryArchivo.save(archi);
	  		  this.listArchivo.add(archi);
	  		  alum.setArchivo(listArchivo);
	  		  repositoryAlumno.save(alum);
	          
	      } catch (IOException ex) {
	          archi.setArchivoPdf(null);
	      }
			return true;
		}
		
		
	}

}
