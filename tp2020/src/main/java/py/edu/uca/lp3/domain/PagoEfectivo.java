package py.edu.uca.lp3.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable 
public class PagoEfectivo implements Serializable, FormaPago{
	private static final long serialVersionUID = -3022426933860244597L;
	
	private Double efectivo;
	
	public Double getEfectivo() {
		return efectivo;
	}
	public void setEfectivo(Double efectivo) {
		this.efectivo = efectivo;
	}
}
