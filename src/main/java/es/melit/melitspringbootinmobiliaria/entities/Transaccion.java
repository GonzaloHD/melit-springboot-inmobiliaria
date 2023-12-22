package es.melit.melitspringbootinmobiliaria.entities;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class Transaccion implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_transaccion")
	private Integer idTransaccion;
	private Instant fecha;	
	private String comentario;
	private Double precioFinal;
	
	@JsonIdentityReference(alwaysAsId = true)
	@JsonProperty("idInmueble")	
	@OneToOne
	@JoinColumn(name = "fk_inmueble",  nullable = false)
	private Inmueble inmueble;
	
	@JsonIdentityReference(alwaysAsId = true)
	@JsonProperty("idDemanda")	
	@ManyToOne
	@JoinColumn(name = "fk_demanda", nullable = false)
	private Demanda demanda;
	
	@JsonIdentityReference(alwaysAsId = true)
	@JsonProperty("idEmpleado")	
	@ManyToOne
	@JoinColumn(name = "fk_empleado",  nullable = false)
	private Empleado empleado;
	
	public Transaccion() {
		super();
	}

	public Transaccion(String comentario, Inmueble inmueble, Demanda demanda, Empleado empleado) {

		super();
		this.fecha = Instant.now();
		this.comentario = comentario;
		this.inmueble = inmueble;
		this.demanda = demanda;
		this.empleado = empleado;
		this.precioFinal = inmueble.getPrecio() + (inmueble.getPrecio() *0.13);
	}
	public Integer getIdTransaccion() {
		return idTransaccion;
	}
	public void setIdTransaccion(Integer idTransaccion) {
		this.idTransaccion = idTransaccion;
	}
	public Instant getFecha() {
		return fecha;
	}
	public void setFecha(Instant fecha) {
		this.fecha = fecha;
	}	
	
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Inmueble getInmueble() {
		return inmueble;
	}
	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}
	public Demanda getDemanda() {
		return demanda;
	}
	public void setDemanda(Demanda demanda) {
		this.demanda = demanda;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	public Double getPrecioFinal() {
		return precioFinal;
	}
	public void setPrecioFinal(Double precioFinal) {
		this.precioFinal = precioFinal;
	}

	@Override
	public String toString() {
		return "Transaccion [idTransaccion=" + idTransaccion + ", fecha=" + fecha
				+ ", comentario=" + comentario + ", precioFinal=" + precioFinal + " , inmueble=" + inmueble + ", demanda=" + demanda + ", empleado="
				+ empleado + "]";
	}		
	
}
