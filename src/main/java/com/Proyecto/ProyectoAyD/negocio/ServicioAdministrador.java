package com.Proyecto.ProyectoAyD.negocio;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto.ProyectoAyD.datos.DocenteRepository;
import com.Proyecto.ProyectoAyD.datos.RepositoryAdministrador;
import com.Proyecto.ProyectoAyD.datos.RepositoryAlumno;
import com.Proyecto.ProyectoAyD.datos.RepositoryEvaluador;
import com.Proyecto.ProyectoAyD.negocio.modelo.Actividad;
import com.Proyecto.ProyectoAyD.negocio.modelo.Administrador;
import com.Proyecto.ProyectoAyD.negocio.modelo.Alumno;
import com.Proyecto.ProyectoAyD.negocio.modelo.Docente;
import com.Proyecto.ProyectoAyD.negocio.modelo.Evaluador;

@Service
public class ServicioAdministrador {
	@Autowired
	RepositoryAdministrador repositoryAdm;
	@Autowired
	RepositoryAlumno repositoryAlum;
	@Autowired
	RepositoryEvaluador repositoryEva;
	@Autowired
	DocenteRepository repositoryDocen;
	
	
	public boolean buscaAdministrador(String Contraseña, String Nombre) {
		Administrador admLocal = repositoryAdm.findByIdAdministrador(Contraseña);
		if(admLocal != null) {
			if(admLocal.getNombre().equals(Nombre)) { //valida el nombre del docente obtenido con el nombre ingresado
				return true;
			}
		}	
		return false;
	}
	/**
	 * Dar de Alta a un usuario de tipo Alumno
	 * @param correo,usuario,edad,nombre,contraseña,matricula,telefono,tipo,tipoRevisor
	 */
	public boolean darAltaAlumno(String correo,String usuario,int edad,String nombre,String contraseña,String matricula, int telefono){
		Alumno alumnoLocal = new Alumno();
		alumnoLocal.setUsuario(usuario);
		alumnoLocal.setTelefono(telefono);
		alumnoLocal.setNombre(nombre);
		alumnoLocal.setMatricula(matricula);
		alumnoLocal.setEdad(edad);
		alumnoLocal.setCorreo(correo);
		alumnoLocal.setIdAlumno(contraseña);
		repositoryAlum.save(alumnoLocal);
		return true;
	}
	/**
	 * Dar de Alta a un usuario de tipo Docente
	 * @param correo,usuario,edad,nombre,contraseña,matricula,telefono,tipo,tipoRevisor
	 */
	public boolean darAltaDocente(String correo,String usuario,int edad,String nombre,String contraseña,String matricula, int telefono,String tipo,String tipoRevisor){
		if(tipo=="DOCENTE"){
			Docente docenteLocal = new Docente();
			docenteLocal.setCorreo(correo);
			docenteLocal.setUsuario(usuario);
			docenteLocal.setEdad(edad);
			docenteLocal.setNombre(nombre);
			docenteLocal.setIdDocente(contraseña);
			docenteLocal.setMatricula(matricula);
			docenteLocal.setTelefono(telefono);
			repositoryDocen.save(docenteLocal);
			
		}else{
			if(tipo=="EVALUADOR"){
				Evaluador evaludadorLocal = new Evaluador();
				evaludadorLocal.setCorreo(correo);
				evaludadorLocal.setMatricula(matricula);
				evaludadorLocal.setEdad(edad);
				evaludadorLocal.setIdentificación(contraseña);
				evaludadorLocal.setNombre(nombre);
				evaludadorLocal.setTelefono(telefono);
				evaludadorLocal.setUsuario(usuario);
				evaludadorLocal.setTipoRevisor(tipoRevisor);
				repositoryEva.save(evaludadorLocal);
			}
			
		}
		return true;
	}
	/**
	 * Verifica en el repositorio si existe el Alumno buscado
	 * @param contraseña y nombre
	 */
	public boolean verificaAlumno(String Contraseña, String Nombre) {
		Alumno alumnoLocal = repositoryAlum.findByIdAlumno(Contraseña);
		if(alumnoLocal != null) {
			if(alumnoLocal.getNombre().equals(Nombre)) { 
				return true;
			}
		}	
		return false;
	}
	/**
	 * Verifica en el repositorio si existe el Docente buscado
	 * @param contraseña y nombre
	 */
	public boolean verificaDocente(String contraseña, String nombre) {
		Docente docenteLocal = repositoryDocen.findByIdDocente(contraseña);
		if(docenteLocal != null) {
			if(docenteLocal.getNombre().equals(nombre)) { 
				return true;
			}
		}	
		return false;
	}
	
}
