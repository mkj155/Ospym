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
@Table(name="AUTORIZACIONES_DOC", schema = "tramites_online")
public class AutorizacionDoc implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8470252089407072942L;
	private Long idAutorizacionDoc;
	private EspecialidadPrestacion especialidadPrestacion;
	private String documentacion;
    
	public AutorizacionDoc() {}	
	
	public String getDocumentacion() {
		return documentacion;
	}

	public void setDocumentacion(String documentacion) {
		this.documentacion = documentacion;
	}

	@Id
	@Column(name="ID_AUTORIZACION_DOC")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdAutorizacionDoc() {
		return idAutorizacionDoc;
	}

	public void setIdAutorizacionDoc(Long idAutorizacionDoc) {
		this.idAutorizacionDoc = idAutorizacionDoc;
	}
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_ESPEC_PREST")  
	public EspecialidadPrestacion getEspecialidadPrestacion() {
		return especialidadPrestacion;
	}

	public void setEspecialidadPrestacion(EspecialidadPrestacion especialidadPrestacion) {
		this.especialidadPrestacion = especialidadPrestacion;
	}

}
