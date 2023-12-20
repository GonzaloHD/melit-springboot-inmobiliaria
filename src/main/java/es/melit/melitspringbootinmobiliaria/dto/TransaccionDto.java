package es.melit.melitspringbootinmobiliaria.dto;

public class TransaccionDto {
	
	private Integer idTransaccion;
	private String comentario;
	private Integer idDemanda;
	private Integer idInmueble;	
	
	public TransaccionDto() {
		super();
	}

	public TransaccionDto(Integer idTransaccion, String comentario, Integer idDemanda, Integer idInmueble) {
		super();
		this.idTransaccion = idTransaccion;
		this.comentario = comentario;
		this.idDemanda = idDemanda;
		this.idInmueble = idInmueble;
	}

	public Integer getIdTransaccion() {
		return idTransaccion;
	}
	public void setIdTransaccion(Integer idTransaccion) {
		this.idTransaccion = idTransaccion;
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

	@Override
	public String toString() {
		return "TransaccionDto [idTransaccion=" + idTransaccion +  ", comentario=" + comentario
				+ ", idDemanda=" + idDemanda + ", idInmueble=" + idInmueble + "]";
	}
	
	
}
