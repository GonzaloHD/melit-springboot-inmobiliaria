package es.melit.melitspringbootinmobiliaria.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Demanda implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_demanda")
	private Integer idDemanda;
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "fk_cliente", nullable = false)
	private Cliente cliente;
	
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
	
	
	
}
