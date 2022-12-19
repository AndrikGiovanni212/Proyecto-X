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
import com.Proyecto.ProyectoAyD.datos.RepositoryAlumno;
import com.Proyecto.ProyectoAyD.datos.RepositoryHorario;
import com.Proyecto.ProyectoAyD.negocio.modelo.Alumno;
import com.Proyecto.ProyectoAyD.negocio.modelo.Horario;
import com.Proyecto.ProyectoAyD.negocio.modelo.HorarioDisponibilidad;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service

public class ServicioHorario {

	@Autowired
	private RepositoryHorario horarioRepositorio;
	
	@Autowired
	private RepositoryAlumno RepositorioAlumno;
	
	/**
	 * realiza la busqueda si existe algun horario en la base de datos con el id alumno 
	 * regresa un arreglo de tipo Horario si existe y null si no existe  
	 * 
	 * @param idAlumno
	 * @return ArrayList<Horario>  
	 */
	
	
	public boolean darAltaHorario(String dia, String mes , String hora, String año, String modo , String alumno) {
		Horario horarioPersonal = new Horario();
		Alumno IdAlumno =new Alumno();
		IdAlumno =RepositorioAlumno.findByNombre(alumno);
		horarioPersonal.setDia(dia);
		horarioPersonal.setMes(mes);
		horarioPersonal.setAño(año);
		horarioPersonal.setModo(modo);
		horarioPersonal.setHora(hora);
		horarioPersonal.setAlumno(IdAlumno);
		horarioRepositorio.save(horarioPersonal);
		return true;
	}
	
}
