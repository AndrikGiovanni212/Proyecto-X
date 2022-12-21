package com.Proyecto.ProyectoAyD.negocio;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto.ProyectoAyD.datos.ActividadesRepository;
import com.Proyecto.ProyectoAyD.datos.DocenteRepository;
import com.Proyecto.ProyectoAyD.datos.RepositoryEvaluador;
import com.Proyecto.ProyectoAyD.negocio.modelo.Actividad;
import com.Proyecto.ProyectoAyD.negocio.modelo.Alumno;
import com.Proyecto.ProyectoAyD.negocio.modelo.Docente;
import com.Proyecto.ProyectoAyD.negocio.modelo.Evaluador;




@Service
public class ServicioDocente {
	@Autowired
	DocenteRepository repositoryDocente;
	@Autowired
	ActividadesRepository repositoryActividad;
	@Autowired
	ServicioActividad servicioActividad;
	
	List<Actividad> list=new ArrayList<Actividad>();
	Actividad vo;
	Docente docenteLocal;
	int numero = 1;
	
	public boolean buscaDocente(String Contraseña, String Nombre) {

		Docente docenteLocal = repositoryDocente.findByContraseñaDocente(Contraseña);
		if(docenteLocal != null) {
			if(docenteLocal.getNombre().equals(Nombre)) { //valida el nombre del docente obtenido con el nombre ingresado
				return true;
			}
		}	
		return false;
	}
	/**
	 * recupera la lista de las actividades que ha subido el docente si no ha subido nada 
	 * regresa una lista vacia si tiene alguna actividad regresa una lista con las actividades
	 * 
	 * @return List<Actividad> si existe
	 * @return una lista vacia si no existe una actividad
	 * 
	 * @param String
	 *   
	 */
	public List<Actividad> recuperaListaPDF(String Contraseña){
		List<Actividad> list = new ArrayList();		
		for(Actividad act:repositoryActividad.findByDocenteContraseñaDocente(Contraseña)) {
			Actividad vo = new Actividad();
			vo.setNumeroActividad(act.getNumeroActividad());
			vo.setNombreArchivo(act.getNombreArchivo());
			vo.setArchivoPdf(act.getArchivoPdf());
			vo.setFecha(act.getFecha());
			list.add(vo);		
		}
		return list;
	}
	
	/**
	 * agrega una lista de actividades al docente y se guarda la actividad en la base de datos
	 * 
	 * @return true si se agrego correctamente
	 * @return false si no se agrego correctamente
	 * 
	 * @param String,byte[], String,Date
	 *   
	 */
	
	public boolean AgregarActividades(String nombre, byte[] pdf ,String contraseña, Date fecha) {
		this.vo = new Actividad();
		if(repositoryActividad.findByDocenteContraseñaDocente(contraseña).size() == 0) {
			this.list = new ArrayList<>();
			this.numero = 1;
		}
		vo.setNumeroActividad(numero);
		numero++;
		vo.setNombreArchivo(nombre);	
		vo.setArchivoPdf(pdf);
		vo.setFecha(fecha);
		Docente dos = new Docente();
		dos =repositoryDocente.findByContraseñaDocente(contraseña);
		vo.setDocente(dos);
		repositoryActividad.save(vo);	
		this.list.add(vo);
		dos.setActividades(list);
		repositoryDocente.save(dos);
		return true;

	}
	
	public void leePdf(long id) {
		byte [] b = null;
		Actividad actLocal = repositoryActividad.findByNumeroActividad(id);
		b = actLocal.getArchivoPdf();
		
		InputStream bos= new ByteArrayInputStream(b);
		try {
			int tamanoInput = bos.available();
			byte[] datosPdf = new byte[tamanoInput];
			bos.read(datosPdf, 0, tamanoInput);
			OutputStream out = new FileOutputStream("new.pdf");
			out.write(datosPdf);
			
			out.close();
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}
	//unido con horarioDisponibilidad
	public String traeId() {
		String id = null;
		for(Docente docente:repositoryDocente.findAll()) {
			id = docente.getContraseñaDocente();
		}
		 return id;	
	}
	
	//proc4.4
	/**
	 * recupera una lista de todos los docente que tenga el atributo de correo enviado false
	 * si el atributo es true regresa una lista vacia
	 * 
	 * @return List<Docente> si es false
	 * @return vacio si es true
	 *   
	 */
	public List<Docente> recuperaListaDocent(){
		List <Docente> list = new ArrayList();
		list = repositoryDocente.findAllByCorreoEnviado(false);
		return list;
	}
	
	//proc2ModificaFecha
	public Actividad recuperaFecha(long id) {
		return repositoryActividad.findByNumeroActividad(id);
	}
	public void cambiaFecha(long id, String fechaNueva) throws Exception {
		Date newFecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNueva);
		Actividad act = repositoryActividad.findByNumeroActividad(id);
		act.setFecha(newFecha);
		repositoryActividad.save(act);
	}
	
	//proc4.4
	/**
	 * cambia en la base de datos el valor del atributo correo enviado de false a true
	 * 
	 * @param list<Docente>
	 *   
	 */
		public boolean mensajeEnviado(List<Docente> list) {
			if(list.isEmpty()) {
				return false;
			}
			
			for(Docente doc:list) {
				doc.setCorreoEnviado(true);
				repositoryDocente.save(doc);
			}
			return true;
		}
		
	//proc4.3
		public Docente cambioContraseña(String contraseña,String nombre, String oldcontraseña) {
			Docente docente = repositoryDocente.findByContraseñaDocente(oldcontraseña);
			docente.setContraseñaDocente(contraseña);
			repositoryDocente.save(docente);
			return docente;
		}
}
