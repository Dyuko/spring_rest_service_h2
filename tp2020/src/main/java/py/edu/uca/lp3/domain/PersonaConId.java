package py.edu.uca.lp3.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class PersonaConId implements Serializable {
	private static final long serialVersionUID = 7983658832524935032L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idExpositor;
	private String documentoIdentidad;
	private String nombre;
	private String apellido;
	private String numeroTelefono;
	private String fechaNacimiento;
	private String direccionCorreo;
	public Long getIdExpositor() {
		return idExpositor;
	}
	public void setIdExpositor(Long idExpositor) {
		this.idExpositor = idExpositor;
	}
	public String getDocumentoIdentidad() {
		return documentoIdentidad;
	}
	public void setDocumentoIdentidad(String documentoIdentidad) {
		this.documentoIdentidad = documentoIdentidad;
	}
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
	public String getNumeroTelefono() {
		return numeroTelefono;
	}
	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getDireccionCorreo() {
		return direccionCorreo;
	}
	public void setDireccionCorreo(String direccionCorreo) {
		this.direccionCorreo = direccionCorreo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
