package py.edu.uca.lp3.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Charla implements Serializable {
	private static final long serialVersionUID = -3895580431993259580L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idCharla;
	private String descripcion;
	private String fechaRealizacion;
	private String horaRealizacion;
	private Double duracionHora;
	private Long idEvento; // Relacion
	private Long idExpositor; // Relacion
	public Long getIdCharla() {
		return idCharla;
	}
	public void setIdCharla(Long idCharla) {
		this.idCharla = idCharla;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFechaRealizacion() {
		return fechaRealizacion;
	}
	public void setFechaRealizacion(String fechaRealizacion) {
		this.fechaRealizacion = fechaRealizacion;
	}
	public String getHoraRealizacion() {
		return horaRealizacion;
	}
	public void setHoraRealizacion(String horaRealizacion) {
		this.horaRealizacion = horaRealizacion;
	}
	public Double getDuracionHora() {
		return duracionHora;
	}
	public void setDuracionHora(Double duracionHora) {
		this.duracionHora = duracionHora;
	}
	public Long getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}
	public Long getIdExpositor() {
		return idExpositor;
	}
	public void setIdExpositor(Long idExpositor) {
		this.idExpositor = idExpositor;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
