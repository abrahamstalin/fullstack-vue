package com.ajal.technology.cursos.adminincidencias.incidencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidenciaRepository extends JpaRepository<Incidencia, Integer>{
	
	public List<Incidencia> findByEstatusIncidencia(EstatusIncidencia estatusIncidencia);

}
