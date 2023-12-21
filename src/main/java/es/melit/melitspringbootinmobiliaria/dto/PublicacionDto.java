package es.melit.melitspringbootinmobiliaria.dto;

import java.time.Instant;
import java.util.Date;

public class PublicacionDto {	
	private Integer idPublicacion;	
	private Double coste;
	private Instant fechaInicio;
	private Instant fechaFin;
	private Integer idInmueble;
	
	
	
	public PublicacionDto() {
		super();
	}



	public PublicacionDto(Double coste, Instant fechaInicio, Instant fechaFin, Integer idInmueble) {
		super();
		this.coste = coste;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.idInmueble = idInmueble;
	}



	public Integer getIdPublicacion() {
		return idPublicacion;
	}



	public void setIdPublicacion(Integer idPublicacion) {
		this.idPublicacion = idPublicacion;
	}



	public Double getCoste() {
		return coste;
	}



	public void setCoste(Double coste) {
		this.coste = coste;
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
	}



	public Integer getIdInmueble() {
		return idInmueble;
	}



	public void setIdInmueble(Integer idInmueble) {
		this.idInmueble = idInmueble;
	}
	
	
	

}
