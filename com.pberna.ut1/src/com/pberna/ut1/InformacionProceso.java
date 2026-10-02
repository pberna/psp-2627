package com.pberna.ut1;

import java.time.LocalDateTime;

public class InformacionProceso {
	private String usuario;
	private String comando;
	private long pid;
	private int salida;
	private LocalDateTime fechaInicio;
	
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getComando() {
		return comando;
	}
	public void setComando(String comando) {
		this.comando = comando;
	}
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public int getSalida() {
		return salida;
	}
	public void setSalida(int salida) {
		this.salida = salida;
	}
	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	
}
