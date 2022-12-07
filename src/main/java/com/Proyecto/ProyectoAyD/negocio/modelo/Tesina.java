package com.Proyecto.ProyectoAyD.negocio.modelo;

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
@Getter
@Setter
public class Tesina {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTesina;
	private String autor;
	@OneToOne(targetEntity = Tema.class, fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Tema tema;
	@OneToOne(targetEntity = Alumno.class, fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Alumno alumno;
}
