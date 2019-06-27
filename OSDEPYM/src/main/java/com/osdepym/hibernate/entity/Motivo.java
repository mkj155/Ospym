package com.osdepym.hibernate.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="MOTIVOS", schema = "tramites_online")
public class Motivo {
	
	public Motivo() {}
	
	public Motivo(String etiqueta) {
		this.etiqueta = etiqueta;
	}
	
	public Motivo(String etiqueta, Set<MotivoCategoria> motivoCategorias) {
		this.etiqueta = etiqueta;
		this.motivoCategorias = motivoCategorias;
	}
	
	private Long idMotivo;
	private String etiqueta;
	private Set<MotivoCategoria> motivoCategorias;
    
	@Id
	@Column(name="ID_MOTIVO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdMotivo() {
		return idMotivo;
	}

	public void setIdMotivo(Long idMotivo) {
		this.idMotivo = idMotivo;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	@OneToMany(mappedBy = "motivo")
	public Set<MotivoCategoria> getMotivoCategorias() {
		return motivoCategorias;
	}

	public void setMotivoCategorias(Set<MotivoCategoria> motivoCategorias) {
		this.motivoCategorias = motivoCategorias;
	}
	
	public void addMotivoCategoria(MotivoCategoria motivoCategoria) {
		this.motivoCategorias.add(motivoCategoria);
	}
	
}
