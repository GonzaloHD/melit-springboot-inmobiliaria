package es.melit.melitspringbootinmobiliaria.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.melit.melitspringbootinmobiliaria.bussiness.InmuebleService;
import es.melit.melitspringbootinmobiliaria.bussiness.PublicacionService;
import es.melit.melitspringbootinmobiliaria.dto.PublicacionDto;
import es.melit.melitspringbootinmobiliaria.entities.Inmueble;
import es.melit.melitspringbootinmobiliaria.entities.Publicacion;

@RestController
@RequestMapping(path = "/publicaciones")
public class PublicacionController {	
	
	private PublicacionService publicacionService;
	private InmuebleService inmuebleService;
	
	
	@Autowired
	public PublicacionController(PublicacionService publicacionService, InmuebleService inmuebleService) {
		this.publicacionService = publicacionService;
		this.inmuebleService = inmuebleService;
	}		
	@GetMapping
	public List<Publicacion> getPublicaciones(){
		 return publicacionService.listado();
	 }	
	
	@PostMapping(consumes = "application/json")
	public void registrarPublicacion(@RequestBody PublicacionDto publicacionDto) {	
		
		Inmueble inmueble = inmuebleService.buscar(publicacionDto.getIdInmueble());
		Double coste = publicacionDto.getCoste();
		Date fechaInicio = publicacionDto.getFechaInicio();
		Date fechaFin = publicacionDto.getFechaFin();
		
		Publicacion publicacion = new Publicacion(inmueble, fechaInicio, fechaFin, coste);
		
		publicacionService.guardar(publicacion);
	 }
	
	@GetMapping(path = "{idPublicacion}")
	public Publicacion getPublicacion(@PathVariable("idPublicacion") Integer idPublicacion){
		 return publicacionService.buscar(idPublicacion);
	 }

	@PutMapping(consumes = "application/json")
	public void cambiarPublicacion(@RequestBody Publicacion publicacion) {		
		publicacionService.actualizar(publicacion);
	}
	
}
