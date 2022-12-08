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
import javax.persistence.OneToMany;

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
	
	@OneToMany(targetEntity = Actividad.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private List <Actividad> actividades;
	
	@OneToMany(targetEntity = Notificacion.class)
	private List <Notificacion> notificacion;
	
}
