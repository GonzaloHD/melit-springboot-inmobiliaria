package es.melit.melitspringbootinmobiliaria.dto;

import java.util.Date;

public class PublicacionDto {	
	private Integer idPublicacion;	
	private Double coste;
	private Date fechaInicio;
	private Date fechaFin;
	private Integer idInmueble;
	
	
	
	public PublicacionDto() {
		super();
	}



	public PublicacionDto(Double coste, Date fechaInicio, Date fechaFin, Integer idInmueble) {
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



	public Date getFechaInicio() {
		return fechaInicio;
	}



	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}



	public Date getFechaFin() {
		return fechaFin;
	}



	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}



	public Integer getIdInmueble() {
		return idInmueble;
	}



	public void setIdInmueble(Integer idInmueble) {
		this.idInmueble = idInmueble;
	}
	
	
	

}
