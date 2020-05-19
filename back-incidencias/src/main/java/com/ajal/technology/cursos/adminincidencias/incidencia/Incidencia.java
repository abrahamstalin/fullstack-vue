package com.ajal.technology.cursos.adminincidencias.incidencia;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Incidencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 50, nullable = false)
	@Size(min = 2, message = "El nombre de la incidencia debe tener una longitud minima de 2 caracteres")
	private String nombre;
	@Column(length = 430, nullable = false)
	@Size(min = 2, message = "La descripcion de la incidencia debe tener una longitud minima de 2 caracteres")
	private String descripcion;
	@Enumerated(EnumType.STRING)
	private EstatusIncidencia estatusIncidencia;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public EstatusIncidencia getEstatusIncidencia() {
		return estatusIncidencia;
	}

	public void setEstatusIncidencia(EstatusIncidencia estatusIncidencia) {
		this.estatusIncidencia = estatusIncidencia;
	}

}
