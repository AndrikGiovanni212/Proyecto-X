package com.Proyecto.ProyectoAyD.negocio.modelo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Entity
@Data
@Setter
@Getter
public class Tema {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTema;
	private String nombre;
}
