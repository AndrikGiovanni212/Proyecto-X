package com.Proyecto.ProyectoAyD.negocio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto.ProyectoAyD.datos.RepositoryAlumno;
import com.Proyecto.ProyectoAyD.datos.RepositoryArchivo;
import com.Proyecto.ProyectoAyD.datos.RepositoryEvaluador;
import com.Proyecto.ProyectoAyD.datos.RepositoryNotificacion;
import com.Proyecto.ProyectoAyD.negocio.modelo.Alumno;
import com.Proyecto.ProyectoAyD.negocio.modelo.Archivo;
import com.Proyecto.ProyectoAyD.negocio.modelo.Docente;
import com.Proyecto.ProyectoAyD.negocio.modelo.Evaluador;
import com.Proyecto.ProyectoAyD.negocio.modelo.Notificacion;


@Service
public class ServicioEvaluador {
	@Autowired
	RepositoryEvaluador repositoryEvaluador;
	@Autowired
	RepositoryArchivo repositoryArchivo;
	@Autowired
	RepositoryNotificacion repositoryNotificacion;


	//login
	public boolean buscaEvaluador(String Contraseña, String Nombre) {
		Evaluador evaluadorLocal = repositoryEvaluador.findByContraseñaEvaluador(Contraseña);
		if(evaluadorLocal != null) {
			if(evaluadorLocal.getNombre().equals(Nombre)) { //valida el nombre del docente obtenido con el nombre ingresado
				return true;
			}
		}	
		return false;
	}


	//Recuperemos 
	public Evaluador recuperaNombre(String nombre) 
	{//inicio de métodorecuperar
		Evaluador alum=new Evaluador();
		alum=repositoryEvaluador.findBynombre(nombre);
		return alum;
	}//fin de métodorecuperar
	public List  <Evaluador> recuperarTodo() {
		List  <Evaluador> evaluador= new ArrayList<>();
		 
		
		for (Evaluador evaluador2 : repositoryEvaluador.findAll()) {
			evaluador.add(evaluador2);
		}
		return evaluador;
	}
	
	public List<Evaluador> recuperEvaluador(long idDirector, long idRevisor){
		List<Evaluador> evaluador = new ArrayList<>();
		evaluador.add(repositoryEvaluador.findByIdEvaluador(idDirector));
		evaluador.add(repositoryEvaluador.findByIdEvaluador(idRevisor));
		return evaluador;
	}
	public void guardaravance( String nombre, File ruta,String Evaluador) {
        
        Archivo archi = new Archivo();
        List<Archivo> listarchi=new ArrayList<Archivo>();
        Evaluador eva=new Evaluador();
        eva=repositoryEvaluador.findBynombre(Evaluador);
        System.out.println(eva+"Servicio");
        //po.setNombreArchivo(nombre);
        try {
            byte[] pdf = new byte[(int) ruta.length()];
            InputStream input = new FileInputStream(ruta);
            input.read(pdf);
            archi.setArchivoPdf(pdf);
            archi.setNombreArchivo(nombre);
            archi.setEvaluador(eva);
            repositoryArchivo.save(archi);
            listarchi.add(archi);
            eva.setArchivo(listarchi);
            repositoryEvaluador.save(eva);
        } catch (IOException ex) {
            archi.setArchivoPdf(null);
            	//System.out.println("Error al agregar archivo pdf "+ex.getMessage());
        }
    }
	//UH1.4
 public boolean enviarRetro(String retroalimentacion,String asunto,String correo,String nombre,String nombreDocente) {
	 Notificacion retro = new   Notificacion();
	 Evaluador eva= new Evaluador();
	eva=repositoryEvaluador.findBynombre(nombreDocente);
	System.out.println(eva);
	 retro.setAsunto(asunto);
	 retro.setMensaje(retroalimentacion);
	 retro.setNombre(nombre);
	 repositoryNotificacion.save(retro);
	 return false;
 }

}
