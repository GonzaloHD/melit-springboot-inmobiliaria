package es.melit.melitspringbootinmobiliaria.dto;

public class DemandaDto {
	
	private Integer idDemanda;
	private String descripcion;
	private Integer idCliente;
	public DemandaDto(Integer idDemanda, String descripcion, Integer idCliente) {
		super();
		this.idDemanda = idDemanda;
		this.descripcion = descripcion;
		this.idCliente = idCliente;
	}
	public Integer getIdDemanda() {
		return idDemanda;
	}
	public void setIdDemanda(Integer idDemanda) {
		this.idDemanda = idDemanda;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	@Override
	public String toString() {
		return "DemandaDto [idDemanda=" + idDemanda + ", descripcion=" + descripcion + ", idCliente=" + idCliente + "]";
	}
	
	

}
