package es.melit.melitspringbootinmobiliaria.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idInmueble")
public class Inmueble implements Serializable {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_inmueble")
	private Integer idInmueble;
	private String descripcion;
	private String direccion;
	private String localidad;		
	private String tipoVivienda;
	private int numHabitaciones;
	private boolean activo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_cliente", nullable = false)
	@JsonIdentityReference(alwaysAsId = true)
	@JsonProperty("idCliente")
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_empleado")
	@JsonIdentityReference(alwaysAsId = true)
	@JsonProperty("idEmpleado")
	private Empleado empleado;
	
	@OneToMany(mappedBy = "inmueble")
	private List<Publicacion> publicaciones;
	
	@OneToOne(mappedBy = "inmueble")
	private Transaccion transaccion;	
	
	public Inmueble() {
		super();
	}
		public Inmueble(String descripcion, String direccion, String localidad, String tipoVivienda, int numHabitaciones,
			boolean activo, Cliente cliente, Empleado empleado) {
		super();
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.localidad = localidad;
		this.tipoVivienda = tipoVivienda;
		this.numHabitaciones = numHabitaciones;
		this.activo = activo;
		this.cliente = cliente;
		this.empleado = empleado;
	
	}
	public Integer getIdInmueble() {
		return idInmueble;
	}
	public void setIdInmuble(Integer idInmueble) {
		this.idInmueble = idInmueble;
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
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	@Override
	public String toString() {
		return "Inmueble [idInmueble=" + idInmueble + ", descripcion=" + descripcion + ", direccion=" + direccion
				+ ", localidad=" + localidad + ", tipoVivienda=" + tipoVivienda + ", numHabitaciones=" + numHabitaciones
				+ ", activo=" + activo + ", cliente=" + cliente + ", empleado=" + empleado + ", publicaciones="
				+ publicaciones + ", transaccion=" + transaccion + "]";
	}
	
	
	
	
	

}
