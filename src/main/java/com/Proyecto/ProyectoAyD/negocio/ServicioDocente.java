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
	
	List<Actividad> list=new ArrayList<Actividad>();;
	Actividad vo;
	Docente docenteLocal;
	
	public boolean buscaDocente(String Contraseña, String Nombre) {
		Docente docenteLocal = repositoryDocente.findByIdDocente(Contraseña);
		if(docenteLocal != null) {
			if(docenteLocal.getNombre().equals(Nombre)) { //valida el nombre del docente obtenido con el nombre ingresado
				return true;
			}
		}	
		return false;
	}
	
	public List<Actividad> recuperaListaPDF(String Contraseña){
		List<Actividad> list = new ArrayList();		
		for(Actividad act:repositoryActividad.findByDocenteIdDocente(Contraseña)) {
			Actividad vo = new Actividad();
			vo.setIdActividad(act.getIdActividad());
			vo.setNombreArchivo(act.getNombreArchivo());
			vo.setArchivoPdf(act.getArchivoPdf());
			vo.setFecha(act.getFecha());
			list.add(vo);		
		}
		return list;
	}
	
	public void AgregarActividades(String nombre, byte[] pdf ,String contraseña, Date fecha) {
		this.vo = new Actividad();
		vo.setNombreArchivo(nombre);	
		vo.setArchivoPdf(pdf);
		System.out.println(pdf);
		vo.setFecha(fecha);
		Docente dos = repositoryDocente.findByIdDocente(contraseña);
		vo.setDocente(dos);
		repositoryActividad.save(vo);	
		this.list.add(vo);	
		dos.setActividades(list);
		//falata que si se guarda bien me regrese un true
		repositoryDocente.save(dos);

	}
	
	public void leePdf(long id) {
		byte [] b = null;
		Actividad actLocal = repositoryActividad.findByIdActividad(id);
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
			id = docente.getIdDocente();
		}
		 return id;	
	}
	
	//proc4
	public List<Docente> recuperaListaDocent(){
		List <Docente> list = new ArrayList();
		list = repositoryDocente.findAll();
		return list;
	}
	
	//proc2ModificaFecha
	public Actividad recuperaFecha(long id) {
		return repositoryActividad.findByIdActividad(id);
	}
	public void cambiaFecha(long id, String fechaNueva) throws Exception {
		Date newFecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNueva);
		Actividad act = repositoryActividad.findByIdActividad(id);
		act.setFecha(newFecha);
		repositoryActividad.save(act);
	}
	public void cambiaPassword(String password) {
		String contraseña;
		Docente docente = repositoryDocente.findByIdDocente(password);
		
	}
	public Docente recuperaContraseña (String contraseña) {
		return repositoryDocente.findByIdDocente(contraseña);
	}

}
