package com.osdepym.hibernate.entity;

import java.io.Serializable;

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
@Table(name="PLAN_ITEMS", schema = "tramites_online")
public class PlanItem{
	

	private int idPlanItem;
	private PlanSeccion seccion;
	private PlanItem itemPadre;
	private String titulo;
	private String valor;
	private String idPlan;
	
	@Id
	@Column(name="ID_PLAN_ITEM")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdPlanItem() {
		return idPlanItem;
	}
	public void setIdPlanItem(int idPlanItem) {
		this.idPlanItem = idPlanItem;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_PLAN_SECCION")
	public PlanSeccion getSeccion() {
		return seccion;
	}
	public void setSeccion(PlanSeccion seccion) {
		this.seccion = seccion;
	}
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_ITEM_PADRE")
	public PlanItem getItemPadre() {
		return itemPadre;
	}
	public void setItemPadre(PlanItem itemPadre) {
		this.itemPadre = itemPadre;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	@Column(name="ID_PLAN")
	public String getIdPlan() {
		return idPlan;
	}
	public void setIdPlan(String idPlan) {
		this.idPlan = idPlan;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
