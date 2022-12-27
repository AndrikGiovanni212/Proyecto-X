package com.Proyecto.ProyectoAyD.negocio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.Proyecto.ProyectoAyD.datos.DocenteRepository;
import com.Proyecto.ProyectoAyD.datos.HorarioDisponibilidadRepository;
import com.Proyecto.ProyectoAyD.datos.RepositoryEvaluador;
import com.Proyecto.ProyectoAyD.datos.RepositoryEvaluador;
import com.Proyecto.ProyectoAyD.negocio.modelo.Evaluador;
import com.Proyecto.ProyectoAyD.negocio.modelo.Docente;
import com.Proyecto.ProyectoAyD.negocio.modelo.Evaluador;
import com.Proyecto.ProyectoAyD.negocio.modelo.HorarioDisponibilidad;

@ExtendWith(MockitoExtension.class)
class ServicioEvaluadorTest {
	@Mock
	private RepositoryEvaluador evaluadorRepositorio;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	// inyecten todos los Mocks al módulo que quiero
	// probar
	@InjectMocks
	private ServicioEvaluador servicioEvaluador;
	@Test
	void testRecuperaNombre() {
		//caso1
		//si el parametro es null lanza el IllegalArgumentException
		
		NullPointerException exception = assertThrows(NullPointerException.class, () -> {
			servicioEvaluador.recuperaNombre(null);
        });
		assertEquals("Null parameters are not allowed",exception.getMessage());
		
		//caso2
		//que no exita un Evaluador
		String nombre = "juan";
		
		ArrayList<Evaluador> listEvaluador = new ArrayList<>();
		Evaluador eva = new Evaluador();
		eva.setContraseñaEvaluador("75321");
		eva.setNombre("kari");
		eva.setCorreo("gabg2116@gmail.com");
		evaluadorRepositorio.save(eva);
				
		Evaluador eva1 = new Evaluador();
		eva1.setContraseñaEvaluador("75321");
		eva1.setNombre("kari");
		eva1.setCorreo("gabg2116@gmail.com");
		evaluadorRepositorio.save(eva1);
			
		listEvaluador.add(eva);
		listEvaluador.add(eva1);
		
		Evaluador eva0= new Evaluador();
		for(Evaluador eva2:listEvaluador) {
			if(nombre == eva2.getNombre()) {
				eva0.setContraseñaEvaluador(eva2.getContraseñaEvaluador());
				eva0.setNombre(eva2.getNombre());
				eva0.setCorreo(eva2.getCorreo());
			}
		}
		when(evaluadorRepositorio.findByNombre(nombre)).thenReturn(eva0);
		Evaluador alu2 = servicioEvaluador.recuperaNombre(nombre);
		assertEquals(null,alu2.getNombre());
		
		
		//caso3
		//que si exista un Evaluador con el nombre
		 nombre = "kari";
		 eva0 = new Evaluador();
		for(Evaluador eva2:listEvaluador) {
			if(nombre == eva2.getNombre()) {
				eva0.setContraseñaEvaluador(eva2.getContraseñaEvaluador());
				eva0.setNombre(eva2.getNombre());
				eva0.setCorreo(eva2.getCorreo());
			}
		}
		when(evaluadorRepositorio.findByNombre(nombre)).thenReturn(eva0);
		Evaluador eva3 = servicioEvaluador.recuperaNombre(nombre);
		assertEquals(nombre,eva3.getNombre());
		
	}
	
	

}
