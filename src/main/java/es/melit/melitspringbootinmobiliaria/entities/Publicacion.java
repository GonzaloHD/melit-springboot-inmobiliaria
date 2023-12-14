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
public class Publicacion implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_publicacion")
	private Integer idPublicacion;
	
	@ManyToOne
	@JoinColumn(name = "fk_inmueble", nullable = false)
	private Inmueble inmueble;

	public Integer getIdPublicacion() {
		return idPublicacion;
	}

	public void setIdPublicacion(Integer idPublicacion) {
		this.idPublicacion = idPublicacion;
	}
	
	
	
}
