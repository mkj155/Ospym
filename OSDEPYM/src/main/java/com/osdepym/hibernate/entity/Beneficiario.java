package com.osdepym.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
public class Beneficiario {
	
	@Id
	@Column(name = "id_Afiliado", updatable = false, nullable = false)
	private Long idAfiliado;
	
	@Column(name = "id_Titular", updatable = false)
	private Long idTitular;
	
	@Column(name = "Apellido", updatable = false)
	private String apellido;
	
	@Column(name = "Nombre", updatable = false)
	private String nombre;
	
	public Long getIdAfiliado() {
		return idAfiliado;
	}

	public void setIdAfiliado(Long idAfiliado) {
		this.idAfiliado = idAfiliado;
	}

	public Long getIdTitular() {
		return idTitular;
	}

	public void setIdTitular(Long idTitular) {
		this.idTitular = idTitular;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Beneficiario() {}	
}