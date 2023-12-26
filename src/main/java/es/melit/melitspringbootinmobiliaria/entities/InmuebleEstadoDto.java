package es.melit.melitspringbootinmobiliaria.entities;

public class InmuebleEstadoDto {
	
	private Integer id;
	private String comentario;
	private Boolean estado;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	

}
