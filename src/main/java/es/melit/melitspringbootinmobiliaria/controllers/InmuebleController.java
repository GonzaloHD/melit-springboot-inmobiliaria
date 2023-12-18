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
import es.melit.melitspringbootinmobiliaria.bussiness.InmuebleService;
import es.melit.melitspringbootinmobiliaria.dto.InmuebleDto;
import es.melit.melitspringbootinmobiliaria.entities.Cliente;
import es.melit.melitspringbootinmobiliaria.entities.Inmueble;

@RestController

@RequestMapping(path = "/inmuebles")
public class InmuebleController {
	
	private InmuebleService inmuebleService;
	private ClienteService gestionClientes;
	
	@Autowired
	public InmuebleController(InmuebleService inmuebleService, ClienteService gestionClientes) {
		this.inmuebleService = inmuebleService;
		this.gestionClientes = gestionClientes;

	}		
	@GetMapping
	public List<Inmueble> getInmuebles(){

		 return inmuebleService.listado();
	 }	
	
	@GetMapping(path = "{idInmueble}")
	public Inmueble getInmueble(@PathVariable("idInmueble") Integer idInmueble){
		 return inmuebleService.buscar(idInmueble);
	 }
	
	@PostMapping(consumes = "application/json")
	public void registerInmueble(@RequestBody InmuebleDto inmuebleDto) {
		Cliente cliente = gestionClientes.buscar(inmuebleDto.getIdCliente());
		
		Inmueble inmuebleDao = new Inmueble();
		
		inmuebleDao.setActivo(inmuebleDto.isActivo());
		inmuebleDao.setCliente(cliente);
		inmuebleDao.setDescripcion(inmuebleDto.getDescripcion());
		inmuebleDao.setDireccion(inmuebleDto.getDireccion());
		inmuebleDao.setLocalidad(inmuebleDto.getLocalidad());
		inmuebleDao.setNumHabitaciones(inmuebleDto.getNumHabitaciones());
		inmuebleDao.setTipoVivienda(inmuebleDto.getTipoVivienda());
				
		inmuebleService.guardar(inmuebleDao);
		
	 }	

	@PutMapping(consumes = "application/json")
	public void changeInmueble(@RequestBody Inmueble inmueble) {		
		inmuebleService.actualizar(inmueble);
	}	
	
	@DeleteMapping("/{id}")
	public void deleteInmueble(@PathVariable Integer id) {
		inmuebleService.eliminar(id);
	}
	

}
