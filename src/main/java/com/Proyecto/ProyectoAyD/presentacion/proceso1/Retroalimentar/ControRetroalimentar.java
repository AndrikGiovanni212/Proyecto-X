package com.Proyecto.ProyectoAyD.presentacion.proceso1.Retroalimentar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ControRetroalimentar {
	@Autowired
	VistaRetroalimentar vista;
public void inicia(String revisor, String contraseña) {
	vista.muestra(this, revisor, contraseña);
}
}
