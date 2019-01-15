package py.edu.uca.lp3.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable 
public class Facultad implements Serializable{
	private static final long serialVersionUID = -5249943064782037898L;
	
	private String nombreFacultad;

	public String getNombreFacultad() {
		return nombreFacultad;
	}

	public void setNombreFacultad(String nombreFacultad) {
		this.nombreFacultad = nombreFacultad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
