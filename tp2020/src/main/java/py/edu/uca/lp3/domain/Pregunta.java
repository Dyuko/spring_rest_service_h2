package py.edu.uca.lp3.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Pregunta implements Serializable {
	private static final long serialVersionUID = 5229204857742561855L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idPregunta;
	private String fechaEnvio;
	private String descripcion;
	private Integer VotosPositivos;
	private Integer VotosNegativos;
	private Boolean banderaComentario;
	private Long idCharla; //Relación
	public Long getIdPregunta() {
		return idPregunta;
	}
	public void setIdPregunta(Long idPregunta) {
		this.idPregunta = idPregunta;
	}
	public String getFechaEnvio() {
		return fechaEnvio;
	}
	public void setFechaEnvio(String fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getVotosPositivos() {
		return VotosPositivos;
	}
	public void setVotosPositivos(Integer votosPositivos) {
		VotosPositivos = votosPositivos;
	}
	public Integer getVotosNegativos() {
		return VotosNegativos;
	}
	public void setVotosNegativos(Integer votosNegativos) {
		VotosNegativos = votosNegativos;
	}
	public Boolean getBanderaComentario() {
		return banderaComentario;
	}
	public void setBanderaComentario(Boolean banderaComentario) {
		this.banderaComentario = banderaComentario;
	}
	public Long getIdCharla() {
		return idCharla;
	}
	public void setIdCharla(Long idCharla) {
		this.idCharla = idCharla;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void asignarVotoPositivo() {
		this.VotosPositivos= this.VotosPositivos+1;
	}
	public void asignarVotoNegativo() {
		this.VotosNegativos= this.VotosNegativos-1;
	}
}
