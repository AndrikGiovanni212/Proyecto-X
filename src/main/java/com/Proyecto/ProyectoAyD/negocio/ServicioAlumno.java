package com.Proyecto.ProyectoAyD.negocio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto.ProyectoAyD.datos.RepositoryAlumno;
import com.Proyecto.ProyectoAyD.datos.RepositoryEvaluador;
import com.Proyecto.ProyectoAyD.negocio.modelo.Alumno;
import com.Proyecto.ProyectoAyD.negocio.modelo.Evaluador;
import com.Proyecto.ProyectoAyD.negocio.modelo.Tema;

@Service
public class ServicioAlumno 
{
	
	@Autowired
	RepositoryAlumno repositoryAlumno;
	@Autowired
	RepositoryEvaluador repositoryEvaluador;
	Alumno alumnoLocal;
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
		return repositoryAlumno.findByNombre(nombre);
	}

	
}
