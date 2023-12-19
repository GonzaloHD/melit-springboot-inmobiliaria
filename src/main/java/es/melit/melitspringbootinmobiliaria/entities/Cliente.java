package es.melit.melitspringbootinmobiliaria.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@SuppressWarnings("serial")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idCliente")
@Entity
public class Cliente implements Serializable {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Integer idCliente;
	private String nif;
	private String nombre;
	private String apellidos;
	private String direccion;
	private String email;
	private String telefono;	
	
	
	public Cliente() {
		super();
	}
	public Cliente(String nif, String nombre, String apellidos, String direccion, String email, String telefono) {
		super();
		this.nif = nif;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;

	}
	@OneToMany(mappedBy = "cliente")
	private List<Inmueble> inmuebles;
	
	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
	private List<Demanda> demandas;
	
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
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
		return "Cliente [idCliente=" + idCliente + ", nif=" + nif + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", direccion=" + direccion + ", email=" + email + ", telefono=" + telefono + ", inmuebles="
				+ inmuebles + ", demandas=" + demandas + "]";
	}
	
	
	

}
