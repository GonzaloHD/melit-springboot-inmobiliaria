package es.melit.melitspringbootinmobiliaria.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Inmueble implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_inmueble")
	private Integer idInmuble;
	private String descripcion;
	private String direccion;
	private String localidad;
	private String tipoVivienda;
	private int numHabitaciones;
	private boolean activo;
	
	
	
	public Integer getIdInmuble() {
		return idInmuble;
	}
	public void setIdInmuble(Integer idInmuble) {
		this.idInmuble = idInmuble;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getTipoVivienda() {
		return tipoVivienda;
	}
	public void setTipoVivienda(String tipoVivienda) {
		this.tipoVivienda = tipoVivienda;
	}
	public int getNumHabitaciones() {
		return numHabitaciones;
	}
	public void setNumHabitaciones(int numHabitaciones) {
		this.numHabitaciones = numHabitaciones;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
	
	
	

}
