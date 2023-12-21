package es.melit.melitspringbootinmobiliaria.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Publicacion implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_publicacion")
	private Integer idPublicacion;
	
	@ManyToOne
	@JoinColumn(name = "fk_inmueble", nullable = false)
	@JsonIdentityReference(alwaysAsId = true)
	@JsonProperty("idInmueble")
	private Inmueble inmueble;
	
	private Instant fechaInicio;
	private Instant fechaFin;
	
	private Double coste;	

	public Publicacion() {
		super();
		
	}

	public Publicacion(Inmueble inmueble, Instant fechaInicio, Instant fechaFin, Double coste) {
		super();
		this.inmueble = inmueble;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.coste = coste;
	}

	public Integer getIdPublicacion() {
		return idPublicacion;
	}

	public void setIdPublicacion(Integer idPublicacion) {
		this.idPublicacion = idPublicacion;
	}

	public Inmueble getInmueble() {
		return inmueble;
	}

	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}

	public Instant getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Instant fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Instant getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Instant instant) {
		this.fechaFin = instant;
	}

	public Double getCoste() {
		return coste;
	}

	public void setCoste(Double coste) {
		this.coste = coste;
	}

	@Override
	public String toString() {
		return "Publicacion [idPublicacion=" + idPublicacion + ", inmueble=" + inmueble + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + ", coste=" + coste + "]";
	}
	
	
	
}
