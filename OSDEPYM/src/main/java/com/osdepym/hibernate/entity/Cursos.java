package com.osdepym.hibernate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CURSOS")
public class Cursos {
	
    @ManyToMany(mappedBy = "cursos")
    private Set<Profesores> profesores = new HashSet<Profesores>();
    
	@Id
	@Column(name="IDCURSO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCurso;

	private String curso;

	public Set<Profesores> getProfesores() {
		return profesores;
	}

	public void setProfesoresSet(Set<Profesores> profesores) {
		this.profesores = profesores;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
	
}
