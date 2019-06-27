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
@Table(name="MOTIVOS_CATEGORIAS", schema = "tramites_online")
public class MotivoCategoria implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -166959304805302504L;
	
	private Long idMotCat;
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
	@Column(name="ID_MOT_CAT")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdMotCat() {
		return idMotCat;
	}

	public void setIdMotCat(Long idMotCat) {
		this.idMotCat = idMotCat;
	}
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_MOTIVO")  
	public Motivo getMotivo() {
		return motivo;
	}

	public void setMotivo(Motivo motivo) {
		this.motivo = motivo;
	}

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CATEGORIA")  
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}
