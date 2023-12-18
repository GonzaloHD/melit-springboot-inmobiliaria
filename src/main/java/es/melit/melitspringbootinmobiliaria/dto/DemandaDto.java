package es.melit.melitspringbootinmobiliaria.dto;

public class DemandaDto {
	
	private Integer idDemanda;
	private String descripcion;
	private Integer idCliente;	
	private String localidad;
	private Integer numHabitaciones;
	private String tipoVivienda;
	
	public DemandaDto() {
		super();
	}
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
	
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public Integer getNumHabitaciones() {
		return numHabitaciones;
	}
	public void setNumHabitaciones(Integer numHabitaciones) {
		this.numHabitaciones = numHabitaciones;
	}
	public String getTipoVivienda() {
		return tipoVivienda;
	}
	public void setTipoVivienda(String tipoVivienda) {
		this.tipoVivienda = tipoVivienda;
	}
	@Override
	public String toString() {
		return "DemandaDto [idDemanda=" + idDemanda + ", descripcion=" + descripcion + ", idCliente=" + idCliente + "]";
	}
	
	

}
