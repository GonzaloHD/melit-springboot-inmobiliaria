package es.melit.melitspringbootinmobiliaria.dto;

import java.util.Date;

public class TransaccionDto {
	
	private Integer idTransaccion;
	private Date fecha;
	private String comentario;
	private Integer idDemanda;
	private Integer idInmueble;
	private Integer idEmpleado;
	
	public TransaccionDto() {
		super();
	}

	public TransaccionDto(Integer idTransaccion, Date fecha, String comentario, Integer idDemanda, Integer idInmueble, Integer idEmpleado) {
		super();
		this.idTransaccion = idTransaccion;
		this.fecha = fecha;
		this.comentario = comentario;
		this.idDemanda = idDemanda;
		this.idInmueble = idInmueble;
		this.idEmpleado = idEmpleado;
	}

	public Integer getIdTransaccion() {
		return idTransaccion;
	}
	public void setIdTransaccion(Integer idTransaccion) {
		this.idTransaccion = idTransaccion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Integer getIdDemanda() {
		return idDemanda;
	}
	public void setIdDemanda(Integer idDemanda) {
		this.idDemanda = idDemanda;
	}
	public Integer getIdInmueble() {
		return idInmueble;
	}
	public void setIdInmueble(Integer idInmueble) {
		this.idInmueble = idInmueble;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	@Override
	public String toString() {
		return "TransaccionDto [idTransaccion=" + idTransaccion + ", fecha=" + fecha + ", comentario=" + comentario
				+ ", idDemanda=" + idDemanda + ", idInmueble=" + idInmueble + ", idEmpleado=" + idEmpleado + "]";
	}	
	
}
