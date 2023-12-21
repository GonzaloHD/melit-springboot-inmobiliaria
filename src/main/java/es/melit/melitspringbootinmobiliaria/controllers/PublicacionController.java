package es.melit.melitspringbootinmobiliaria.controllers;

import java.time.Instant;
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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Publicaciones de inmuebles", description = "Operaciones sobre publicaciones. CRUD y busqueda de publicaciones")
@RequestMapping(path = "/publicaciones")
public class PublicacionController {	
	
	private PublicacionService publicacionService;
	private InmuebleService inmuebleService;	
	
	@Autowired
	public PublicacionController(PublicacionService publicacionService, InmuebleService inmuebleService) {
		this.publicacionService = publicacionService;
		this.inmuebleService = inmuebleService;
	}
	@Operation(
			summary = "Devuelve todas las publicaciones", 
			description = "Devuelve todas las publicaciones que se han registrado")
	@GetMapping
	public List<Publicacion> getPublicaciones(){
		 return publicacionService.listado();
	 }	
	@Operation(
			summary = "Modificar publicaciones", 
			description = "Devuelve todas las transacciones registradas")
	@PostMapping(consumes = "application/json")
	public void registrarPublicacion(@RequestBody PublicacionDto publicacionDto) {	
		
		Inmueble inmueble = inmuebleService.buscar(publicacionDto.getIdInmueble());
		Double coste = publicacionDto.getCoste();
		Instant fechaInicio = publicacionDto.getFechaInicio();
		Instant fechaFin = publicacionDto.getFechaFin();
		
		Publicacion publicacion = new Publicacion(inmueble, fechaInicio, fechaFin, coste);
		
		publicacionService.guardar(publicacion);
	 }
	
	@Operation(
			summary = "Devuelve publicación por id", 
			description = "Busqueda de publicación por id")
	@GetMapping(path = "{idPublicacion}")
	public Publicacion getPublicacion(@PathVariable("idPublicacion") Integer idPublicacion){
		 return publicacionService.buscar(idPublicacion);
	 }
	
	@Operation(
			summary = "Modificación de publicación", 
			description = "Para modificar coste de la publicación, resto de parámetros no son modificables por coherencia")
	@PutMapping(consumes = "application/json")
	public void cambiarPublicacion(@RequestBody Publicacion publicacion) {		
		publicacionService.actualizar(publicacion);
	}
	
	@Operation(
			summary = "Cerrar publicación", 
			description = "Introduce fecha final de publicación automaticamente al momento de cerrarla introduciendo id de la publicación a cerrar")
	@PutMapping(path = "{idPublicacion}")
	public Publicacion cerrarPublicacion(@PathVariable("idPublicacion") Integer idPublicacion) {		
		return publicacionService.cerrar(idPublicacion);
	}
	
}
