package com.osdepym.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PROFESORES")
public class Profesores {

	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "PROFESORESCURSOS", 
        joinColumns = @JoinColumn(name = "IDPROFESOR"), 
        inverseJoinColumns = @JoinColumn(name = "IDCURSO")
    ) 
	Set<Cursos> cursos = new HashSet<Cursos>();
	
	@Id
	@Column(name="IDPROFESOR")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProfesor;
	
	private String nombre;

	private String apellido;
	
	private String direccion;
	
	private String ciudad;

	public Set<Cursos> getCursos() {
		return cursos;
	}

	public void setCursos(Set<Cursos> cursos) {
		this.cursos = cursos;
	}

	public int getIdPersona() {
		return idProfesor;
	}

	public void setIdPersona(int idProfesor) {
		this.idProfesor = idProfesor;
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

}
