package com.osdepym.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ESPEC_PREST", schema = "tramites_online")
public class EspecialidadPrestacion{
	
	
	private Long idEspecPrest;
	private Especialidad especialidad;
	private Prestacion prestacion;
	private String correo;
    
	public EspecialidadPrestacion(String correo) {
        this.correo = correo;
    }

	public EspecialidadPrestacion() {}
	
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Id
	@Column(name="ID_ESPEC_PREST")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdEspecPrest() {
		return idEspecPrest;
	}

	public void setIdEspecPrest(Long idEspecPrest) {
		this.idEspecPrest = idEspecPrest;
	}
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_ESPECIALIDAD")  
	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_PRESTACION")  
	public Prestacion getPrestacion() {
		return prestacion;
	}

	public void setPrestacion(Prestacion prestacion) {
		this.prestacion = prestacion;
	}
	
}
