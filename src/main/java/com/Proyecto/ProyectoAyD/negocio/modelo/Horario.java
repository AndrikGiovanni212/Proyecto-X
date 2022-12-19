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

public class Horario {

	@Id
	private String modo; 
	
	private String dia;
	
	private String mes;
	
	private String año;
	
	private String hora;
	
	@JsonIgnore
	@ManyToOne(targetEntity = Alumno.class,fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Alumno alumno;
	
	
	
}
