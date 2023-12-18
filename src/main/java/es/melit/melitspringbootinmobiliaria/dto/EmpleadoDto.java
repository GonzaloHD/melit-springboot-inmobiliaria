package es.melit.melitspringbootinmobiliaria.dto;

public class EmpleadoDto {

	private Integer idEmpleado;
	private String nif;
	private String nombre;
	private String apellidos;
	private String direccion;
	private String email;
	private String telefono;
	public EmpleadoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmpleadoDto(Integer idEmpleado, String nif, String nombre, String apellidos, String direccion, String email,
			String telefono) {
		super();
		this.idEmpleado = idEmpleado;
		this.nif = nif;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
	}
	public Integer getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	@Override
	public String toString() {
		return "EmpleadoDto [idEmpleado=" + idEmpleado + ", nif=" + nif + ", nombre=" + nombre + ", apellidos="
				+ apellidos + ", direccion=" + direccion + ", email=" + email + ", telefono=" + telefono + "]";
	}
	
	
}
