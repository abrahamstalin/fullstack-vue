package com.ajal.technology.cursos.adminincidencias.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(unique = true, length = 30, nullable = false)
	@Size(min = 2, message = "El nombre del producto tipo tiene una longitud minima de 2 caracteres")
	private String nombreUsuario;
	@Column(nullable = false, length = 80)
	@NotNull(message = "La contraseña es requerida")
	@Size(min = 5,  message = "La longitud de la contraseña debe de estar entre los 5 y 10 digitos")
	private String contrasena;
	@Enumerated(EnumType.STRING)
	private TipoUsuario tipoUsuario;

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
