package py.edu.uca.lp3.domain;

import javax.persistence.Entity;

@Entity
public class EventoConCosto extends BaseEvento {
	private static final long serialVersionUID = -4594709766072956155L;
	
	private Double costo;

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}
	
}
 