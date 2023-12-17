package es.melit.melitspringbootinmobiliaria.dto;

public class InmuebleDto {
	
	private Integer idInmuble;
	private String descripcion;
	private String direccion;
	private String localidad;	
	private String tipoVivienda;
	private int numHabitaciones;
	private boolean activo;
	private Integer idCliente;
	private Integer idEmpleado;
	
	public InmuebleDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InmuebleDto(Integer idInmuble, String descripcion, String direccion, String localidad, String tipoVivienda,
			int numHabitaciones, boolean activo, Integer idCliente, Integer idEmpleado) {
		super();
		this.idInmuble = idInmuble;
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.localidad = localidad;
		this.tipoVivienda = tipoVivienda;
		this.numHabitaciones = numHabitaciones;
		this.activo = activo;
		this.idCliente = idCliente;
		this.idEmpleado = idEmpleado;
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
		return "InmuebleDto [idInmuble=" + idInmuble + ", descripcion=" + descripcion + ", direccion=" + direccion
				+ ", localidad=" + localidad + ", tipoVivienda=" + tipoVivienda + ", numHabitaciones=" + numHabitaciones
				+ ", activo=" + activo + ", idCliente=" + idCliente + ", idEmpleado=" + idEmpleado + "]";
	}
	
	
	
	

	
}
