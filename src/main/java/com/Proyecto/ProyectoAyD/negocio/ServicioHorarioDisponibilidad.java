package com.Proyecto.ProyectoAyD.negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.sound.sampled.Port.Info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto.ProyectoAyD.datos.DocenteRepository;
import com.Proyecto.ProyectoAyD.datos.HorarioDisponibilidadRepository;
import com.Proyecto.ProyectoAyD.negocio.modelo.Docente;
import com.Proyecto.ProyectoAyD.negocio.modelo.HorarioDisponibilidad;



import lombok.extern.slf4j.Slf4j;





@Slf4j
@Service
public class ServicioHorarioDisponibilidad {
	 
	@Autowired
	private HorarioDisponibilidadRepository disponibilidadRepositorio;
	
	@Autowired
	private DocenteRepository docenteRepositorio;
	
	
	/**
	 * realiza la busqueda si existe algun horario en la base de datos con el id docente 
	 * regresa un arreglo de tipo HorarioDisponibiliad si existe y null si no existe  
	 * 
	 * @param idDocent
	 * @return ArrayList<HorarioDisponibilida>  
	 */
	public ArrayList<HorarioDisponibilidad> verificaExistenciaHorario(String idDocent) {	
		ArrayList <HorarioDisponibilidad> HD = new ArrayList<>();
		for(HorarioDisponibilidad HDs:disponibilidadRepositorio.findAllByDocenteIdDocente(idDocent)) { //crea el nuevo arreglo si existe un horario ya creado
			HD.add(HDs);
		}
		if(HD.isEmpty() == true) {
			return null;
		}
		return HD;
	}
	
	public boolean agregaHorario(String idDocente, String datos[][], boolean estatus[][], String contra) {
		int contador = 0;
		boolean verifica = false;
		Optional<Docente> docente = docenteRepositorio.findById(idDocente);
		HorarioDisponibilidad HD = new HorarioDisponibilidad();
		for(int i=0; i<4; i++) {
			if(datos[i][0].equals("")) {		
			}else {
				contador++;
			}
		}		
		for(int i =0; i<contador; i++) {
			HD = new HorarioDisponibilidad();
			if(i==0) {
				HD.setContraseñaDocente(contra);
				}else {HD.setContraseñaDocente(contra+i);}	
			HD.setLugar(datos[i][0]);
			HD.setLunes(datos[i][1]);
			HD.setMartes(datos[i][2]);
			HD.setMiercoles(datos[i][3]);
			HD.setJueves(datos[i][4]);
			HD.setViernes(datos[i][5]);
			HD.setDisponible(estatus[i][0]);
			HD.setOcupado(estatus[i][1]);
			HD.setDocente(docente.get());
			disponibilidadRepositorio.save(HD);
			verifica = HD.agregaHorarioDisponibilidad(HD);
		}	
		return verifica;
			
	}

	public ArrayList<HorarioDisponibilidad> buscaHorario(String contraseña) {
		ArrayList <HorarioDisponibilidad> HD = new ArrayList<>();
		try {
			String idDocente = disponibilidadRepositorio.findByContraseñaDocente(contraseña).get().getDocente().getIdDocente();
			for(HorarioDisponibilidad HDs:disponibilidadRepositorio.findAllByDocenteIdDocente(idDocente)) {
				HD.add(HDs);
			}
			return HD;
		}catch(NoSuchElementException e) {return null;}		
		
	}
	/**
	 * recupera una lista de horarioDisponibilidad para cambiar
	 * el estatus actual del docente  
	 * 
	 * @param idDocent
	 * @return true si se guardo y false si no se guardo 
	 */
	public boolean actualiza(boolean estatus[][], String idDocente) {
		List<HorarioDisponibilidad> oldHD = new ArrayList<HorarioDisponibilidad>();
		oldHD = disponibilidadRepositorio.findAllByDocenteIdDocente(idDocente);
		boolean verifica = false;
		int i =0;
		for(HorarioDisponibilidad HD:oldHD) {
			HD.setDisponible(estatus[i][0]);
			HD.setOcupado(estatus[i][1]);
			disponibilidadRepositorio.save(HD);
			i++;
		}	
		return  true;
	}
	/**
	 * busca al docente en la base de datos si esta regresa al docente si no existe regresa null
	 * 
	 * @param Clave
	 * @param nombre
	 * @return regresa un objeto de tipo docente
	 */
	public Docente buscaDocente(String contraseña, String nombre) {
		Docente docente = docenteRepositorio.findByIdDocente(contraseña); //busca en el repositorio del docente al docente con la contrasela dada por el docente
		if(docente != null) {
			if(docente.getNombre().equals(nombre)) { //valida el nombre del docente obtenido con el nombre ingresado
				return docente;
			}
		}	
		return null;
	}
	

	
}
