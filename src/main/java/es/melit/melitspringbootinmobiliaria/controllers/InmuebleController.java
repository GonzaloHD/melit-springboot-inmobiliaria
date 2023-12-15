package es.melit.melitspringbootinmobiliaria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.melit.melitspringbootinmobiliaria.bussiness.GestionInmuebles;
import es.melit.melitspringbootinmobiliaria.entities.Inmueble;

@RestController
@RequestMapping(path = "/api/inmobiliaria")
public class InmuebleController {
	
	private GestionInmuebles gestionInmuebles;
	
	@Autowired
	public InmuebleController(GestionInmuebles gestionInmuebles) {
		this.gestionInmuebles = gestionInmuebles;
	}	
	
	@GetMapping
	public List<Inmueble> getInmuebles(){
		 return gestionInmuebles.listadoInmuebles();
	 }	
	@PostMapping(consumes = "application/json")
	public void registerSeries(@RequestBody Inmueble inmueble) {
		gestionInmuebles.guardarInmueble(inmueble);
	}

}
