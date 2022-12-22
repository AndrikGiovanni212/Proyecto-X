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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Data;

@Entity 
@Data
public class Alumno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idAlumno;

	private String contraseñaAlumno;
	
	private String correo;
	
	private String nombre;
	
	private int edad;
	
	private int telefono;
	
	private String matricula;
	
	private boolean correoEnviado=false;
	
	private String Usuario;

  	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToOne(targetEntity = Tesina.class, cascade = CascadeType.ALL)
	private Tesina tesina;	

	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(targetEntity = Notificacion.class, cascade = CascadeType.ALL)
	private List <Notificacion> notificacicion;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(targetEntity = Evaluador.class, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Evaluador> evaluador;
	
//	@LazyCollection(LazyCollectionOption.FALSE)
//	@ManyToMany(targetEntity = Archivo.class, cascade = CascadeType.ALL)
//	private List <Archivo> archivo;


	

}


