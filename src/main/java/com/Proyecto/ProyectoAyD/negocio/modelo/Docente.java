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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Data;



@Entity
@Data
public class Docente {
	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idDocente;

	private String contraseñaDocente;
	
	private String nombre;
	
	private String correo;
	
	private int edad;
	
	private int telefono;
	
	private String matricula;
	
	private boolean correoEnviado=false;
	
	private String Usuario;
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(targetEntity = Actividad.class, cascade = CascadeType.ALL)
	private List <Actividad> actividades;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(targetEntity = Alumno.class)
	private List <Notificacion> notificacion;
	
}

