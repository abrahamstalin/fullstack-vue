package com.ajal.technology.cursos.adminincidencias.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	
	public Usuario findByNombreUsuario(String nombreUsuario);

}
