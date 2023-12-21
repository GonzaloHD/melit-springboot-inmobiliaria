package es.melit.melitspringbootinmobiliaria.dto;

public class InmuebleDto {
	
	private Integer idInmueble;
	private String descripcion;
	private String direccion;
	private String localidad;	
	private String tipoVivienda;
	private Integer numHabitaciones;
	private boolean activo;
	private Integer idCliente;
	private Integer idEmpleado;
	private Integer noUseful;
	
	public InmuebleDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InmuebleDto(Integer idInmuble, String descripcion, String direccion, String localidad, String tipoVivienda,
			Integer numHabitaciones, boolean activo, Integer idCliente, Integer idEmpleado) {
		super();
		this.idInmueble = idInmuble;
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.localidad = localidad;
		this.tipoVivienda = tipoVivienda;
		this.numHabitaciones = numHabitaciones;
		this.activo = activo;
		this.idCliente = idCliente;
		this.idEmpleado = idEmpleado;
	}

	public Integer getIdInmueble() {
		return idInmueble;
	}

	public void setIdInmuble(Integer idInmuble) {
		this.idInmueble = idInmuble;
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

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	@Override
	public String toString() {
		return "InmuebleDto [idInmuble=" + idInmueble + ", descripcion=" + descripcion + ", direccion=" + direccion
				+ ", localidad=" + localidad + ", tipoVivienda=" + tipoVivienda + ", numHabitaciones=" + numHabitaciones
				+ ", activo=" + activo + ", idCliente=" + idCliente + ", idEmpleado=" + idEmpleado + "]";
	}
	
	
	
	

	
}
