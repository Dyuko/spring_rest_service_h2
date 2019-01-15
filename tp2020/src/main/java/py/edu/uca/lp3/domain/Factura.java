package py.edu.uca.lp3.domain;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Factura implements Serializable {
	private static final long serialVersionUID = -3390215900674292716L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idFactura;
	private String nombre;
	private String apellido;
	private String RUC;
	private String fecha;
	@Embedded
	private PagoEfectivo pagoEfectivo;
	@Embedded
	private PagoTarjeta pagoTarjeta;
	private Long idEvento; //Relacion
	
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
	public String getRUC() {
		return RUC;
	}
	public void setRUC(String rUC) {
		RUC = rUC;
	}
	public Long getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(Long idFactura) {
		this.idFactura = idFactura;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public PagoEfectivo getPagoEfectivo() {
		return pagoEfectivo;
	}
	public void setPagoEfectivo(PagoEfectivo pagoEfectivo) {
		this.pagoEfectivo = pagoEfectivo;
	}
	public PagoTarjeta getPagoTarjeta() {
		return pagoTarjeta;
	}
	public void setPagoTarjeta(PagoTarjeta pagoTarjeta) {
		this.pagoTarjeta = pagoTarjeta;
	}
	public Long getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
