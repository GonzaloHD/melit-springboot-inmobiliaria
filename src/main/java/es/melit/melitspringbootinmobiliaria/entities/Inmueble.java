package es.melit.melitspringbootinmobiliaria.entities;

import java.io.Serializable;
import java.util.List;

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
	private Integer numHabitaciones;
	private boolean activo;
	private String comentarioEstado;
	private Double precio;
	private Double metrosCuadrados;
	
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
	@JsonIgnore
	private List<Publicacion> publicaciones;
	
	@OneToOne(mappedBy = "inmueble")
	@JsonIgnore
	private Transaccion transaccion;	
	
	public Inmueble() {
		super();
	}
		public Inmueble(String descripcion, String direccion, String localidad, String tipoVivienda, Integer numHabitaciones,
			boolean activo, Cliente cliente, Empleado empleado, Double precio, Double metrosCuadrados) {
		super();
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.localidad = localidad;
		this.tipoVivienda = tipoVivienda;
		this.numHabitaciones = numHabitaciones;
		this.activo = activo;
		this.cliente = cliente;
		this.empleado = empleado;
		this.precio = precio;
		this.metrosCuadrados = metrosCuadrados;
		}
		
	public Integer getIdInmueble() {
		return idInmueble;
	}
	public void setIdInmueble(Integer idInmueble) {
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
	public Integer getNumHabitaciones() {
//		return numHabitaciones != null ? numHabitaciones.intValue() : 0;
		return numHabitaciones;
	}
	public void setNumHabitaciones(Integer numHabitaciones) {
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
		
	public String getComentarioEstado() {
		return comentarioEstado;
	}
	public void setComentarioEstado(String comentario) {
		this.comentarioEstado = comentario;
	}
	
	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	public Double getMetrosCuadrados() {
		return metrosCuadrados;
	}
	public void setMetrosCuadrados(Double metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}
	@Override
	public String toString() {
		return "Inmueble [idInmueble=" + idInmueble + ", descripcion=" + descripcion + ", direccion=" + direccion
				+ ", localidad=" + localidad + ", tipoVivienda=" + tipoVivienda + ", numHabitaciones=" + numHabitaciones
				+ ", activo=" + activo + ", cliente=" + cliente + ", empleado=" + empleado + ", publicaciones="
				+ publicaciones + ", transaccion=" + transaccion + ", comentarioEstado=" + comentarioEstado + ", precio=" + precio + " , metrosCuadrados" + metrosCuadrados + " ]";
	}	
	

}
