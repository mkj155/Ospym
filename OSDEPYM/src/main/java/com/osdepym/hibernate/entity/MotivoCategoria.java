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
@Table(name="MOTIVO_CATEGORIA")
public class MotivoCategoria implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -166959304805302504L;
	
	private int idMotCat;
	private Motivo motivo;
	private Categoria categoria;
	private String correo;
    
	public MotivoCategoria(String correo) {
        this.correo = correo;
    }

	public MotivoCategoria() {}
	
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Id
	@Column(name="IDMOTCAT")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdMotCat() {
		return idMotCat;
	}

	public void setIdMotCat(int idMotCat) {
		this.idMotCat = idMotCat;
	}
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDMOTIVO")  
	public Motivo getMotivo() {
		return motivo;
	}

	public void setMotivo(Motivo motivo) {
		this.motivo = motivo;
	}

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDCATEG")  
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}
