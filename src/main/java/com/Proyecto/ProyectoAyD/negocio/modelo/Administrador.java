package com.Proyecto.ProyectoAyD.negocio.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data

public class Administrador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idAdm;
	private String contraseñaAdm;
	private String idAdministrador;
	private String nombre;
	
	//Proceso 4-1 Altas
		@OneToMany(targetEntity = Alumno.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
		private List <Alumno> alumno;
		
		@OneToMany(targetEntity = Docente.class)
		private List <Docente> docente;
		@OneToMany(targetEntity = Evaluador.class)
		private List <Evaluador> evaluador;
}
