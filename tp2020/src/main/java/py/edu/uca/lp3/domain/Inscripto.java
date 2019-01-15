package py.edu.uca.lp3.domain;

import javax.persistence.Entity;

@Entity
public class Inscripto extends Persona {
	private static final long serialVersionUID = -7100049613620155212L;
	
	private Long idEvento; //Relacion

	public Long getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}

}
