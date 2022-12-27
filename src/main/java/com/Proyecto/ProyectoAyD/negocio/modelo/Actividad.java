package com.Proyecto.ProyectoAyD.negocio.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data

public class Actividad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idActividad;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long numeroActividad;
	@Column(nullable = false, length = 900000)
	private byte[] archivoPdf;
	private String nombreArchivo;
	//proceso2modificarfecha
	private Date fecha;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(nullable = false, updatable = false)
    private Docente docente;
	
}
