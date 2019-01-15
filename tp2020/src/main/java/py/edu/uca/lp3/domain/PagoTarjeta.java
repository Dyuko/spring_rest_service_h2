package py.edu.uca.lp3.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable 
public class PagoTarjeta implements Serializable, FormaPago {
	private static final long serialVersionUID = 4015667229771155221L;
	
	private Double debito;
	private String numeroTarjeta;
	
	public Double getDebito() {
		return debito;
	}
	public void setDebito(Double debito) {
		this.debito = debito;
	}
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
