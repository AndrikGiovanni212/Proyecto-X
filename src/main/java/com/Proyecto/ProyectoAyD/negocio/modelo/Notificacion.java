package com.Proyecto.ProyectoAyD.negocio.modelo;

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
//	@ManyToOne(fetch = FetchType.LAZY, optional = true)
//    @JoinColumn(nullable = false, updatable = false)
//    private Docente docente;
//	@ManyToOne(fetch = FetchType.LAZY, optional = true)
//    @JoinColumn( updatable = false)
//    private Evaluador director;
	
	
	/**
	 * Permite confirmar si la notificacion fue hecha de manera correcta
	 */
	public boolean Confirmacion(Notificacion notifi ) {
		
		if(notifi == null) {
			throw new IllegalArgumentException("Mensaje null");
		}
		return true;
	}
}
