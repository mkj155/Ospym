package com.osdepym.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PLAN_SECCIONES", schema = "tramites_online")
public class PlanSeccion {
	
	private int idPlanSeccion;
	private String titulo;
	private String subtitulo;
	
	public PlanSeccion(String titulo, String subtitulo) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
    }
	public PlanSeccion() {
    }
	
	@Id
	@Column(name="ID_PLAN_SECCION")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdPlanSeccion() {
		return idPlanSeccion;
	}
	public void setIdPlanSeccion(int idPlanSeccion) {
		this.idPlanSeccion = idPlanSeccion;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getSubtitulo() {
		return subtitulo;
	}
	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

}
