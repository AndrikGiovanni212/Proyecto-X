package com.Proyecto.ProyectoAyD.negocio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

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
class ServicioHorarioDisponibilidadTest {
	
	@Mock
	private HorarioDisponibilidadRepository disponibilidadRepositorio;
	
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
	private ServicioHorarioDisponibilidad HDServicio;
	
	@Test
	void testVerificaExistenciaHorario() {
		//Caso de prueba 2: el ArrayList es null 	
		String idDocente = "12345";
		ArrayList<HorarioDisponibilidad> HD = HDServicio.verificaExistenciaHorario(idDocente);
		assertEquals(null,HD);
		
		//Caso de prueba 1: se crea exitosamente el ArrayList
		LinkedList<HorarioDisponibilidad> HDs = new LinkedList<>();
		
		Docente docente = new Docente();
		docente.setContraseñaDocente("12345");
		docente.setNombre("nabeel");
		docenteRepositorio.save(docente);
		
		HorarioDisponibilidad disponibilidad = new HorarioDisponibilidad();
		disponibilidad.setContraseñaDocente("12365");
		disponibilidad.setLunes("12");
		disponibilidad.setMartes("14");
		disponibilidad.setMiercoles("6");
		disponibilidad.setJueves("5");
		disponibilidad.setViernes("8");
		disponibilidad.setLugar("salon");
		disponibilidad.setDisponible(true);
		disponibilidad.setOcupado(false);
		disponibilidad.setDocente(docente);
		
		HorarioDisponibilidad disponibilidad1 = new HorarioDisponibilidad();
		//disponibilidad1.setContraseñaDocente("123654");
		disponibilidad1.setLunes("12");
		disponibilidad1.setMartes("14");
		disponibilidad1.setMiercoles("6");
		disponibilidad1.setJueves("5");
		disponibilidad1.setViernes("8");
		disponibilidad1.setLugar("salon");
		disponibilidad1.setDisponible(false);
		disponibilidad1.setOcupado(false);
		disponibilidad1.setDocente(docente);
		
		HDs.add(disponibilidad);
		HDs.add(disponibilidad1);
		
		when(disponibilidadRepositorio.findAllByDocenteContraseñaDocente(idDocente)).thenReturn(HDs);
		
		HD = HDServicio.verificaExistenciaHorario(idDocente);
		
		assertEquals(2,HD.size());
			
		//Caso de prueba 3: el parametro el null:
		//si el parametro es null lanza el IllegalArgumentException
		NullPointerException exception = assertThrows(NullPointerException.class, () -> {
			HDServicio.verificaExistenciaHorario(null);
        });
		assertEquals("Null parameters are not allowed",exception.getMessage());
		
	}
			
		
	

//	@Test
//	void testAgregaHorario() {
//		//caso 1 regresa true si se agrega correctamente los datos 
//		
//		//se crea al docente en la base 
//		Docente docente = new Docente();
//		docente.setIdDocente("12345");
//		docente.setNombre("nabeel");
//		docenteRepositorio.save(docente);
//	//se llena los arreglos datos y estatus 
//		String datos[][] = new String[4][6];
//		boolean estatus[][] = new boolean[1][2];
//		String idDocente = "12345";
//		String contraseña = "12365";
//		datos[0][0] = "salon";
//		datos[0][1] = "12";
//		datos[0][2] = "1";
//		datos[0][3] = "8";
//		datos[0][4] = "2";
//		datos[0][5] = "3";
//		datos[1][0] = "";
//		datos[1][1] = "";
//		datos[1][2] = "";
//		datos[1][3] = "";
//		datos[1][4] = "";
//		datos[1][5] = "";
//		datos[2][0] = "";
//		datos[2][1] = "";
//		datos[2][2] = "";
//		datos[2][3] = "";
//		datos[2][4] = "";
//		datos[2][5] = "";
//		datos[3][0] = "";
//		datos[3][1] = "";
//		datos[3][2] = "";
//		datos[3][3] = "";
//		datos[3][4] = "";
//		datos[3][5] = "";
//		
//		estatus[0][0] = false;
//		estatus[0][1] = true;
//		//cuando ocupemos findByIdDocente(idDocente) en el repositorio docenteRepositorio no dara el docente que hemos creado anteriormente
//		when(docenteRepositorio.findByIdDocente(idDocente)).thenReturn(docente);
//		
//		boolean HD = HDServicio.agregaHorario(idDocente, datos, estatus, contraseña);
//		//realiza la prueba
//		assertEquals(true,HD);
//		
//		//caso 2 los parametros son null
//		Assertions.assertThrows(IllegalArgumentException.class, ()->{
//			boolean HDS = HDServicio.agregaHorario(null, null, null, null);
//		});
//	}

	@Test
	void testBuscaHorario() {
		//Caso de prueba 2: el ArrayList es null 	
				String contraseña = "12365";
						ArrayList<HorarioDisponibilidad> HD = HDServicio.buscaHorario(contraseña);
						assertEquals(null,HD);
				
				//Caso de prueba 1: se crea exitosamente el ArrayList
			
					
				//Caso de prueba 3: el parametro el null:
				//si el parametro es null lanza el IllegalArgumentException
				NullPointerException exception = assertThrows(NullPointerException.class, () -> {
					HDServicio.verificaExistenciaHorario(null);
				});
				assertEquals("Null parameters are not allowed",exception.getMessage());
	}

	@Test
	void testActualiza() {
		//caso 1 regresa true si se actualiza los datos correctos
		
		//se crear el el docente en la base
		Docente docente = new Docente();
		docente.setContraseñaDocente("12345");
		docente.setNombre("nabeel");
		docenteRepositorio.save(docente);
		//se crea el areglo de estatus donde tendran los nuevos elementos 
		boolean estatus[][] = new boolean[1][2];
		LinkedList<HorarioDisponibilidad> HDs = new LinkedList<>();
		String idDocente;
		// se crea el horario dispponibilidad en la base de datos
		HorarioDisponibilidad disponibilidad = new HorarioDisponibilidad();
		disponibilidad.setContraseñaDocente("12365");
		disponibilidad.setLunes("12");
		disponibilidad.setMartes("14");
		disponibilidad.setMiercoles("6");
		disponibilidad.setJueves("5");
		disponibilidad.setViernes("8");
		disponibilidad.setLugar("salon");
		disponibilidad.setDisponible(true);
		disponibilidad.setOcupado(false);
		disponibilidad.setDocente(docente);
		HDs.add(disponibilidad);
		
		//se obtiene el id del docente
		idDocente = docente.getContraseñaDocente();
		//se introduce los nuevos datos 
		estatus[0][0] = false;
		estatus[0][1] = true;		
		//cuando ocupemos a disponibilidadRepositorio.findAllByDocenteIdDocente(idDocente) en el metodo obtendremos los nuevos objetos creados
		when(disponibilidadRepositorio.findAllByDocenteContraseñaDocente(idDocente)).thenReturn(HDs);	
		boolean actualiza = HDServicio.actualiza(estatus, idDocente);
		//verifica prueba
		assertEquals(true,actualiza);
		
		//caso 2
		//si los parametros son null lanza el IllegalArgumentException
		NullPointerException exception = assertThrows(NullPointerException.class, () -> {
			HDServicio.verificaExistenciaHorario(null);
		});
		assertEquals("Null parameters are not allowed",exception.getMessage());
	}

	@Test
	void testBuscaDocente() {
		
		//caso 1 regresa null si no existe docente
		String contraseña = "12345";
		String nombre = "nabeel"; 
		
		Docente dos = HDServicio.buscaDocente(contraseña, nombre);
		//vemos si obtenemos los valores deseados
		assertEquals(null,dos);
		
		
		//caso 2 regresa Docente si existe 
		
		//creamos el docente que ya estara en la base
		Docente docente = new Docente();
		docente.setContraseñaDocente("12345");
		docente.setNombre("nabeel");
		docenteRepositorio.save(docente);
	
		// al usar docenteRepositorio.findByIdDocente(contraseña) al llamar HDServicio.buscaDocente(contraseña, nombre)
		//ocupamos a docente como nuestra base creada 
		when(docenteRepositorio.findByContraseñaDocente(contraseña)).thenReturn(docente);
		
		 dos = HDServicio.buscaDocente(contraseña, nombre);
		//vemos si obtenemos los valores deseados
		assertEquals(docente,dos);
		
		//caso 3 reciben parametros nullos
		
		//si un parametro o dos parametros son null lanza el IllegalArgumentException
//		Assertions.assertThrows(IllegalArgumentException.class, ()->{
//			Docente doss = HDServicio.buscaDocente(null, null);
//		});
		
	}

}

