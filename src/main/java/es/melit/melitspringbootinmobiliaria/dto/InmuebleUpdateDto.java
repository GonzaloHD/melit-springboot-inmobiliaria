package es.melit.melitspringbootinmobiliaria.dto;

public class InmuebleUpdateDto {	

	private String descripcion;
	private String direccion;
	private String localidad;	
	private String tipoVivienda;
	private Integer numHabitaciones;
	private boolean activo;
	private Double precio;
	private Double metrosCuadrados;
	private Integer idCliente;
	private Integer idEmpleado;

	
	public InmuebleUpdateDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InmuebleUpdateDto(String descripcion, String direccion, String localidad, String tipoVivienda,
			Integer numHabitaciones, boolean activo, Double precio, Double metrosCuadrados, Integer idCliente, Integer idEmpleado) {
		super();
		
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.localidad = localidad;
		this.tipoVivienda = tipoVivienda;
		this.numHabitaciones = numHabitaciones;
		this.activo = activo;
		this.precio = precio;
		this.idCliente = idCliente;
		this.idEmpleado = idEmpleado;
		this.metrosCuadrados = metrosCuadrados;
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
		return "InmuebleDto [descripcion=" + descripcion + ", direccion=" + direccion
				+ ", localidad=" + localidad + ", tipoVivienda=" + tipoVivienda + ", numHabitaciones=" + numHabitaciones
				+ ", activo=" + activo + ", precio=" + precio + " , metrosCuadrados=" + metrosCuadrados + ", idCliente=" + idCliente + ", idEmpleado=" + idEmpleado + "]";
	}
	
	
	
	

	
}
