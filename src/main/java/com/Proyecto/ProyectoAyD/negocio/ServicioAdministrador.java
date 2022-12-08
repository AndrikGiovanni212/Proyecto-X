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
		Administrador admLocal = repositoryAdm.findByContraseñaAdm(Contraseña);
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
		alumnoLocal.setContraseñaAlumno(contraseña);
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
			docenteLocal.setContraseñaDocente(contraseña);
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
		Alumno alumnoLocal = repositoryAlum.findByContraseñaAlumno(Contraseña);
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
		Docente docenteLocal = repositoryDocen.findByContraseñaDocente(contraseña);
		if(docenteLocal != null) {
			if(docenteLocal.getNombre().equals(nombre)) { 
				return true;
			}
		}	
		return false;
	}
	
	//proc4.2
	/**
	 * Verifica en el repositorio para pasar la referencia al Alumno buscado
	 * @param matricula
	 */
	public Alumno verificaAlumnoParaBaja(String matricula) {
		Alumno alumnoLocal = repositoryAlum.findByMatricula(matricula);
		if(alumnoLocal != null) {
			return alumnoLocal;
		}else {
			return null;
		}
		
	}
	/**
	 * Verifica en el repositorio para pasar la referencia al Docente buscado
	 * @param matricula
	 */
	public Docente verificaDocenteParaBaja(String matricula) {
		Docente docenteLocal = repositoryDocen.findByMatricula(matricula);
		if(docenteLocal != null) {
			return docenteLocal;
		}else {
			return null;
		}
	}
	
	/**
	 * Verifica en el repositorio para pasar la referencia al Docente buscado
	 * @param matricula
	 */
	public boolean verificaExistencia(String matricula) {
		Docente docenteLocal = repositoryDocen.findByMatricula(matricula);
		Alumno alumnoLocal = repositoryAlum.findByMatricula(matricula);
		if(docenteLocal != null||alumnoLocal != null) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Eliminar del repositorio
	 * @param matricula
	 */
	public boolean verificaExistenciaBaja(String matricula) {
		Docente docenteLocal = repositoryDocen.findByMatricula(matricula);
		Alumno alumnoLocal = repositoryAlum.findByMatricula(matricula);
		if(docenteLocal != null||alumnoLocal != null) {
			return true;
		}else {
			return false;
		}
	}
	
}
