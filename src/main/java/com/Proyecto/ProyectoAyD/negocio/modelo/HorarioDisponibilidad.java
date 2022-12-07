package com.Proyecto.ProyectoAyD.negocio.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Entity
@Data
public class HorarioDisponibilidad  {
	@Id
	private String contraseñaDocente;
	
	private String lugar;
	
	private String lunes, martes, miercoles, jueves,viernes;

	private boolean disponible;
	
	private boolean ocupado;
	
	
	@JsonIgnore
	@ManyToOne(targetEntity = Docente.class,fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Docente docente;
	
	public boolean agregaHorarioDisponibilidad(HorarioDisponibilidad HD) {
		
		if(HD == null) {
			throw new IllegalArgumentException("El horario disponibilidad no puede ser null");
		}
		return true;
	}
	
	
}
