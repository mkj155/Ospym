package com.osdepym.dto;

import java.io.Serializable;
import java.util.List;


public class PersonaDTO implements Serializable{
	
	private static final long serialVersionUID = -7939595527637867540L;

	private Integer id;
	
	private String nombre;

	private String apellido;
	
	private String direccion;
	
	private String ciudad;
	
	private String fechaNacimiento;
	
	private int nroCliente;
	
	private List<String> hijos;
	
	private String curso;
	
	private Boolean vegetariano;
	
	private String sexo;
	
	public boolean isNew() {
		return (this.id == null);
	}

	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getNroCliente() {
		return nroCliente;
	}

	public void setNroCliente(int nroCliente) {
		this.nroCliente = nroCliente;
	}

	public void setHijos(List<String> hijos) {
		this.hijos = hijos;
	}
	
	public List<String> getHijos() {
		return hijos;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Boolean getVegetariano() {
		return vegetariano;
	}

	public void setVegetariano(Boolean vegetariano) {
		this.vegetariano = vegetariano;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
}
