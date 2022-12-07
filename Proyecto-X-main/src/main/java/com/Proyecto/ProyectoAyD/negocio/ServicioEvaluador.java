package com.Proyecto.ProyectoAyD.negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto.ProyectoAyD.datos.RepositoryEvaluador;
import com.Proyecto.ProyectoAyD.negocio.modelo.Evaluador;

@Service
public class ServicioEvaluador {
	@Autowired
	RepositoryEvaluador repositoryEvaluador;
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
}
