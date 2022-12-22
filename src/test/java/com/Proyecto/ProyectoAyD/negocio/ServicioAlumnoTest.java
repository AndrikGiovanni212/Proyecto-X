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
import com.Proyecto.ProyectoAyD.datos.RepositoryAlumno;
import com.Proyecto.ProyectoAyD.negocio.modelo.Alumno;
import com.Proyecto.ProyectoAyD.negocio.modelo.Docente;
import com.Proyecto.ProyectoAyD.negocio.modelo.HorarioDisponibilidad;

@ExtendWith(MockitoExtension.class)
class ServicioAlumnoTest {
	@Mock
	private RepositoryAlumno alumnoRepositorio;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	// inyecten todos los Mocks al módulo que quiero
	// probar
	@InjectMocks
	private ServicioAlumno servicioAlumno;

	@Test
	void testRecuperaListaAlumno() {
		//caso1: que existan usuario con el atributo (enviar correo) false	
				ArrayList<Alumno> listAlumno = new ArrayList<>();
				Alumno alumno = new Alumno();
				alumno.setContraseñaAlumno("75321");
				alumno.setNombre("kari");
				alumno.setCorreo("gabg2116@gmail.com");
				alumnoRepositorio.save(alumno);
				
				Alumno alumno2 = new Alumno();
				alumno2.setContraseñaAlumno("75329");
				alumno2.setNombre("andrik");
				alumno2.setCorreo("gabg2116@gmail.com");
				alumnoRepositorio.save(alumno2);
				
				listAlumno.add(alumno);
				listAlumno.add(alumno2);
				
				when(alumnoRepositorio.findAllByCorreoEnviado(false)).thenReturn(listAlumno);
				List<Alumno> alumnolist = servicioAlumno.recuperaListaAlumno();
				assertEquals(2,alumnolist.size());
				
				//caso2: que no exista usuario con el atributo (envia correo) false por lo tanto que sea una lista vacia
				alumno.setCorreoEnviado(true);
				alumnoRepositorio.save(alumno);
				alumno2.setCorreoEnviado(true);
				alumnoRepositorio.save(alumno2);
				ArrayList<Alumno> listAlumno2 = new ArrayList<>();
				for(Alumno alu:listAlumno) {
					if(alu.isCorreoEnviado()) {		
					}else {
						listAlumno2.add(alu);
					}
				}
				when(alumnoRepositorio.findAllByCorreoEnviado(false)).thenReturn(listAlumno2);
				alumnolist = servicioAlumno.recuperaListaAlumno();
				assertEquals(0,alumnolist.size());
	}

	@Test
	void testMensajeEnviado() {
		//caso1: cambiar el valor de false a true del atributo envia correo
		ArrayList<Alumno> listAlumno = new ArrayList<>();
		Alumno alumno = new Alumno();
		alumno.setContraseñaAlumno("75321");
		alumno.setNombre("kari");
		alumno.setCorreo("gabg2116@gmail.com");
		alumnoRepositorio.save(alumno);
		
		Alumno alumno2 = new Alumno();
		alumno2.setContraseñaAlumno("75329");
		alumno2.setNombre("andrik");
		alumno2.setCorreo("gabg2116@gmail.com");
		alumnoRepositorio.save(alumno2);
	
		listAlumno.add(alumno);
		listAlumno.add(alumno2);	

		boolean cambio = servicioAlumno.mensajeEnviado(listAlumno);
		assertEquals(true,cambio);
		
		//caso2: que reciba un null como parametro
		//si el parametro es null lanza el IllegalArgumentException
//		Assertions.assertThrows(IllegalArgumentException.class, ()->{
//			boolean cambio2 = servicioAlumno.mensajeEnviado(null);
//		});
		
		//caso3: que reciba una lista vacia
		//si el parametro esta vacio regresa un false
		listAlumno.clear();
		cambio = servicioAlumno.mensajeEnviado(listAlumno);
		assertEquals(false,cambio);
	}

}
