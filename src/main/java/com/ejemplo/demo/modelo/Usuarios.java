package com.ejemplo.demo.modelo;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="user")
@Access(AccessType.FIELD)
public class Usuarios extends EntidadPadre {

	
	private static final long serialVersionUID = -850112384085626659L;
	
	@Column(name="pnombre", nullable=false, length=20)
	private String pNombre;
	
	@Column(name="snombre", nullable=false, length=20)
	private String sNombre;
	
	@Column(name="papellido", nullable=false, length=20)
	private String pApellido;
	
	@Column(name="sapellido", nullable=false, length=20)
	private String sApellido;
	
	@Column(name="telefono", nullable=false, length=20)
	private String telefono;
	
	@Column(name="direccion", nullable=false, length=20)
	private String direccion;
	
	public String getpNombre() {
		return pNombre;
	}
	public void setpNombre(String pNombre) {
		this.pNombre = pNombre;
	}
	public String getsNombre() {
		return sNombre;
	}
	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}
	public String getpApellido() {
		return pApellido;
	}
	public void setpApellido(String pApellido) {
		this.pApellido = pApellido;
	}
	public String getsApellido() {
		return sApellido;
	}
	public void setsApellido(String sApellido) {
		this.sApellido = sApellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
}
