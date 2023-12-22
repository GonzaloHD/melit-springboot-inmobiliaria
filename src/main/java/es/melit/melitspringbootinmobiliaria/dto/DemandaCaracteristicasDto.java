package es.melit.melitspringbootinmobiliaria.dto;

public class DemandaCaracteristicasDto {
	
	private String localidad;
	private Integer numHabitaciones;
	private String tipoVivienda;
	
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

}
