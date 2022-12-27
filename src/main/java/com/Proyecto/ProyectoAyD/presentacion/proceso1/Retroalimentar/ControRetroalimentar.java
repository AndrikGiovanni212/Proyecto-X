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

public void enviarRetro(String retroalimentacion,String asunto,String nombre,String nombreDocente) {
	try {
		servicioEvaluador.enviarRetro(retroalimentacion,asunto,nombre,nombreDocente);
		vista.muestraDialogoConMensaje("Retroalimentación enviada exitosamente");
	} catch(Exception ex) {
		vista.muestraDialogoConMensaje("Error: "+ex.getMessage());
	}
	
}
}
