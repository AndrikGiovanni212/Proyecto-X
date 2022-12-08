package com.Proyecto.ProyectoAyD.negocio.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data
public class Grupo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idGrupo;
	private int capacidad;
	private String Materia;
	private String Docente;
}
