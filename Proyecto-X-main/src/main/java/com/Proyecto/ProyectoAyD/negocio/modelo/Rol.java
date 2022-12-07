package com.Proyecto.ProyectoAyD.negocio.modelo;

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


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class Rol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idRol;
	private String nombre;
//	@OneToMany(mappedBy="rol", cascade = CascadeType.ALL, orphanRemoval = true)
//	private Evaluador evaluador;
}