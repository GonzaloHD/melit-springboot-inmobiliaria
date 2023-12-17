package es.melit.melitspringbootinmobiliaria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.melit.melitspringbootinmobiliaria.entities.Inmueble;
import es.melit.melitspringbootinmobiliaria.service.InmuebleService;

@RestController
@RequestMapping(path = "/api/inmobiliaria/inmueble")
public class InmuebleController {
	
	private InmuebleService inmuebleService;
	
	@Autowired
	public InmuebleController(InmuebleService gestionInmuebles) {
		this.inmuebleService = gestionInmuebles;
	}	
	
	@GetMapping
	public List<Inmueble> getInmuebles(){
		 return inmuebleService.listadoInmuebles();
	 }
	
	@GetMapping(path = "{idInmueble}")
	public Inmueble getInmueble(@PathVariable("idInmueble") Integer idInmueble){
		 return inmuebleService.bucarInmueble(idInmueble);
	 }
	
	@PostMapping(consumes = "application/json")
	public void registrarInmueble(@RequestBody Inmueble inmueble) {
		inmuebleService.guardarInmueble(inmueble);
	}
	@PutMapping(consumes = "application/json")
	public void changeSeries(@RequestBody Inmueble inmueble) {		
		inmuebleService.actualizarInmueble(inmueble);	
	}	
	

}
