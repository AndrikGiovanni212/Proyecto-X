package com.Proyecto.ProyectoAyD.presentacion.proceso1.Retroalimentar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Proyecto.ProyectoAyD.negocio.ServicioEvaluador;

@Component
	public class ControRetroalimentar {
	@Autowired
	VistaRetroalimentar vista;
	@Autowired
	ServicioEvaluador servicioEvaluador;
public void inicia(String revisor, String contraseña) {
	vista.muestra(this, revisor, contraseña);
}


public void verArchivo(String revisor) {
	servicioEvaluador.leePdf(revisor);
}
}
