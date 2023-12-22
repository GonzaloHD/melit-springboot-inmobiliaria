package es.melit.melitspringbootinmobiliaria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.melit.melitspringbootinmobiliaria.bussiness.ClienteService;
import es.melit.melitspringbootinmobiliaria.entities.Cliente;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Gestion de clientes", description = "CRUD y funcionalidad de clientes")
@RequestMapping(path = "/clientes")
public class ClienteController {

	private ClienteService gestionClientes;
	
	@Autowired
	public ClienteController (ClienteService gestionClientes) {
		this.gestionClientes = gestionClientes;
	}
	@Operation(
			   summary = "Listar todos los clientes", 
			   description = "Método get para obtener listado completo de clientes")
	@GetMapping
	public List<Cliente> getClientes(){
		 return gestionClientes.listado();
	 }	
	
	@Operation(
			   summary = "Proporciona información de un cliente", 
			   description = "Encuentra y trae la información de un cliente a partir de un id enviado por path en la url")
	@GetMapping("/{id}")
	public Cliente getCliente(@PathVariable Integer id) {
		return gestionClientes.buscar(id);
	}
	
	@Operation(
			   summary = "Proporciona información de un cliente desconociendo su id", 
			   description = "Introducir nif del cliente para obtener sus datos mediante path en url")
	@GetMapping("/nif/{nif}")
	public Cliente getClienteByNif(@PathVariable String nif) {
		return gestionClientes.findByNif(nif);
	}
	
	@Operation(
			   summary = "Registrar un cliente", 
			   description = "Dar de alta un cliente introduciendo Nombre, Apellidos, Nif, Teléfono, Email y Dirección en un json")
	@PostMapping(consumes = "application/json")
	public void registerClientes(@RequestBody Cliente cliente) {
		gestionClientes.guardar(cliente);
	}
	
	@Operation(
			   summary = "Modificar un cliente", 
			   description = "Envío de json para modificar cliente a partir de su id")
	@PutMapping(consumes = "application/json")
	public void changeCliente(@RequestBody Cliente cliente) {		
		gestionClientes.actualizar(cliente);
	}	
	
	@Operation(
			   summary = "Eliminar un cliente", 
			   description = "Borra el registro de un cliente a partir de su id enviado en path de url")
	@DeleteMapping("/{id}")
	public void deleteCliente(@PathVariable Integer id) {
		gestionClientes.eliminar(id);
	}
	
}
