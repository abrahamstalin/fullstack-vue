package com.ajal.technology.cursos.adminincidencias;

import java.util.Date;

public class AdminIncidenciasExceptionReponse {

	private Date timestamp;
	private String mensaje;
	private String detalle;
	
	

	public AdminIncidenciasExceptionReponse(Date timestamp, String mensaje, String detalle) {
		super();
		this.timestamp = timestamp;
		this.mensaje = mensaje;
		this.detalle = detalle;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

}
