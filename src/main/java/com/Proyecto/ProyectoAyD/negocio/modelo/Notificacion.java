package com.Proyecto.ProyectoAyD.negocio.modelo;

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



import lombok.Data;


@Entity
@Data
public class Notificacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idNotificación;
	private String nombre;
	private String mensaje;
	private String remitente;
	private String destinatario;
	private String asunto;
	private String correo;
	private int hora;
	
	@ManyToOne(targetEntity = Docente.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Docente docente;
	

	@ManyToOne(targetEntity = Alumno.class, fetch = FetchType.EAGER)
    private Alumno alumno;

	
	/**
	 * Permite confirmar si la notificacion fue hecha de manera correcta
	 */
//	public boolean Confirmacion(Notificacion notifi ) {
//		
//		if(notifi == null) {
//			throw new IllegalArgumentException("Mensaje null");
//		}
//		return true;
//	}
}

