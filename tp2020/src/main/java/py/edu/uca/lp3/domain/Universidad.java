package py.edu.uca.lp3.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable 
public class Universidad implements Serializable {
	private static final long serialVersionUID = 8493472620376521049L;
	
	private String nombreUniversidad;
	private String numeroTelefonoUniversidad;
	public String getNombreUniversidad() {
		return nombreUniversidad;
	}
	public void setNombreUniversidad(String nombreUniversidad) {
		this.nombreUniversidad = nombreUniversidad;
	}
	public String getNumeroTelefonoUniversidad() {
		return numeroTelefonoUniversidad;
	}
	public void setNumeroTelefonoUniversidad(String numeroTelefonoUniversidad) {
		this.numeroTelefonoUniversidad = numeroTelefonoUniversidad;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
