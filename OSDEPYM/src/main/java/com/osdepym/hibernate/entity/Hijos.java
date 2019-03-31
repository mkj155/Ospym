package hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="HIJOS")
public class Hijos {

	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="IDPERSONA",insertable=true,updatable=true)
    private Persona persona;

	@Id
	@Column(name="IDHIJO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idHijo;
	
	private String nombre;

	private String apellido;

	public int getIdHijo() {
		return idHijo;
	}

	public void setIdHijo(int idHijo) {
		this.idHijo = idHijo;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
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
	
}
