package es.melit.melitspringbootinmobiliaria.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idDemanda")
public class Demanda implements Serializable {	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_demanda")
	private Integer idDemanda;
	private String descripcion;
	private String localidad;
	private Integer numHabitaciones;
	private String tipoVivienda;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_cliente", nullable = false)
	@JsonIdentityReference(alwaysAsId = true)
	@JsonProperty("idCliente")
	private Cliente cliente;
	@OneToOne(mappedBy = "demanda", fetch = FetchType.LAZY)
	@JsonIgnore
	private Transaccion transaccion;
	
	public Demanda() {
		super();
	}
	public Demanda(String descripcion, String localidad, Integer numHabitaciones, String tipoVivienda ,Cliente cliente) {
		super();
		this.descripcion = descripcion;
		this.localidad = localidad;
		this.numHabitaciones = numHabitaciones;
		this.tipoVivienda = tipoVivienda;
		this.cliente = cliente;		
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
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Transaccion getTransaccion() {
		return transaccion;
	}
	public void setTransaccion(Transaccion transaccion) {
		this.transaccion = transaccion;
	}
	@Override
	public String toString() {
		return "Demanda [idDemanda=" + idDemanda + ", descripcion=" + descripcion + ", cliente=" + cliente
				+ ", transaccion=" + transaccion + "]";
	}	
	
	
}
