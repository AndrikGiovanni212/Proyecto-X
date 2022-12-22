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

import lombok.Data;
@Entity
@Data
public class Evaluador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEvaluador;
	private boolean correoEnviado = false;
	private String nombre;
	private String identificación;
	private long idGrupo;
	private String correo;
	private int telefono;
	private String usuario;
	private String contraseñaEvaluador;
	private Boolean status;
	private String tipoRevisor;
	private int edad;
	private String matricula;
	

	@OneToMany(targetEntity = Archivo.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private List <Archivo> archivo;


}

