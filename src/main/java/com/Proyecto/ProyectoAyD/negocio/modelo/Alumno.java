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
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Entity 
@Data
@Setter
@Getter
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
	
	@ManyToMany(targetEntity = Notificacion.class, cascade = CascadeType.ALL)
	private List <Notificacion> notificacicion;
	@OneToMany(targetEntity = Evaluador.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Evaluador> evaluador;
	@ManyToOne(targetEntity = Tesina.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Tesina tesina;	

	

}


