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
import com.Proyecto.ProyectoAyD.negocio.modelo.Docente;
import com.Proyecto.ProyectoAyD.negocio.modelo.HorarioDisponibilidad;

@ExtendWith(MockitoExtension.class)
class ServicioDocenteTest {
	
	@Mock
	private DocenteRepository docenteRepositorio;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	// inyecten todos los Mocks al módulo que quiero
	// probar
	@InjectMocks
	private ServicioDocente docenteServicio;

	@Test
	void testRecuperaListaDocent() {
		//caso1: que existan usuario con el atributo (enviar correo) false	
		ArrayList<Docente> listDocente = new ArrayList<>();
		Docente docente = new Docente();
		docente.setContraseñaDocente("12345");
		docente.setNombre("yesenia");
		docente.setCorreo("minimbre@gmail.com");
		docenteRepositorio.save(docente);
		
		Docente docente2 = new Docente();
		docente2.setContraseñaDocente("12385");
		docente2.setCorreo("minimbre@gmail.com");
		docente2.setNombre("yesi");
		docenteRepositorio.save(docente2);
		
		listDocente.add(docente);
		listDocente.add(docente2);
		
		when(docenteRepositorio.findAllByCorreoEnviado(false)).thenReturn(listDocente);
		List<Docente> docentelist = docenteServicio.recuperaListaDocent();
		assertEquals(2,docentelist.size());
		
		//caso2: que no exista usuario con el atributo (envia correo) false por lo tanto que sea una lista vacia
		docente.setCorreoEnviado(true);
		docenteRepositorio.save(docente);
		docente2.setCorreoEnviado(true);
		docenteRepositorio.save(docente2);
		ArrayList<Docente> listDocente2 = new ArrayList<>();
		for(Docente doc:listDocente) {
			if(doc.isCorreoEnviado()) {		
			}else {
				listDocente2.add(doc);
			}
		}
		when(docenteRepositorio.findAllByCorreoEnviado(false)).thenReturn(listDocente2);
		docentelist = docenteServicio.recuperaListaDocent();
		assertEquals(0,docentelist.size());
		
	}

	@Test
	void testMensajeEnviado() {
		//caso1: cambiar el valor de false a true del atributo envia correo
		ArrayList<Docente> listDocente = new ArrayList<>();
		Docente docente = new Docente();
		docente.setContraseñaDocente("12345");
		docente.setNombre("yesenia");
		docente.setCorreo("minimbre@gmail.com");
		docenteRepositorio.save(docente);
		
		Docente docente2 = new Docente();
		docente2.setContraseñaDocente("12385");
		docente2.setCorreo("minimbre@gmail.com");
		docente2.setNombre("yesi");
		docenteRepositorio.save(docente2);
	
		listDocente.add(docente);
		listDocente.add(docente2);	

		boolean cambio = docenteServicio.mensajeEnviado(listDocente);
		assertEquals(true,cambio);
		
		//caso2: que reciba un null como parametro
		//si el parametro es null lanza el IllegalArgumentException
//		Assertions.assertThrows(IllegalArgumentException.class, ()->{
//			boolean cambio2 = docenteServicio.mensajeEnviado(null);
//		});
		
		//caso3: que reciba una lista vacia
		//si el parametro esta vacio regresa un false
		listDocente.clear();
		cambio = docenteServicio.mensajeEnviado(listDocente);
		assertEquals(false,cambio);
		
		
		
	}

}
