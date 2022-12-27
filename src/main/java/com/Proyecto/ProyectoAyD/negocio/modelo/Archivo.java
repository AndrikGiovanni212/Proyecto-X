package com.Proyecto.ProyectoAyD.negocio.modelo;

import java.util.Date;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Data;
@Entity
@Data

public class Archivo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idArchivo;
	@Column(nullable = false, length = 900000)
	private byte[] archivoPdf;
	private String nombreArchivo;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(nullable = false, updatable = false)
    private Evaluador evaluador;

	
}
