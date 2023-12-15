package es.melit.melitspringbootinmobiliaria.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

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
	@JsonIgnore
	private String tipoVivienda;
	private int numHabitaciones;
	private boolean activo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_cliente", nullable = false)	
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_empleado")
	private Empleado empleado;
	
	@OneToMany(mappedBy = "inmueble")
	private List<Publicacion> publicaciones;
	
	@OneToOne(mappedBy = "inmueble")
	private Transaccion transaccion;	
	
	public Inmueble() {
		super();
	}
	public Inmueble(String descripcion, String direccion, String localidad, String tipoVivienda, int numHabitaciones,
			boolean activo) {
		super();
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.localidad = localidad;
		this.tipoVivienda = tipoVivienda;
		this.numHabitaciones = numHabitaciones;
		this.activo = activo;
	}
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
