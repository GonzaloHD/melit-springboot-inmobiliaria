package es.melit.melitspringbootinmobiliaria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.melit.melitspringbootinmobiliaria.bussiness.ClienteService;
import es.melit.melitspringbootinmobiliaria.entities.Cliente;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {

	private ClienteService gestionClientes;
	
	@Autowired
	public ClienteController (ClienteService gestionClientes) {
		this.gestionClientes = gestionClientes;
	}
	
	@GetMapping
	public List<Cliente> getClientes(){
		 return gestionClientes.listado();
	 }	
	
	@GetMapping("/{id}")
	public Cliente find(@PathVariable Integer id) {
		return gestionClientes.buscar(id);
	}
	
	@PostMapping(consumes = "application/json")
	public void registerClientes(@RequestBody Cliente cliente) {
		gestionClientes.guardar(cliente);
	}
}
