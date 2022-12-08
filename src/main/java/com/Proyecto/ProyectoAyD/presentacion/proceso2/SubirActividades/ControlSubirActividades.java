package com.Proyecto.ProyectoAyD.presentacion.proceso2.SubirActividades;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Proyecto.ProyectoAyD.negocio.ServicioDocente;
import com.Proyecto.ProyectoAyD.presentacion.principal.ControlPrincipal;
import com.Proyecto.ProyectoAyD.presentacion.proceso2.ModificarFechaEntrega.ControlModificarFechaEntrega;
import com.Proyecto.ProyectoAyD.presentacion.proceso3.SubirHorario.ControlSubirEstatus;


@Component
public class ControlSubirActividades {
	
	
	@Autowired
	private VistaSubirActividades vistaSubirActividades;
	@Autowired
	private ServicioDocente servicioDocente;
	@Autowired
	private ControlSubirEstatus controlSubirEstatus;
	@Autowired
	private ControlModificarFechaEntrega controlModificaFecha;
	@Autowired
	private ControlPrincipal controlPrincipal;
	private String nombre;
	private String contraseña;
	
	public void muestraSubirActividades(String nombreDocente,String contraseña) {
		nombre = nombreDocente;
		this.contraseña = contraseña;
		vistaSubirActividades.vistaSubirActividades(this, nombreDocente,contraseña);
		vistaSubirActividades.llenaTabla(servicioDocente.recuperaListaPDF(contraseña));
	}
	
	public void guardaPdf(String nombre, byte[] pdf ,String contraseña,String fecha) {
		String sDate1=fecha; 
		try {
			Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
			servicioDocente.AgregarActividades(nombre, pdf, contraseña, date1);
			vistaSubirActividades.llenaTabla(servicioDocente.recuperaListaPDF(contraseña));
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		
	}
	
	public void abrePdf(long id) {
		servicioDocente.leePdf(id);
	}
	
	public void ventanaHorarioDisponibilidad(String nombre, String contraseña) {
		controlSubirEstatus.inicia(nombre, contraseña);
	}
	
	//proceso2nabeel
	public void modifica(long id) {
		controlModificaFecha.muestra(id,nombre,contraseña);
	}
	
	public void regresaInicio() {
		controlPrincipal.inicioDocente(nombre, contraseña);
	}
	
}
