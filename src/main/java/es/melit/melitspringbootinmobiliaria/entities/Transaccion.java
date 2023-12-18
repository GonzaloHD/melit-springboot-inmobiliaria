package es.melit.melitspringbootinmobiliaria.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Transaccion implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_transaccion")
	private Integer idTransaccion;
	@Temporal(TemporalType.DATE)
	private Date fecha;
	private String comentario;
	
	@OneToOne
	@JoinColumn(name = "fk_inmueble", nullable = false)
	private Inmueble inmueble;
	
	@OneToOne
	@JoinColumn(name = "fk_demanda", nullable = false)
	private Demanda demanda;	
	
	public Transaccion() {
		super();
	}
	public Transaccion(Date fecha, String comentario, Inmueble inmueble, Demanda demanda) {
		super();
		this.fecha = fecha;
		this.comentario = comentario;
		this.inmueble = inmueble;
		this.demanda = demanda;
	}
	public Integer getIdTransaccion() {
		return idTransaccion;
	}
	public void setIdTransaccion(Integer idTransaccion) {
		this.idTransaccion = idTransaccion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
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
	@Override
	public String toString() {
		return "Transaccion [idTransaccion=" + idTransaccion + ", fecha=" + fecha + ", inmueble=" + inmueble
				+ ", demanda=" + demanda + "]";
	}
	
	
	
	
	
	
}
