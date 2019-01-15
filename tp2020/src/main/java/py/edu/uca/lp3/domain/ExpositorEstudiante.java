package py.edu.uca.lp3.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class ExpositorEstudiante extends PersonaConId{
	private static final long serialVersionUID = 7520840751759581737L;
	@Embedded
	private Universidad universidad;
	@Embedded
	private Facultad facultad;
	
	public Universidad getUniversidad() {
		return universidad;
	}
	public void setUniversidad(Universidad universidad) {
		this.universidad = universidad;
	}
	public Facultad getFacultad() {
		return facultad;
	}
	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
