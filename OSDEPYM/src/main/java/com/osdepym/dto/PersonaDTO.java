package com.osdepym.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.osdepym.hibernate.entity.Hijos;


public class PersonaDTO implements Serializable{
	
	private static final long serialVersionUID = -7939595527637867540L;

	private Set<Hijos> hijos;
	
	private Integer id;

	@NotNull
    @Size(min=5, max=20)
	private String nombre;

	@NotNull
    @Size(min=5, max=20)
	private String apellido;
	
	@Size(min=5, max=20)
	private String direccion;
	
	@Size(min=5, max=20)
	private String ciudad;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaNacimiento;
	
	private int nroCliente;
	
	private boolean vegetariano;
	
	private String curso;
	
	private String sexo;
	
	public Set<Hijos> getHijos() {
		return hijos;
	}

	public void setHijos(Set<Hijos> hijos) {
		this.hijos = hijos;
	}
	
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

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getNroCliente() {
		return nroCliente;
	}

	public void setNroCliente(int nroCliente) {
		this.nroCliente = nroCliente;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public boolean isVegetariano() {
		return vegetariano;
	}

	public void setVegetariano(boolean vegetariano) {
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
