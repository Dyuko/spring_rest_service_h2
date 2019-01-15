package py.edu.uca.lp3.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class ComentarioPregunta implements Serializable {
	private static final long serialVersionUID = 4251510578589242108L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idComentario;
	private String descripcion;
	private String fechaEnvio;
	private Long idPregunta; //Relación
	
	public Long getIdComentario() {
		return idComentario;
	}
	public void setIdComentario(Long idComentario) {
		this.idComentario = idComentario;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFechaEnvio() {
		return fechaEnvio;
	}
	public void setFechaEnvio(String fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}
	public Long getIdPregunta() {
		return idPregunta;
	}
	public void setIdPregunta(Long idPregunta) {
		this.idPregunta = idPregunta;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
