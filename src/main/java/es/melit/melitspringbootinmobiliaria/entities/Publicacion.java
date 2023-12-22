package es.melit.melitspringbootinmobiliaria.entities;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

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
	
	@Column(nullable = false)
	private Double costeDiario;
	
	@Column(nullable = true)
	private Double ingresoFinalPublicacion;
	
	@Transient
	private double ingresoActualPublicación;

	public Publicacion() {
		super();		
	}

	public Publicacion(Inmueble inmueble, Instant fechaInicio, Double coste) {
		super();
		this.inmueble = inmueble;
		this.fechaInicio = fechaInicio;
		this.costeDiario = coste;
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

	public void setFechaFin(Instant fechaFin) {
		this.fechaFin = fechaFin;
		this.ingresoFinalPublicacion = Math.round((100.00*(double)Duration.between(this.fechaInicio, fechaFin).toSeconds()/86400.00)*(this.costeDiario))/100.00;
	}

	public Double getCosteDiario() {
		return costeDiario;
	}

	public void setCosteDiario(Double costeDiario) {
		this.costeDiario = costeDiario;
	}

	public Double getIngresoFinalPublicacion() {
		return ingresoFinalPublicacion;
	}

	public void setIngresoFinalPublicacion(Double ingresoFinalPublicacion) {
		this.ingresoFinalPublicacion = ingresoFinalPublicacion;
	}

	public double getIngresoActualPublicación() {
		return this.ingresoActualPublicación = Math.round(((double)Duration.between(this.fechaInicio, Instant.now()).toSeconds()/86400.00)*(this.costeDiario)*100.00)/100.00;
	}


	public void setIngresoActualPublicación(double ingresoActualPublicación) {
		this.ingresoActualPublicación = ingresoActualPublicación;
	}

	@Override
	public String toString() {
		return "Publicacion [idPublicacion=" + idPublicacion + ", inmueble=" + inmueble + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + ", coste=" + costeDiario + "]";
	}	
	
}
