package com.Proyecto.ProyectoAyD.negocio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto.ProyectoAyD.datos.RepositoryArchivo;
import com.Proyecto.ProyectoAyD.datos.RepositoryEvaluador;
import com.Proyecto.ProyectoAyD.negocio.modelo.Archivo;
import com.Proyecto.ProyectoAyD.negocio.modelo.Evaluador;


@Service
public class ServicioEvaluador {
	@Autowired
	RepositoryEvaluador repositoryEvaluador;
	@Autowired
	RepositoryArchivo repositoryArchivo;
	//Recuperemos 
	public Evaluador recuperaNombre(String nombre) 
	{//inicio de métodorecuperar
		Evaluador alum=new Evaluador();

		alum=repositoryEvaluador.findBynombre(nombre);
		return alum;
	}//fin de métodorecuperar
	public List  <Evaluador> recuperarTodo() {
		List  <Evaluador> evaluador= new ArrayList<>();
		 
		
		for (Evaluador evaluador2 : repositoryEvaluador.findAll()) {
			evaluador.add(evaluador2);
		}
		return evaluador;
	}
	
	public List<Evaluador> recuperEvaluador(long idDirector, long idRevisor){
		List<Evaluador> evaluador = new ArrayList<>();
		evaluador.add(repositoryEvaluador.findByIdEvaluador(idDirector));
		evaluador.add(repositoryEvaluador.findByIdEvaluador(idRevisor));
		return evaluador;
	}
	public void guardaravance( String nombre, File ruta,String Evaluador) {
        
        Archivo archi = new Archivo();
        List<Archivo> listarchi=new ArrayList<Archivo>();
        Evaluador eva=new Evaluador();
        eva=repositoryEvaluador.findBynombre(Evaluador);
        System.out.println(eva+"Servicio");
        //po.setNombreArchivo(nombre);
        try {
            byte[] pdf = new byte[(int) ruta.length()];
            InputStream input = new FileInputStream(ruta);
            input.read(pdf);
            archi.setArchivoPdf(pdf);
            archi.setNombreArchivo(nombre);
            archi.setEvaluador(eva);
            repositoryArchivo.save(archi);
            listarchi.add(archi);
            eva.setArchivo(listarchi);
            repositoryEvaluador.save(eva);
        } catch (IOException ex) {
            archi.setArchivoPdf(null);
            //System.out.println("Error al agregar archivo pdf "+ex.getMessage());
        }
    }

}
